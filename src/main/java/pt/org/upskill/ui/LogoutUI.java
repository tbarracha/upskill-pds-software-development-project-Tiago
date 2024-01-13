package pt.org.upskill.ui;

import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.LoginController;
import pt.org.upskill.session.Context;
import pt.org.upskill.ui.BaseUI.UI;

public class LogoutUI extends UI {

    //Controller
    private final LoginController controller = Controllers.getInstance().getLoginController();

    private String email;
    private String password;

    @Override
    public void run() {
        printTitle("LOG OUT");

        if (Context.getInstance().session() == null) {
            System.out.print("Not logged in...");
        } else {
            controller.logOut(Context.getInstance().session().user());
            System.out.print("Logged out");
        }
    }
}
