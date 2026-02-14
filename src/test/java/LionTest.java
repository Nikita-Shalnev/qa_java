import com.example.Lion;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private String sex;
    private boolean expectedMane;

    public LionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters(name = "Тестовые данные: пол={0}, ожидаемая грива={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testLionConstructorAndGetFood() throws Exception {
        // Мокаем Feline
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getFood()).thenReturn(Arrays.asList("Мясо"));
        // Создаем Льва через инъекцию
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expectedMane, lion.hasMane());
        List<String> food = lion.getFood();
        assertEquals(Arrays.asList("Мясо"), food);
        verify(mockFeline).getFood();
    }
    @Test
    public void testHasManeReturnsCorrectValue () throws Exception {
        Feline feline = mock(Feline.class);

        // Тест для самца
        Lion lionMale = new Lion("Самец", feline);
        assertTrue(lionMale.hasMane());

        // Тест для самки
        Lion lionFemale = new Lion("Самка", feline);
        assertFalse(lionFemale.hasMane());
    }
}