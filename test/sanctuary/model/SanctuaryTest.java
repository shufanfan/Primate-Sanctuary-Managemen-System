package sanctuary.model;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SanctuaryTest {

    private Sanctuary sanctuary;
    private Monkey monkey1;
    private Monkey monkey2;

    @Before
    public void setUp() {
        // Set up the Sanctuary and a couple of Monkeys before each test
        sanctuary = new Sanctuary();
        monkey1 = new Monkey("George", Species.SPIDER, Sex.MALE, "Medium", 7.5, 5, Food.FRUITS);
        monkey2 = new Monkey("Zoe", Species.TAMARIN, Sex.FEMALE, "Small", 5.0, 3, Food.NUTS);
    }

    @Test
    public void testAdmitMonkeyToIsolation() {
        // Admit monkey to isolation
        assertTrue("Monkey should be admitted to isolation", sanctuary.admitMonkeyToIsolation(monkey1));
    }

    @Test
    public void testTransferMonkeyToEnclosure() {
        // First admit the monkey to isolation
        sanctuary.admitMonkeyToIsolation(monkey1);
        // Then try to transfer it to the enclosure
        sanctuary.transferMonkeyToEnclosure(monkey1.getName());
        // Check the enclosures list to confirm it has been transferred
        String enclosuresList = sanctuary.listEnclosureMonkeys();
        assertTrue("Enclosures list should contain monkey's name", enclosuresList.contains(monkey1.getName()));
    }



    @Test
    public void testListAllMonkeys() {
        // Admit monkeys to isolation
        sanctuary.admitMonkeyToIsolation(monkey1);
        sanctuary.admitMonkeyToIsolation(monkey2);
        // Transfer one monkey to its enclosure
        sanctuary.transferMonkeyToEnclosure(monkey1.getName());
        // The list should contain both monkeys, with the transferred one first (sorted by name)
        String allMonkeysList = sanctuary.listAllMonkeys();
        assertTrue("All monkeys list should contain both monkeys", allMonkeysList.contains(monkey1.getName()) && allMonkeysList.contains(monkey2.getName()));
    }
}
