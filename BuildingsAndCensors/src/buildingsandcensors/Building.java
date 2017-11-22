package buildingsandcensors;

import acq.ISensor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Building implements acq.IBuilding {
    private String Name;
    private String Address;
    private List<ISensor> list = new ArrayList();
    
    
    Building(String name, String addr){
        this.Name = name;
        this.Address = addr;
    }
    
    public void addTempSensor(double d){
        list.add(new TempSensor(d));
    }
    public void addCo2Sensor(double d){
        list.add(new CO2Sensor(d));
    }
    public void removeSensor(int i){
        list.remove(i);
    }
    public ISensor getSensor(int i){
        return list.get(i);
    }
    public Collection<ISensor> getSonsors(){
        return new ArrayList(list);
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public String getAddr() {
        return this.Address;
    }
}
