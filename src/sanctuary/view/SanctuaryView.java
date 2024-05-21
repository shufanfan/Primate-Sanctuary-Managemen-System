package sanctuary.view;

import sanctuary.model.Food;
import sanctuary.model.Sex;
import sanctuary.model.Species;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;



/**
 * The {@code SanctuaryView} class represents the graphical user interface for the sanctuary management application.
 * It extends {@code JFrame} and includes input fields, selection boxes, and buttons for managing monkeys within a sanctuary.
 */
public class SanctuaryView extends JFrame {
    private JTextField nameField = new JTextField(10);
    private JTextField ageField = new JTextField(10);
    private JTextField weightField = new JTextField(10);

    private JComboBox<Species> speciesBox = new JComboBox<>(Species.values());
    private JComboBox<Sex> sexBox = new JComboBox<>(Sex.values());
    private JComboBox<Food> favoriteFoodBox = new JComboBox<>(Food.values());
    private String[] sizes = {"Small", "Medium", "Large", "Extra Large"};
    private JComboBox<String> sizeBox = new JComboBox<>(sizes);
    private JButton addButton = new JButton("Add to Isolation");
    private JButton transferButton = new JButton("Transfer to Enclosure");
    private JTextArea alphabeticallyListArea = new JTextArea(15, 30);
    private JTextArea enclosureListArea = new JTextArea(15, 30);

    /**
     * Constructs a SanctuaryView object which sets up the GUI for the sanctuary management.
     * It initializes all UI components and arranges them within the frame.
     */
    public SanctuaryView() {
        super("Sanctuary Management"); // Title for the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600); // Set the initial size of the frame

        // Layout for the main content pane
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));

        // Name input
        JPanel namePanel = createPanel(new JLabel("Name:"), nameField);
        JPanel agePanel = createPanel(new JLabel("Age:"), ageField);
        JPanel weightPanel = createPanel(new JLabel("Weight(lb):"), weightField);
        // Species selection
        JPanel speciesPanel = createPanel(new JLabel("Species:"), speciesBox);
        JPanel sizePanel = createPanel(new JLabel("Size:"), sizeBox);
        // Sex selection
        JPanel sexPanel = createPanel(new JLabel("Sex:"), sexBox);

        // Favorite food selection
        JPanel foodPanel = createPanel(new JLabel("Favorite Food:"), favoriteFoodBox);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(addButton);
        buttonPanel.add(transferButton);

        // Text area
        alphabeticallyListArea.setEditable(false);
        JScrollPane alphabeticalScrollPane = new JScrollPane(alphabeticallyListArea);
        alphabeticalScrollPane.setPreferredSize(new Dimension(550, 200));
        enclosureListArea.setEditable(false);
        JScrollPane enclosureScrollPane = new JScrollPane(enclosureListArea);
        enclosureScrollPane.setPreferredSize(new Dimension(550, 200));



        // Add panels to the main container
        mainContainer.add(namePanel);
        mainContainer.add(agePanel);
        mainContainer.add(weightPanel);
        mainContainer.add(speciesPanel);
        mainContainer.add(sizePanel);
        mainContainer.add(sexPanel);
        mainContainer.add(foodPanel);
        mainContainer.add(buttonPanel);
        mainContainer.add(new JLabel("Alphabetical List of Monkeys:"));
        mainContainer.add(alphabeticalScrollPane);
        mainContainer.add(new JLabel("List of Monkeys by Enclosure:"));
        mainContainer.add(enclosureScrollPane);

        this.pack(); // Pack the frame (size the frame so all its contents are at or above their preferred sizes)
    }

    private JPanel createPanel(JLabel label, JComponent component) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(label);
        panel.add(component);
        return panel;
    }


    /**
     * Registers an ActionListener for the "Add to Isolation" button.
     *
     * @param listenForAddButton the ActionListener to be added to the add button.
     */
    public void addAddButtonListener(ActionListener listenForAddButton) {
        addButton.addActionListener(listenForAddButton);
    }


    /**
     * Registers an ActionListener for the "Transfer to Enclosure" button.
     *
     * @param listenForTransferButton the ActionListener to be added to the transfer button.
     */
    public void addTransferButtonListener(ActionListener listenForTransferButton) {
        transferButton.addActionListener(listenForTransferButton);
    }



    /**
     * Displays an error message dialog with the specified message.
     *
     * @param errorMessage the error message to be displayed.
     */
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Input retrieval methods
    public String getMonkeyName() {
        return nameField.getText();
    }

    public Integer getAge() {
        try {
            return Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            displayErrorMessage("Please enter a valid age.");
            return null;
        }
    }

    public Double getWeight() {
        try {
            return Double.parseDouble(weightField.getText());
        } catch (NumberFormatException e) {
            displayErrorMessage("Please enter a valid weight.");
            return null;
        }
    }



    public Species getSelectedSpecies() {
        return (Species) speciesBox.getSelectedItem();
    }

    public Sex getSelectedSex() {
        return (Sex) sexBox.getSelectedItem();
    }

    public Food getSelectedFood() {
        return (Food) favoriteFoodBox.getSelectedItem();
    }

    public String getSelectedSize() {
        return (String) sizeBox.getSelectedItem();
    }

    /**
     * Clears input fields in the GUI.
     */
    public void clearInputs() {
        nameField.setText("");
        ageField.setText("");
        weightField.setText("");
    }

    /**
     * Updates the list of monkeys in enclosures.
     *
     * @param data the string representation of monkeys in enclosures to be displayed.
     */
    public void updateEnclosureList(String data) {
        enclosureListArea.setText(data);
    }


    /**
     * Updates the alphabetical list of all monkeys.
     *
     * @param data the string representation of all monkeys to be displayed alphabetically.
     */
    public void updateAlphabeticalMonkeyList(String data) {
        alphabeticallyListArea.setText(data);
    }

}

