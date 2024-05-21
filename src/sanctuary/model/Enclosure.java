package sanctuary.model;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this class represents an enclosure in the sanctuary
 * which is designated for a specific species of monkey
 */
public class Enclosure {
    private Species species;
    private List<Monkey> monkeys;

    public Enclosure(Species species) {
        this.species = species;
        this.monkeys = new ArrayList<>();
    }


    /**
     * Gets the species this enclosure is designated for
     * @return The species of the enclosure
     */
    public Species getSpecies() {
        return species;
    }


    public boolean canAccommodateMonkey(Monkey monkey) {
        if (!this.species.equals(monkey.getSpecies())) {
            return false;
        }
        return true;
    }

    /**
     * Adds a monkey to the enclosure if it matches the enclosure's species
     * @param monkey The monkey to be added.
     * @return boolean indicating if the monkey was successfully added.
     */
    public boolean addMonkey(Monkey monkey) {
        if (monkey.getSpecies() == this.species) {
            monkeys.add(monkey);
            return true;
        } else {
            System.out.println("The monkey's species does not match the enclosure's species.");
            return false;
        }
    }

    /**
     * Provides a list of all monkeys currently in the enclosure
     * @return A list of monkeys in the enclosure.
     */
    public List<Monkey> getMonkeys() {
        return new ArrayList<>(monkeys);
    }

    /**
     * Returns a string representation of monkeys currently housed in the enclosure,
     * including their name, sex, and favorite food
     * @return A formatted string of monkeys in the enclosure.
     */
    public String listMonkeys() {
        return monkeys.stream()
                .map(Monkey::toString)
                .collect(Collectors.joining("\n"));
    }
}

