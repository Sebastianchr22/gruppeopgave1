package acq;

import javafx.collections.ObservableList;

public interface ILogic {

    public void newBuilding(String name, String addr);

    public void removeBuilding(IBuilding building);

    public ObservableList<IBuilding> getBuildings();

    public void SimulateSensor();

    }
