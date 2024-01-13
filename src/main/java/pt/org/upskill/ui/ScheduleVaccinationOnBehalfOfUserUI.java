package pt.org.upskill.ui;

import TiWorks.TiUtils;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.controller.*;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccinationCenterRepository;
import pt.org.upskill.ui.BaseUI.SNSUserUI;
import pt.org.upskill.ui.utils.Utils;

import java.util.Date;
import java.util.List;

public class ScheduleVaccinationOnBehalfOfUserUI extends SNSUserUI {

    VaccinationCenterRepository vaccinationCenterRepository = Repositories.getInstance().getVaccinationCenterRepository();

    @Override
    public void run() {
        printTitle("SCHEDULE VACCINATION - SNS USER");

        try {
            // check if any Vaccination Centers
            if (vaccinationCenterRepository.size() == 0) {
                System.out.println("There are no Vaccination Centers...");
                return;
            }

            // search for SNS User
            SNSUser snsUser = getSNSUSer();
            if (snsUser == null) {
                return;
            }

            // Set Vaccine Type
            VaccineType vaccineType = Controllers.getInstance().getVaccineTypeController().selectRepositoryOption("\nSelect Vaccine Type: ");
            if (vaccineType == null) {
                System.out.println("No Vaccine Type selected...");
                return;
            }

            // search for Vaccination centers with type
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
            vaccinationController.createVaccination(employee, snsUser, vaccinationCenter.getVaccineType(), vaccinationCenter, date);

            if (vaccinationController.confirm()) {
                System.out.println();
                System.out.println(String.format("Created Vaccination for User: %, Location: %s, Date: %s", snsUser.getEmailAdress(), vaccinationCenter.getName(), date.toString()));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
