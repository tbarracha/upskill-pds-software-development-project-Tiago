package pt.org.upskill.ui;

import TiWorks.TiUtils;
import pt.org.upskill.auth.Email;
import pt.org.upskill.controller.Controller;
import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.EmployeeController;
import pt.org.upskill.controller.EmployeePositionController;
import pt.org.upskill.domain.EmployeePosition;
import pt.org.upskill.ui.BaseUI.UI;
import pt.org.upskill.ui.utils.Utils;

public class RegisterEmployeeUI extends UI {

    EmployeeController employeeController = Controllers.getInstance().getEmployeeController();
    EmployeePositionController positionController = Controllers.getInstance().getEmployeePositionController();

    @Override
    public void run() {
        printTitle("REGISTER EMPLOYEE");

        try {
            String name = Utils.readLineFromConsole("Name: ");
            String adress = "";

            do {
                adress = Utils.readLineFromConsole("Enter Emplyee email: ");
            } while (!Email.isValidAddress(adress));

            Email email = new Email(adress);
            EmployeePosition position = positionController.selectRepositoryOption("Select Employee Position:");
            employeeController.createEmployee(name, email, position);

            employeeController.confirm();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
