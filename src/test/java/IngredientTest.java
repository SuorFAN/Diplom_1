import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "meat", 70);
        assertEquals(70, ingredient.getPrice(), 0.01);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "ketchup", 20);
        assertEquals("ketchup", ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "salad", 30);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}