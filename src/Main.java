import javax.swing.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner save = new Scanner(new FileReader(saveFile));
        User newUser = new User();
        try
        {
            String firstLine = save.nextLine();
            String[] stats = firstLine.split(" ");
            User newUser = new User(stats[0], stats[1]);
            for(int i = 2 ; i < stats.length ; i++)
            {
                newUser.addAllergy(stats[i]);
            }
//            while(save.hasNextLine()) Loops to get all ingredients and recipes
        }

        Ingredient ingredient = new Ingredient("Steak", "Tasty", FoodType.Meat, 100, 10);
        ingredient.addNutrient(Vitamins.A, 10);
        ingredient.addNutrient(Vitamins.B1, 30);
        ingredient.addNutrient(Vitamins.B2, 30);
        Recipe recipe = new Recipe("Medium Steak");
        recipe.calculationVitamin(ingredient, 300);

        ArrayList<Recipe> meals = new ArrayList<Recipe>();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProfileManagerUI().setVisible(true);
            }
        });
    }
}