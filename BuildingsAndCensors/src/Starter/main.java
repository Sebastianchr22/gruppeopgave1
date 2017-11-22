package Starter;

import UI.UIFacade;
import acq.ILogic;
import acq.IUI;
import buildingsandcensors.LogicFacade;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ILogic logic = new LogicFacade();
        IUI ui = new UIFacade();
        
        ui.injectLogic(logic);
        ui.start();
    }
}
