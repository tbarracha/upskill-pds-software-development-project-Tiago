package pt.org.upskill.auth;

import pt.org.upskill.domain.IOption;
import pt.org.upskill.domain.Role;

public class User implements IOption<User> {
    private String code;
    private Email email;
    private Password password;
    private Role role;

    public User(String code, Role role, Email email, Password password) {
        if (role == null) {
            throw new IllegalArgumentException("User role cannot be null.");
        }
        this.code = code;
        if (code == null) {
            this.code = email.getEmailAddress();
        }
        this.role = role;
        this.email = email;
        this.password = password;
    }

    protected User() {
    }

    public String getCode() {
        return code;
    }

    public Email getEmail() {
        return this.email;
    }

    public String getEmailAdress() {
        return this.email.getEmailAddress();
    }

    public Password getPassword() {
        return this.password;
    }

    public boolean hasRole(Role role) {
        if (role == null) {
            return false;
        }
        return this.role.getRoleName().equalsIgnoreCase(role.getRoleName());
    }

    public boolean hasRole(String roleStr) {
        if (roleStr.isEmpty()) {
            return false;
        }

        return this.role.getRoleName().equalsIgnoreCase(roleStr);
    }

    public boolean hasPassword(String password) {
        return this.password.value().equals(password);
    }

    @Override
    public String getOptionDetails() {
        return String.format("%s, %s, %s", code, email.getEmailAddress(), role.getOptionType());
    }

    @Override
    public User getOptionType() {
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("code='").append(code).append('\'');
        sb.append(", email=").append(email.getEmailAddress());
        sb.append(", password=").append(password.value());
        sb.append(", role=").append(role.getRoleName());
        sb.append('}');
        return sb.toString();
    }
}
