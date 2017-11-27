package logic;

import acq.IBuilding;
import acq.ISensor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LogicFacade implements acq.ILogic {
    
    ObservableList<IBuilding> buildings = FXCollections.observableArrayList();
    
    @Override
    public void newBuilding(String name, String addr) {
        buildings.add(new Building(name,addr));
    }
    @Override
    public void removeBuilding(IBuilding building){
        buildings.remove(building);
    }

    @Override
    public ObservableList<IBuilding> getBuildings() {
        return buildings;
    }
    
    public void SimulateSensor(){
        for(IBuilding building : buildings){
            for(ISensor sensor : building.getSonsors()){
                sensor.updateMeasurement();
            }
        }
    }
    
}
