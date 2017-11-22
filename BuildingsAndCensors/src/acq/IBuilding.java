package acq;

import java.util.ArrayList;
import java.util.Collection;

public interface IBuilding {    
    public String getName();
    public String getAddr();
    public void addTempSensor(double d);
    public void addCo2Sensor(double d);
    public void removeSensor(int i);
    public ISensor getSensor(int i);
    public Collection<ISensor> getSonsors();
}
