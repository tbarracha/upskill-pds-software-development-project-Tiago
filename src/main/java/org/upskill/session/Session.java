package org.upskill.session;

import org.upskill.auth.User;

public class Session {
    User user;

    public Session(User user) {
        this.user = user;
    }

    public User user() {
        return this.user;
    }

}
