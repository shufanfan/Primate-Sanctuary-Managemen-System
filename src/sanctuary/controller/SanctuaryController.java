package sanctuary.controller;

import sanctuary.model.*;
import sanctuary.view.SanctuaryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code SanctuaryController} class represents the controller in the MVC pattern for a sanctuary management application.
 * It orchestrates interactions between the model ({@code Sanctuary}) and the view ({@code SanctuaryView}) components.
 * It listens to actions performed in the view and updates the model and view accordingly.
 */
public class SanctuaryController {
    private SanctuaryView theView;
    private Sanctuary sanctuaryModel;
    private Monkey monkeyModel;
    private Food food;
    private Species species;
    private Sex sex;

    /**
     * Constructs a SanctuaryController object with a given view and model.
     * It initializes the controller with the specified sanctuary view and model, and sets up action listeners for the view's buttons.
     *
     * @param theView the sanctuary view component of the MVC pattern.
     * @param sanctuaryModel the sanctuary model component of the MVC pattern.
     */
    public SanctuaryController(SanctuaryView theView, Sanctuary sanctuaryModel) {
        this.theView = theView;
        this.sanctuaryModel = sanctuaryModel;
        this.theView.addAddButtonListener(new AddButtonListener());
        this.theView.addTransferButtonListener(new TransferButtonListener());
    }


    class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String name = theView.getMonkeyName();
                Species species = theView.getSelectedSpecies();
                Sex sex = theView.getSelectedSex();
                Food favoriteFood = theView.getSelectedFood();
                String size = theView.getSelectedSize();
                int age = theView.getAge();
                double weight = theView.getWeight();

                Monkey newMonkey = new Monkey(name, species, sex, size, weight, age, favoriteFood);
                // Try to add the monkey to isolation
                sanctuaryModel.getIsolation().addMonkey(newMonkey);
                // If successful, clear inputs and update the list
                theView.clearInputs();
                updateViewsAfterMonkeyAdded();
            } catch (IllegalStateException ise) {
                // Handle the case where isolation is full
                theView.displayErrorMessage("No room in isolation for new monkeys.");
            } catch (Exception ex) {
                theView.displayErrorMessage("Error adding monkey: " + ex.getMessage());
            }
        }
    }

    private void updateViewsAfterMonkeyAdded() {
        // Assume these two methods retrieve the updated lists from the model and display them
        String enclosureMonkeysList = sanctuaryModel.listEnclosureMonkeys();
        theView.updateEnclosureList(enclosureMonkeysList);

        String allMonkeysList = sanctuaryModel.listAllMonkeys();
        theView.updateAlphabeticalMonkeyList(allMonkeysList);
    }


    class TransferButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                // Assuming you have a way to select the monkey to be transferred, e.g., by name
                String monkeyName = theView.getMonkeyName(); // You need to implement this method in your view

                // Attempt to transfer the monkey
                if (attemptMonkeyTransfer(monkeyName)) {
                    // If transfer was successful, update the views
                    updateViews();
                } else {
                    // If transfer was unsuccessful, show an error message
                    theView.displayErrorMessage("Failed to transfer monkey.");
                }
            } catch (Exception ex) {
                theView.displayErrorMessage("Error transferring monkey: " + ex.getMessage());
            }
        }

        private boolean attemptMonkeyTransfer(String monkeyName) {
            // Logic to remove the monkey from isolation
            Monkey monkey = sanctuaryModel.getIsolation().removeMonkey(monkeyName);
            if (monkey == null) {
                theView.displayErrorMessage("Monkey named " + monkeyName + " not found in isolation.");
                return false;
            }

            // Attempt to find a suitable enclosure based on the monkey's species
            Enclosure suitableEnclosure = findSuitableEnclosureForMonkey(monkey);
            if (suitableEnclosure == null) {
                theView.displayErrorMessage("No suitable enclosure found for " + monkeyName + ".");
                sanctuaryModel.getIsolation().addMonkey(monkey); // Optionally add back to isolation
                return false;
            }

            // Try to add the monkey to the enclosure
            return suitableEnclosure.addMonkey(monkey);
        }

        private Enclosure findSuitableEnclosureForMonkey(Monkey monkey) {
            // Directly access the enclosure for the monkey's species from the map
            Enclosure suitableEnclosure = sanctuaryModel.getSpeciesToEnclosureMap().get(monkey.getSpecies());
            // If the enclosure exists and can accommodate the monkey, return it
            if (suitableEnclosure != null && suitableEnclosure.canAccommodateMonkey(monkey)) {
                return suitableEnclosure;
            }
            // If no suitable enclosure is found, return null
            return null;
        }



        private void updateViews() {
            // Fetch and update the enclosure-specific list
            String enclosureList = sanctuaryModel.listEnclosureMonkeys();
            theView.updateEnclosureList(enclosureList);

            // Fetch and update the alphabetical list of all monkeys
            String allMonkeysList = sanctuaryModel.listAllMonkeys();
            theView.updateAlphabeticalMonkeyList(allMonkeysList);
        }


    }
}
