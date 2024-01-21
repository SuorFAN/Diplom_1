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
public class BurgerGetReceiptParametrizedTest {

    private final Burger burger;
    private final String expectedReceipt;

    public BurgerGetReceiptParametrizedTest(Burger burger, String expectedReceipt) {
        this.burger = burger;
        this.expectedReceipt = expectedReceipt;
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
                {burger1, "(==== MockBun ====)" + System.lineSeparator() +
                        "= sauce Ketchup =" + System.lineSeparator() +
                        "(==== MockBun ====)" + System.lineSeparator() + System.lineSeparator() +
                        "Price: 683,000000" + System.lineSeparator()},
                {burger2, "(==== MockBun ====)" + System.lineSeparator() +
                        "= filling Cheese =" + System.lineSeparator() +
                        "(==== MockBun ====)" + System.lineSeparator() + System.lineSeparator() +
                        "Price: 660,000000" + System.lineSeparator()},
        });
    }

    @Test
    public void getReceipt() {
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }

}