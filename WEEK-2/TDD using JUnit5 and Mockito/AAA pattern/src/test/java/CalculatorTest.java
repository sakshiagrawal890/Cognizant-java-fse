import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    // Setup Method (Executes before each test)
    @Before
    public void setUp() {
        System.out.println("[SETUP] Initializing Calculator instance before test...");
        // Arrange phase (Common setup)
        calculator = new Calculator();
    }

    // Teardown Method (Executes after each test)
    @After
    public void tearDown() {
        System.out.println("[TEARDOWN] Cleaning up resources after test...\n");
        calculator = null;
    }

    @Test
    public void testAdd() {
        System.out.println("[TEST] Running testAdd...");
        
        // Arrange
        int a = 10;
        int b = 5;
        
        // Act
        int result = calculator.add(a, b);
        
        // Assert
        assertEquals("10 + 5 should equal 15", 15, result);
    }

    @Test
    public void testSubtract() {
        System.out.println("[TEST] Running testSubtract...");
        
        // Arrange
        int a = 10;
        int b = 5;
        
        // Act
        int result = calculator.subtract(a, b);
        
        // Assert
        assertEquals("10 - 5 should equal 5", 5, result);
    }
}
