package sanctuary.model;



import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class IsolationTest {

    private Isolation isolation;
    private Monkey monkey1;
    private Monkey monkey2;

    @Before
    public void setUp() {
        // Initialize isolation and monkeys before each test
        isolation = new Isolation();
        monkey1 = new Monkey("George", Species.SPIDER, Sex.MALE, "Medium", 7.5, 10, Food.FRUITS);
        monkey2 = new Monkey("Zoe", Species.TAMARIN, Sex.FEMALE, "Small", 5.0, 8, Food.NUTS);
    }

    @Test
    public void testAddMonkey() {
        // Test adding a monkey when there is space
        assertTrue("Monkey should be added", isolation.addMonkey(monkey1));
        // Ensure the monkey is in isolation
        assertEquals("There should be one monkey in isolation", 1, isolation.getMonkeysInIsolation().size());
    }

    @Test
    public void testIsolationFull() {
        Isolation isolation = new Isolation();

        // Fill the isolation to capacity
        for (int i = 0; i < 20; i++) {
            try {
                assertTrue("Monkey should be added", isolation.addMonkey(new Monkey("Monkey" + i, Species.SPIDER, Sex.MALE, "Medium", 7.5, 10, Food.FRUITS)));
            } catch (IllegalStateException e) {
                fail("Isolation should not be full yet");
            }
        }

        // Test that adding another monkey throws IllegalStateException
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            isolation.addMonkey(new Monkey("ExtraMonkey", Species.SPIDER, Sex.MALE, "Medium", 7.5, 10, Food.FRUITS));
        });

        String expectedMessage = "Isolation is full. Cannot add more monkeys.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRemoveMonkey() {
        // Add a monkey and then remove it
        isolation.addMonkey(monkey1);
        Monkey removedMonkey = isolation.removeMonkey("George");
        assertNotNull("Removed monkey should not be null", removedMonkey);
        assertEquals("Removed monkey should be George", "George", removedMonkey.getName());
        // Ensure the monkey is no longer in isolation
        assertTrue("Isolation should be empty after removal", isolation.getMonkeysInIsolation().isEmpty());
    }

    @Test
    public void testRemoveNonExistentMonkey() {
        // Try to remove a monkey that was never added
        assertNull("Should not remove a non-existent monkey", isolation.removeMonkey("NonExistent"));
    }

    @Test
    public void testGetMonkeysInIsolation() {
        // Test that the returned list matches the monkeys in isolation
        isolation.addMonkey(monkey1);
        isolation.addMonkey(monkey2);
        List<Monkey> monkeysInIsolation = isolation.getMonkeysInIsolation();
        assertTrue("List should contain monkey1", monkeysInIsolation.contains(monkey1));
        assertTrue("List should contain monkey2", monkeysInIsolation.contains(monkey2));
        assertEquals("There should be two monkeys in isolation", 2, monkeysInIsolation.size());
    }
}
