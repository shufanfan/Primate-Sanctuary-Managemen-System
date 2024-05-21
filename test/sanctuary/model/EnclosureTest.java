package sanctuary.model;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnclosureTest {

    private Enclosure enclosure;
    private Monkey monkey1;
    private Monkey monkey2;

    @Before
    public void setUp() {
        // Set up for tests; this method runs before each test method
        enclosure = new Enclosure(Species.SPIDER);
        monkey1 = new Monkey("George", Species.SPIDER, Sex.MALE, "Medium", 10.0, 5, Food.FRUITS);
        monkey2 = new Monkey("Martha", Species.SPIDER, Sex.FEMALE, "Small", 8.0, 4, Food.LEAVES);
    }

    @Test
    public void testAddMonkeyMatchingSpecies() {
        // Testing the addition of a monkey with a matching species
        assertTrue("Monkey with matching species should be added", enclosure.addMonkey(monkey1));
        // Verify the monkey is indeed in the enclosure
        assertEquals("Enclosure should contain the added monkey", 1, enclosure.getMonkeys().size());
        assertTrue("The list should contain monkey1", enclosure.getMonkeys().contains(monkey1));
    }

    @Test
    public void testAddMonkeyNonMatchingSpecies() {
        // Trying to add a monkey with a non-matching species should fail
        Monkey monkeyNotMatching = new Monkey("Alex", Species.HOWLER, Sex.MALE, "Large", 15.0, 6, Food.SEEDS);
        assertFalse("Monkey with non-matching species should not be added", enclosure.addMonkey(monkeyNotMatching));
        // Verify the enclosure is still empty
        assertTrue("Enclosure should not contain any monkeys", enclosure.getMonkeys().isEmpty());
    }

    @Test
    public void testListMonkeys() {
        // Add a couple of monkeys and test the list
        enclosure.addMonkey(monkey1);
        enclosure.addMonkey(monkey2);

        String expectedList = monkey1.toString() + "\n" + monkey2.toString();
        assertEquals("List of monkeys should match expected string", expectedList, enclosure.listMonkeys());
    }
}
