import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(Parameterized.class)
public class BurgerGetPriceParametrizedTest {

    private final Burger burger;
    private final float expectedPrice;

    public BurgerGetPriceParametrizedTest(Burger burger, float expectedPrice) {
        this.burger = burger;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Burger burger1 = new Burger();
        Bun bun1 = mock(Bun.class);
        when(bun1.getName()).thenReturn("MockBun");
        when(bun1.getPrice()).thenReturn(330.0f);
        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("Ketchup");
        burger1.setBuns(bun1);
        burger1.addIngredient(ingredient1);
        when(ingredient1.getPrice()).thenReturn(23.0f);

        Burger burger2 = new Burger();
        Bun bun2 = mock(Bun.class);
        when(bun2.getName()).thenReturn("MockBun");
        when(bun2.getPrice()).thenReturn(300.0f);
        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("Cheese");
        when(ingredient1.getPrice()).thenReturn(23.0f);
        burger2.setBuns(bun1);
        burger2.addIngredient(ingredient2);

        return Arrays.asList(new Object[][]{
                {burger1, 683f},
                {burger2, 660f},
                // Add more test cases as needed
        });
    }

    @Test
    public void getPrice() {

        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01);
    }

}