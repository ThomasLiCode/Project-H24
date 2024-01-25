import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private ArrayList<String> allergies = new ArrayList<>();
    private MealType restriction = MealType.UNRESTRICTED;
    private MealType validMeals;
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public User()
    {
        this.username = "";
        this.password = "";
        this.validMeals = MealType.UNRESTRICTED;

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.validMeals = MealType.UNRESTRICTED;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String newPassword) {
        this.password = password;
    }
    public void addRecipe(Recipe recipe) { this.recipes.add(recipe); }
    public Recipe getRecipe(int index) { return this.recipes.get(index); }
    public void addIngredient(Ingredient ingredient) { this.ingredients.add(ingredient); }
    public Ingredient getIngredient(int index) { return this.ingredients.get(index); }

    public void setRestriction(MealType restriction) { this.restriction = restriction; }
    public MealType getRestriction() { return this.restriction; }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }

    public void addAllergy(String allergy) {
        String polished = allergy.trim().toLowerCase();
        allergies.add(polished);
    }

    public void setValidMeals(String validMeals)
    {
        String polish = validMeals.trim().toLowerCase();
        if(polish.equals("vegan"))
        {
            this.validMeals = MealType.VEGAN;
        }
        else if(polish.equals("vegetarian"))
        {
            this.validMeals = MealType.VEGETARIAN;
        }
        else
        {
            this.validMeals = MealType.UNRESTRICTED;
        }
    }

    public void removeAllergy(String allergy) {
        allergies.remove(allergy);
    }

    public boolean hasAllergy(String allergy) {
        return allergies.contains(allergy);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", allergies=" + Arrays.toString(allergies.toArray()) +
                '}';
    }


    public static User loadFromFile(String fileName) {

        try {
            Scanner sc = new Scanner(new FileReader(fileName));


            // handle account details
            String[] accountDetails = sc.nextLine().split(" ");
            if (accountDetails.length != 2) throw new RuntimeException();

            User user = new User(accountDetails[0], accountDetails[1]);

            // 0 -> Allergies
            // 1 -> Restrictions
            // 2 -> Recipes / Ingredients
            int currentLoadingState = 0;

            while (sc.hasNextLine()) {
                String[] input = sc.nextLine().split(" ");
                if (input.length < 2) throw new RuntimeException();

                switch (input[0]) {
                    case "allergy":
                        for (int i = 1; i < input.length; i++) user.addAllergy(input[i]);
                        currentLoadingState++;
                        break;
                    case "restriction":
                        if (currentLoadingState < 1) currentLoadingState = 1;
                        else if (currentLoadingState > 1) throw new RuntimeException();

                        user.setRestriction(MealType.valueOf(input[1].toUpperCase()));
                        currentLoadingState++;
                        break;
                    case "recipe":
                        currentLoadingState = 2;

                        Recipe recipe = new Recipe(input[2]);
                        recipe.setDescription(input[3]);
                        recipe.setMealType(MealType.valueOf(input[4].toUpperCase()));

                        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
                            String[] inp = sc.nextLine().split(" ");
                            Ingredient ing = parseIngredient(inp);
                            double portion = Double.parseDouble(inp[18]);

                            user.addIngredient(ing);
                            recipe.addIngredient(ing, portion);
                        }

                        user.addRecipe(recipe);
                        break;
                    case "ingredient":
                        currentLoadingState = 2;
                        Ingredient ing = parseIngredient(input);

                        user.addIngredient(ing);
                }


            }

            return user;

        } catch (Exception e) {
            throw new RuntimeException("Couldn't parse file");
        }
    }

    private static Ingredient parseIngredient(String[] input) {
        Ingredient ingredient = new Ingredient(input[1], input[2], FoodType.valueOf(input[3].toUpperCase()), Double.parseDouble(input[16]), Double.parseDouble(input[17]));

        int i = 4;
        for (Vitamins vitamin : Vitamins.values()) {
            ingredient.addNutrient(vitamin, Double.parseDouble(input[i]));
            i++;
        }

        return ingredient;
    }
}
