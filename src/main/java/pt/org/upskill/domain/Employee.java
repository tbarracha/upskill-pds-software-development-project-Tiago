package pt.org.upskill.domain;

import pt.org.upskill.auth.Email;

import java.util.Objects;

public class Employee {
    private final Email email;
    private String name;
    private String position;
    private String phone;

    public Employee(Email email, String name) {
        this.email = email;
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }

    public boolean hasEmail(String email) {
        return this.email.address().equals(email);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("email=").append(email);
        sb.append(", name='").append(name).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, position, phone);
    }
}