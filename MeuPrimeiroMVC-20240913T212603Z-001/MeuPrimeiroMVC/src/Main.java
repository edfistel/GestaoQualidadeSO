//Author: Eduardo Fischer Sutel
//RA: 1292320654
//Since: 12/09/24

import controller.UserController;
import view.MenuView;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();
        new MenuView(controller);
    }
}