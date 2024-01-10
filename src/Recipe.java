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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
