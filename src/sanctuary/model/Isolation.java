package sanctuary.model;



import java.util.ArrayList;
import java.util.List;

/**
 * this class represents the isolation area in the sanctuary
 * where new monkeys are kept initially
 * or when they need medical attention
 */

public class Isolation {
    private List<Monkey> cages;
    private static final int MAX_CAPACITY = 20;

    public Isolation() {
        this.cages = new ArrayList<>();
    }

    /**
     * Adds a monkey to the isolation area if there is space available
     * @param monkey The monkey to be added.
     * @return boolean indicating if the monkey was successfully added.
     */
    public boolean addMonkey(Monkey monkey) {
        if (cages.size() >= MAX_CAPACITY) {
            throw new IllegalStateException("Isolation is full. Cannot add more monkeys.");
        }
        cages.add(monkey);
        return true;
    }

    /**
     * Removes and returns a monkey from the isolation area based on its name.
     *
     * @param monkeyName The name of the monkey to be removed.
     * @return The removed monkey if found, null otherwise.
     */
    public Monkey removeMonkey(String monkeyName) {
        for (Monkey monkey : cages) {
            if (monkey.getName().equals(monkeyName)) {
                cages.remove(monkey);
                return monkey;
            }
        }
        return null;
    }

    /**
     * Provides a list of all monkeys currently in isolation.
     * @return A list of monkeys in isolation.
     */
    public List<Monkey> getMonkeysInIsolation() {
        return new ArrayList<>(cages);
    }
}
