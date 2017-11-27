
package Starter;

import GUI.BuildingsGUI_v2;
import GUI.GUIFacade;
import acq.ILogic;
import acq.IUI;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.LogicFacade;

public class starter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ILogic logic = new LogicFacade();
        IUI gui = new GUIFacade();
        
        gui.injectLogic(logic);
        gui.start(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
