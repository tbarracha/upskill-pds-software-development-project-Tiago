package pt.org.upskill.ui;

import TiWorks.TiUtils;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.EmployeeController;
import pt.org.upskill.controller.VaccinationController;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.Role;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.RoleRepository;
import pt.org.upskill.repository.VaccinationCenterRepository;
import pt.org.upskill.ui.BaseUI.UI;
import pt.org.upskill.ui.utils.Utils;

import java.util.Date;
import java.util.List;

public class ScheduleVaccinationUI extends UI {
    @Override
    public void run() {
        printTitle("SCHEDULE VACCINATION - HOSPITAL");

        if (getLoggedUser().hasRole(RoleRepository.ROLE_SNSUSER) == false) {
            return;
        }

        // Set Vaccine Type
        VaccineType vaccineType = Controllers.getInstance().getVaccineTypeController().selectRepositoryOption("\nSelect Vaccine Type: ");
        if (vaccineType == null) {
            System.out.println("No Vaccine Type selected...");
            return;
        }

        // search for Vaccination centers with type
        VaccinationCenterRepository vaccinationCenterRepository = Repositories.getInstance().getVaccinationCenterRepository();

        List<VaccinationCenter> vaccinationCenters = vaccinationCenterRepository.getVaccinationCentersWithVaccineType(vaccineType);
        if (vaccinationCenters.isEmpty()) {
            System.out.println(String.format("No Vaccination Centers with Vaccine Type: %s", vaccineType.getOptionDetails()));
            return;
        }

        VaccinationCenter vaccinationCenter = TiUtils.Lists.selectFromListOptions(vaccinationCenters, "Select Vaccination Center (-1 to exit): ", false);
        Date date = Utils.readDateFromConsole("Date");

        EmployeeController employeeController = Controllers.getInstance().getEmployeeController();
        Employee employee = employeeController.getEmployeeByEmail(getLoggedUser().getEmail().getEmailAddress());

        VaccinationController vaccinationController = Controllers.getInstance().getVaccinationController();
        vaccinationController.createVaccination(employee, (SNSUser) getLoggedUser(), vaccinationCenter.getVaccineType(), vaccinationCenter, date);

        if (vaccinationController.confirm()) {
            System.out.println();
            System.out.println(String.format("Scheduled Vaccination for User: %s, Location: %s, Date: %s", getLoggedUser().getEmailAdress(), vaccinationCenter.getName(), date.toString()));
        }
    }
}
