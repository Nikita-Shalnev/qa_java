import com.example.Feline;
import com.example.Lion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

public class LionInValidTest {

    @Test
    public void testLionInValidSex() throws Exception {
        Feline mockFeline = mock(Feline.class);
        try {
            new Lion("НекорректныйПол", mockFeline);
            fail("Expected Exception");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}