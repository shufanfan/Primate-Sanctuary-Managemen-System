package sanctuary.model;


import org.junit.Test;
import static org.junit.Assert.*;

public class MonkeyTest {

    @Test
    public void testMonkeyConstructorAndGetters() {

        Monkey monkey = new Monkey("George", Species.SPIDER, Sex.MALE, "Medium", 7.5, 10, Food.FRUITS);


        assertEquals("Name should be George", "George", monkey.getName());
        assertEquals("Species should be SPIDER", Species.SPIDER, monkey.getSpecies());
        assertEquals("Sex should be Male", "Male", monkey.getSex());
        assertEquals("Size should be Medium", "Medium", monkey.getSize());
        assertEquals("Weight should be 7.5", 7.5, monkey.getWeight(), 0.001); // delta provided for double comparison
        assertEquals("Age should be 10", 10, monkey.getAge());
        assertEquals("Favorite food should be FRUIT", Food.FRUITS, monkey.getFavoriteFood());
    }

    @Test
    public void testToString() {

        Monkey monkey = new Monkey("Zoe", Species.TAMARIN, Sex.FEMALE, "Small", 5.0, 8, Food.NUTS);


        String expectedString = "Name: Zoe, Sex: Female, Favorite Food: NUTS";
        assertEquals("toString should return the correct string", expectedString, monkey.toString());
    }
}
