package pt.org.upskill.ui;

import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.RoleController;
import pt.org.upskill.controller.UserController;
import pt.org.upskill.ui.BaseUI.UI;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class CreateUserUI extends UI {
    //Controller
    private final UserController userController = Controllers.getInstance().getUserController();
    private final RoleController roleController = Controllers.getInstance().getRoleController();

    @Override
    public void run() {
        printTitle("CREATE USER");

        try {
            //Requests data (reference, ..., cost)
            String email = readLineFromConsole("Email: ");
            String password = readLineFromConsole("Password: ");

            //TODO: Your code here
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
