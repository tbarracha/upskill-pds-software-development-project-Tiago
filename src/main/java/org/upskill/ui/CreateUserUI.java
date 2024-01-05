package org.upskill.ui;

import org.upskill.controller.RoleController;
import org.upskill.controller.UserController;

import static org.upskill.ui.utils.Utils.readLineFromConsole;

public class CreateUserUI extends UI {
    //Controller
    private final UserController userController = new UserController();
    private final RoleController roleController = new RoleController();

    public void run() {
        System.out.println("");
        System.out.println("CREATE USER");
        System.out.println("-----------");

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