package pt.org.upskill.repository;

import TiWorks.TiUtils;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.EmployeePosition;
import pt.org.upskill.domain.IOption;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryOutputer extends RepositoryOutputer<Employee> {

    public EmployeeRepositoryOutputer(EmployeeRepository repository) {
        super(repository);
    }

    public void listEmployessOfPosition(EmployeePosition targetPosition) {
        List<IOption> options = getOptionTypes();
        List<Employee> filteredEmployees = new ArrayList<>();

        for (int i = 0; i < options.size(); i++) {
            Employee employee = (Employee) options.get(i).getOptionType();

            if (employee.getPosition() != null && employee.getPosition().equals(targetPosition)) {
                filteredEmployees.add(employee);
            }
        }

        TiUtils.ConsoleOut.printSubTitle(String.format("List Employees '%s':", targetPosition.getPosition()), false);
        if (filteredEmployees.size() > 0) {
            for (int i = 0; i < filteredEmployees.size(); i++) {
                System.out.println(filteredEmployees.get(i).getOptionDetails());
            }
        } else {
            System.out.println(String.format("No employess with position: %s", targetPosition.getPosition()));
        }
    }
}
