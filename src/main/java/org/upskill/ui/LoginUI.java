package org.upskill.ui;

import org.upskill.controller.LoginController;

import static org.upskill.ui.utils.Utils.readLineFromConsole;

public class LoginUI extends UI {

    //Controller
    private final LoginController loginController = new LoginController();

    private String email;
    private String password;

    public void run() {
        System.out.println("");
        System.out.println("LOG IN");
        System.out.println("------");

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
