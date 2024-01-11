package pt.org.upskill.domain;

import java.util.Objects;

public class Role {

    private String name;

    public Role(String name) {
        this.name = name;
    }

    protected Role() {
    }

    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Role{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Role role = (Role) object;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
