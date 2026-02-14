import com.example.Cat;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat() {
            @Override
            public List<String> eatMeat() {
                return List.of();
            }
        };
        List<String> expectedFood = Arrays.asList("Рыба", "Молоко");
        assertEquals(expectedFood, cat.getFood());
    }
}