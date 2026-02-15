import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FelineTest {

    @Test
    public void testEatMeatReturnsResultFromGetFood() throws Exception {
        Feline feline = spy(new Feline());
        List<String> expectedFood = List.of("Мясо");
        doReturn(expectedFood).when(feline).getFood("Хищник");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testEatMeatCallsGetFoodWithPredatorArgument() throws Exception {
        Feline feline = spy(new Feline());

        feline.eatMeat();

        verify(feline).getFood("Хищник");
    }

    @Test
    public void testGetFamilyReturnsCorrectFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefaultReturnsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameterReturnsGivenNumber() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void testDefaultConstructorCreatesObject() {
        Feline feline = new Feline();
        assertNotNull(feline);
    }

    @Test(expected = Exception.class)
    public void testEatMeatThrowsExceptionWhenGetFoodFails() throws Exception {
        Feline feline = spy(new Feline());
        doThrow(new Exception("Ошибка")).when(feline).getFood("Хищник");

        feline.eatMeat();
    }
}