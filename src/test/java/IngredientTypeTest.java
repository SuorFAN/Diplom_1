import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeValuesNotNull() {
        for (IngredientType type : IngredientType.values()) {
            assertNotNull(type);
        }
    }

    @Test
    public void ingredientTypeValuesCount() {
        assertEquals("Should have 2 values", 2, IngredientType.values().length);
    }
}