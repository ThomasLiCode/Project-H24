import java.util.ArrayList;
import java.util.HashMap;

public class Ingredient {

    private String name;
    private String description;
    private FoodType foodType;
    private HashMap<String, Double> nutrients = new HashMap<>();
    private double caloriesPer100;
    private double proteinPer100;
    private double portion;

    public Ingredient(String name, String description, FoodType foodType, double caloriesPer100, double proteinPer100, double portion) {
        this.name = name;
        this.description = description;
        this.foodType = foodType;
        this.caloriesPer100 = caloriesPer100;
        this.proteinPer100 = proteinPer100;
        this.portion = portion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNutrient(String nutrient, double amount) {
        nutrients.put(nutrient, amount);
    }

    public void removeNutrient(String nutrient) {
        nutrients.remove(nutrient);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public double getCaloriesPer100() {
        return caloriesPer100;
    }

    public void setCaloriesPer100(double caloriesPer100) {
        this.caloriesPer100 = caloriesPer100;
    }

    public double getProteinPer100() {
        return proteinPer100;
    }

    public void setProteinPer100(double proteinPer100) {
        this.proteinPer100 = proteinPer100;
    }

    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        this.portion= portion;
    }
    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", foodType=" + foodType +
                ", nutrients=[" + nutrients.keySet().stream().map((key) -> key + ": " + nutrients.get(key) + ", ") + "]" +
                ", caloriesPer100=" + caloriesPer100 +
                ", proteinPer100=" + proteinPer100 +
                '}';
    }
}
