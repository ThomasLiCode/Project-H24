import java.util.ArrayList;
public class Recipe {
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private ArrayList<Double> portions = new ArrayList<>();
    private double[] nutrients = new double[13];
    private String name;
    private String description;
    private MealType mealType;
    private double calories;
    private double protein;

    public Recipe(String name){
        this.name = name;
    }
    public void addIngredient(Ingredient ingredient, double portion){
        ingredients.add(ingredient);
        portions.add(portion);
    }

    public void calculationVitamin(Ingredient ingredient, double portion){
        int iter = 0;
        for(Vitamins vitamin: Vitamins.values()){
            nutrients[iter] = (ingredient.getNutrientAmount(vitamin)/100) * portion;
            System.out.println(nutrients[iter]);
            iter++;
        }
    }

    public double calculationProteinHelper(Ingredient ingredient, double portion)
    {
        double result = (ingredient.getProteinPer100() / 100) * portion;
        return result;
    }

    public void calculationProtein()
    {
        for(int i = 0 ; i < ingredients.size() ; i++)
        {
            this.protein += calculationCaloriesHelper(ingredients.get(i), portions.get(i));
        }
    }

    public double calculationCaloriesHelper(Ingredient ingredient, double portion)
    {
        double result = (ingredient.getCaloriesPer100() / 100) * portion;
        return result;
    }

    public void calculationCalories()
    {
        for(int i = 0 ; i < ingredients.size() ; i++)
        {
            this.calories += calculationCaloriesHelper(ingredients.get(i), portions.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMealType(MealType mealType){ this.mealType = mealType; }

    public MealType getMealType() { return this.mealType; }

    public double getProtein() { return this.protein; }

    public double getCalories() { return this.calories; }

    public void add(Ingredient ingredient, double portion)
    {
        switch(mealType)
        {
            case Vegan:
                if(ingredient.getFoodType() == FoodType.Dairy || ingredient.getFoodType() == FoodType.Meat)
                {
                    System.out.println("You can't add this");
                }
                else
                {
                    this.ingredients.add(ingredient);
                    this.portions.add(portion);
                    calculationProtein();
                    calculationCalories();
                }
                break;

            case Vegetarian:
                if(ingredient.getFoodType() == FoodType.Meat)
                {
                    System.out.println("You can't add this");
                }
                else
                {
                    this.ingredients.add(ingredient);
                    this.portions.add(portion);
                    calculationProtein();
                    calculationCalories();
                }
                break;

            case Unrestricted:
                this.ingredients.add(ingredient);
                this.portions.add(portion);
                calculationProtein();
                calculationCalories();
                break;
        }
    }

    // public void saveRecipe(){  } need to create a file in order to save

}
