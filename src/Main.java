import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        Ingredient ingredient = new Ingredient("Steak", "Tasty", FoodType.Meat, 100, 10);
        ingredient.addNutrient(Vitamins.A, 10);
        ingredient.addNutrient(Vitamins.B1, 30);
        ingredient.addNutrient(Vitamins.B2, 30);
        Recipe recipe = new Recipe("Medium Steak");
        recipe.calculationVitamin(ingredient, 300);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProfileManagerUI().setVisible(true);
            }
        });
    }
}