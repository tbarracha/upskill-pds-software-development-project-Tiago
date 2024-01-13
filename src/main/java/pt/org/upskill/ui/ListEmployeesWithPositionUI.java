package pt.org.upskill.ui;

import pt.org.upskill.controller.*;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.EmployeePosition;
import pt.org.upskill.ui.BaseUI.ListUI;

public class ListEmployeesWithPositionUI extends ListUI<Employee> {
    EmployeeController employeeController = Controllers.getInstance().getEmployeeController();
    EmployeePositionController positionController = Controllers.getInstance().getEmployeePositionController();

    @Override
    public void run() {
        try {
            printTitle("LIST EMPLOYEES");

            EmployeePosition targetPosition = positionController.selectRepositoryOption("Position: ");
            employeeController.listEmployessWithPosition(targetPosition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
