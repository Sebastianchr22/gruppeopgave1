package acq;

import java.util.ArrayList;
import java.util.Collection;
import javafx.collections.ObservableList;

public interface IBuilding {    
    public String getName();
    public String getAddr();
    public void addTempSensor(double d);
    public void addCo2Sensor(double d);
    public void removeSensor(ISensor sensor);
    public ObservableList<ISensor> getSonsors();
}
