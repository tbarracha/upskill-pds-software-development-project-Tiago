package pt.org.upskill.domain;

import pt.org.upskill.auth.Email;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements IOption<Employee>, Serializable {
    private String name;
    private final Email email;
    private EmployeePosition position;
    private String phone;

    public Employee(String name, Email email) {
        this.name = name;
        this.email = email;
        position = new EmployeePosition("");
    }

    public Employee(String name, Email email, EmployeePosition position) {
        this.name = name;
        this.email = email;
        this.position = position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Email getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
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
        return this.email.getEmailAddress().equals(email);
    }

    public boolean hasPosition(String position) {
        return this.position.getPosition().equals(position);
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

    @Override
    public String getOptionDetails() {
        return String.format("%s - %s, %s, %s", name, position.getPosition(), email.getEmailAddress(), phone);
    }

    @Override
    public Employee getOptionType() {
        return this;
    }
}