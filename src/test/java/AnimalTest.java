import com.example.Animal;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testGetFoodCorrectTypeHedge() throws Exception {
        Animal animal = new Animal("Хищник");
        assertEquals(List.of("Мясо"), animal.getFood("Хищник"));
    }

    @Test
    public void testGetFoodCorrectTypeHerbivore() throws Exception {
        Animal animal = new Animal("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
    }

    @Test
    public void testGetFoodIncorrectType() {
        Animal animal = new Animal("НекорректноеТип");
        try {
            animal.getFood("НекорректноеТип");
            fail("Expected Exception");
        } catch (Exception e) {
            assertEquals("Неизвестный тип животного", e.getMessage());
        }
    }

    @Test
    public void testGetFoodNullType() {
        Animal animal = new Animal(null);
        try {
            animal.getFood(null);
            fail("Expected Exception");
        } catch (Exception e) {
            assertEquals("Некорректный тип животного", e.getMessage());
        }
    }

    @Test
    public void testGetFoodEmptyString() {
        Animal animal = new Animal("");
        try {
            animal.getFood("");
            fail("Expected Exception");
        } catch (Exception e) {
            assertEquals("Некорректный тип животного", e.getMessage());
        }
    }
    @Test
    public void testGetFamilyString() {
        Animal animal = new Animal("Любой тип");
        String familyString = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", familyString);
    }
}