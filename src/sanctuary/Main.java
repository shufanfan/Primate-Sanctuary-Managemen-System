package sanctuary;

import sanctuary.controller.SanctuaryController;
import sanctuary.model.*;
import sanctuary.view.SanctuaryView;

public class Main {
    public static void main(String[] args) {
        // Set up the main application components (view and model)
        SanctuaryView theView = new SanctuaryView();
        Sanctuary theModel = new Sanctuary();

        // Pass the view and model to the controller. You don't need to pass the defaultMonkey or enums.
        SanctuaryController theController = new SanctuaryController(theView, theModel);

        // Initialize the GUI on the event dispatch thread for thread safety
        javax.swing.SwingUtilities.invokeLater(() -> {
            theView.setVisible(true);
        });
    }
}
