package pt.org.upskill.ui;

import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.LoginController;
import pt.org.upskill.ui.BaseUI.UI;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class LoginUI extends UI {

    //Controller
    private final LoginController loginController = Controllers.getInstance().getLoginController();

    private String email;
    private String password;

    @Override
    public void run() {
        printTitle("LOG IN");

        String email = readLineFromConsole("Email: ");
        String password = readLineFromConsole("Password: ");

        try {
            if (loginController.logIn(email, password)) {
                System.out.print(email + " logged in");
            } else {
                System.out.print("Invalid email/password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
