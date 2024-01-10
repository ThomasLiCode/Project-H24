import java.util.ArrayList;
public class Recipe {
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private double[] nutrients = new double[12];
    private String name;
    private String description;
    private MealType mealType;
    private double calories;
    private double protein;

    public Recipe(String name){
        this.name = name;
    }
    public void addIngredient(Ingredient ingredient){ ingredients.add(ingredient); }
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
