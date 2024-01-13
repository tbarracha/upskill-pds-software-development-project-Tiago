package pt.org.upskill.repository;

import pt.org.upskill.auth.Email;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.EmployeePosition;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository extends Repository<Employee> {

    public Employee createEmployee(String name, Email email) {
        return new Employee(name, email);
    }
    public Employee createEmployee(String name, Email email, EmployeePosition position) {
        return new Employee(name, email, position);
    }

    public Employee getEmployeeWithEmail(String emailAdress) {
        for (Employee employee : contentList) {
            if (employee.hasEmail(emailAdress)) {
                return employee;
            }
        }

        return null;
    }

    public List<Employee> getEmployeesWithPosition(EmployeePosition position) {
        List<Employee> list = new ArrayList<>();

        for (Employee employee : contentList) {
            if (employee.hasPosition(position.getPosition())) {
                list.add(employee);
            }
        }

        return list;
    }

    public List<Employee> getEmployeesWithPosition(String position) {
        List<Employee> list = new ArrayList<>();

        for (Employee employee : contentList) {
            if (employee.hasPosition(position)) {
                list.add(employee);
            }
        }

        return list;
    }
}
