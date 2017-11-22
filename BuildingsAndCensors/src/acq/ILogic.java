package acq;

import java.util.Collection;

public interface ILogic {
    public void newBuilding(String name, String addr);
    public void removeBuilding(int i);
    public IBuilding getBuilding(int i);
    public Collection<IBuilding> getBuildings();
}
