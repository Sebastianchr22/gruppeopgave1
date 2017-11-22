package UI;

import acq.IBuilding;
import acq.ILogic;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UIFacade implements acq.IUI {

    private ILogic logic;

    @Override
    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }

    public void start() {
        while (true) {
            System.out.println("Select an action:");
            System.out.println("1. Create new building");
            System.out.println("2. Remove a building from index");
            System.out.println("3. Show buildings");

            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Enter a name:");
                    String name = scanner.next();
                    System.out.println("Enter an address:");
                    String addr = scanner.next();
                    logic.newBuilding(name, addr);
                    break;
                case 2:
                    System.out.println("Enter index:");
                    logic.removeBuilding(scanner.nextInt());
                    break;
                case 3:
                    Collection<IBuilding> buildings = logic.getBuildings();
                    for(IBuilding IBu : buildings){
                        System.out.println(IBu.getName() + ", At " + IBu.getAddr());
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
