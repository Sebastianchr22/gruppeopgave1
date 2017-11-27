package acq;

import javafx.collections.ObservableList;
import javafx.stage.Stage;

public interface IUI {

    public void injectLogic(ILogic logic);

    public void start(Stage stage) throws Exception;

    public void createNewBuilding(String name, String addr);

    public void removeBuilding(IBuilding building);

    public ObservableList<acq.IBuilding> getBuildings();
    
    public void SimulateSensor();
}
