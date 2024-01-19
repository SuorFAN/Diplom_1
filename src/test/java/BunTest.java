import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("kunghut", 33);
        assertEquals("kunghut", bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("falafel", 170);
        assertEquals(170, bun.getPrice(), 0.01);
    }
}
