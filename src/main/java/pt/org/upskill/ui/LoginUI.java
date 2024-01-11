package pt.org.upskill.ui;

import pt.org.upskill.controller.LoginController;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class LoginUI extends UI {

    //Controller
    private final LoginController loginController = new LoginController();

    private String email;
    private String password;

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
