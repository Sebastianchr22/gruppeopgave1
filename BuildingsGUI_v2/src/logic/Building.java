package logic;

import acq.ISensor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Building implements acq.IBuilding {
    private String Name;
    private String Address;
    private ObservableList<ISensor> list =  FXCollections.observableArrayList();
    
    
    Building(String name, String addr){
        this.Name = name;
        this.Address = addr;
        list.add(new CO2Sensor(25.0));
    }
    
    public void addTempSensor(double d){
        list.add(new TempSensor(d));
    }
    public void addCo2Sensor(double d){
        list.add(new CO2Sensor(d));
    }
    public void removeSensor(ISensor sensor){
        list.remove(sensor);
    }
    public ObservableList<ISensor> getSonsors(){
        return list;
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public String getAddr() {
        return this.Address;
    }
    
    @Override
    public String toString(){
        return this.Name + ", " + this.Address;
    }
}
