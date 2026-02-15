import com.example.Lion;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expectedMane;

    public LionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, ожидаемая грива: {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveManeReturnsCorrectValue() throws Exception {
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    public void testGetFoodReturnsResultFromFeline() throws Exception {
        Feline mockFeline = mock(Feline.class);
        List<String> expectedFood = List.of("Мясо");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", mockFeline);
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsFelineGetFoodWithPredatorArgument() throws Exception {
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion("Самец", mockFeline);

        lion.getFood();

        verify(mockFeline, times(1)).getFood("Хищник");
    }
}