package sanctuary.model;



import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

/**
 * this class Manages the overall sanctuary,
 * including isolation areas and enclosures for different species
 */
public class Sanctuary {
    private Isolation isolation;
    private Map<Species, Enclosure> speciesToEnclosureMap;

    public Sanctuary() {
        this.isolation = new Isolation();
        this.speciesToEnclosureMap = new HashMap<>();
        for (Species species : Species.values()) {
            speciesToEnclosureMap.put(species, new Enclosure(species));
        }
    }

    /**
     * Admits a monkey to the isolation area.
     * @param monkey The monkey to be admitted to isolation.
     * @return boolean indicating if the monkey was successfully admitted.
     */
    public boolean admitMonkeyToIsolation(Monkey monkey) {
        return isolation.addMonkey(monkey);
    }

    /**
     * Transfers a monkey from isolation to the appropriate species-specific enclosure
     * @param monkeyName The name of the monkey to be transferred.
     */
    public void transferMonkeyToEnclosure(String monkeyName) {
        Monkey monkey = isolation.removeMonkey(monkeyName);
        if (monkey != null) {
            Enclosure enclosure = speciesToEnclosureMap.get(monkey.getSpecies());
            if (!enclosure.addMonkey(monkey)) {
                isolation.addMonkey(monkey);
            }
        } else {
            System.out.println("Monkey named " + monkeyName + " not found in isolation.");
        }
    }

    /**
     * Produces a list for every enclosure
     * that shows each individual monkey currently housed there.
     * @return A formatted string of all enclosures and their monkeys.
     */
    public String listEnclosureMonkeys() {
        return speciesToEnclosureMap.values().stream()
                .filter(enclosure -> !enclosure.getMonkeys().isEmpty()) // Optional: filter out empty enclosures
                .map(enclosure -> {
                    String enclosureHeader = "Enclosure for " + enclosure.getSpecies() + ":\n";
                    return enclosureHeader + enclosure.listMonkeys();
                })
                .collect(Collectors.joining("\n\n")); // Added an extra newline for better separation
    }


    /**
     * Produces an alphabetical list (by name) of all monkeys housed in the Sanctuary.
     * @return A formatted string of all monkeys in the sanctuary.
     */
    public String listAllMonkeys() {
        List<Monkey> allMonkeys = new ArrayList<>(isolation.getMonkeysInIsolation());

        speciesToEnclosureMap.values().forEach(enclosure -> allMonkeys.addAll(enclosure.getMonkeys()));

        return allMonkeys.stream()
                .sorted(Comparator.comparing(Monkey::getName))
                .map(Monkey::toString)
                .collect(Collectors.joining("\n"));
    }

    public Map<Species, Enclosure> getSpeciesToEnclosureMap() {
        return speciesToEnclosureMap;
    }

    public Isolation getIsolation() {
        return isolation;
    }

}
