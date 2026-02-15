import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    @Test
    public void testGetFoodReturnsResultFromEatMeat() throws Exception {
        Feline mockFeline = mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(mockFeline);
        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        Feline mockFeline = mock(Feline.class);
        Cat cat = new Cat(mockFeline);

        cat.getFood();

        verify(mockFeline, times(1)).eatMeat();
    }

    @Test
    public void testGetSoundReturnsMeow() {
        Cat cat = new Cat(mock(Feline.class));
        assertEquals("Мяу", cat.getSound());
    }
}