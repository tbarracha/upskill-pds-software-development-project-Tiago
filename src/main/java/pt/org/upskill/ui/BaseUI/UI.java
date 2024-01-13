package pt.org.upskill.ui.BaseUI;

import pt.org.upskill.auth.User;
import pt.org.upskill.session.Context;

public abstract class UI implements Runnable {

    public void printTitle(String title) {
        System.out.println();
        System.out.println(title.toUpperCase());
        System.out.println("-----------");
    }

    public abstract void run();

    protected User getLoggedUser() {
        return Context.getInstance().userLoggedIn();
    }
}
