package pt.org.upskill.controller;

import pt.org.upskill.auth.User;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.UserRepository;
import pt.org.upskill.session.Context;
import pt.org.upskill.session.Session;

public class LoginController extends Controller<User, UserRepository> {
    //private final ApplicationSession applicationSession;

    public boolean logIn(String email, String  password) throws Exception {
        User user =  repository.getUserByEmail(email);
        if  ((user != null) && (user.hasPassword(password))) {
            Session session = new Session(user);
            Context.getInstance().setSession(session);
            return true;
        }
        return false;
    }

    public boolean logOut(User user) {
        if  (user != null) {
            Context.getInstance().setSession(null);
            return true;
        }
        return false;
    }

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated())
            return;
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getUserRepository();
    }
}
