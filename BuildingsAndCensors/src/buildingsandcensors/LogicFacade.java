package buildingsandcensors;

import acq.IBuilding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LogicFacade implements acq.ILogic {
    
    List<IBuilding> buildings = new ArrayList();
    
    @Override
    public void newBuilding(String name, String addr) {
        buildings.add(new Building(name,addr));
    }
    @Override
    public void removeBuilding(int i){
        buildings.remove(i);
    }
    @Override
    public IBuilding getBuilding(int i) {
        return buildings.get(i);
    }

    @Override
    public Collection<IBuilding> getBuildings() {
        return new ArrayList(buildings);
    }
    
}
