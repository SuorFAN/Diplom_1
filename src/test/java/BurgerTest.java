import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    Burger burger;
    Bun bun;
    Ingredient ingredientOne;
    Ingredient ingredientTwo;

    @Before
    public void setUp() {
        burger = new Burger();
        ingredientOne = mock(Ingredient.class);
        ingredientTwo = mock(Ingredient.class);
        bun = mock(Bun.class);
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertSame(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredientOne);
        assertTrue(burger.ingredients.contains(ingredientOne));

    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(burger.ingredients.lastIndexOf(ingredientOne));
        assertFalse(burger.ingredients.contains(ingredientOne));
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        burger.moveIngredient(burger.ingredients.lastIndexOf(ingredientOne), burger.ingredients.lastIndexOf(ingredientTwo));

        assertEquals(ingredientOne, burger.ingredients.get(1));
        assertEquals(ingredientTwo, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        float price = 10F;
        when(bun.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        assertEquals(price*2, burger.getPrice(),0.01);
    }

    @Test
    public void getReceipt() {

    }

}
