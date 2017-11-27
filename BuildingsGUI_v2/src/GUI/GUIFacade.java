package GUI;

import acq.IBuilding;
import acq.ILogic;
import acq.IUI;
import java.util.Collection;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class GUIFacade implements acq.IUI {

    private ILogic logic;

    public static IUI ui;

    public static IUI getInstance() {
        return ui;
    }

    @Override
    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ui = this;
        BuildingsGUI_v2 game = new BuildingsGUI_v2();
        game.start(stage);
    }

    @Override
    public void createNewBuilding(String name, String addr) {
        logic.newBuilding(name, addr);
    }

    @Override
    public ObservableList<acq.IBuilding> getBuildings() {
        return logic.getBuildings();
    }
    
    @Override
    public void removeBuilding(IBuilding building){
        logic.removeBuilding(building);
    }

    @Override
    public void SimulateSensor() {
        logic.SimulateSensor();
    }

}
