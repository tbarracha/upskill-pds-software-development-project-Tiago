package pt.org.upskill.ui.menu;

import pt.org.upskill.domain.Role;

public class Permission {
    Role role;

    public Permission(Role role) {
        this.role = role;
    }

    public Role role() {
        return this.role;
    }
}
