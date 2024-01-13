package pt.org.upskill.ui;

import TiWorks.TiUtils;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccinationController;
import pt.org.upskill.controller.VaccineAdministrationController;
import pt.org.upskill.domain.Vaccination;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class VaccineAadministrationUI extends ListVaccinationCenterUI {

    VaccinationController vaccinationController = Controllers.getInstance().getVaccinationController();
    VaccineAdministrationController vaccineAdministrationController = Controllers.getInstance().getVaccineAdministrationController();

    @Override
    protected SNSUser getSNSUSer() {
        List<SNSUser> snsUserList = Repositories.getInstance().getUserRepository().getSNSUsers();

        List<SNSUser> validUsers = new ArrayList<>();
        for (SNSUser snsUser : snsUserList) {
            List<Vaccination> vaccinations = Repositories.getInstance().getVaccinationRepository().getVaccinationBySNSUser(snsUser);

            if (vaccinations.isEmpty() == false) {
                validUsers.add(snsUser);
            }
        }

        return TiUtils.Lists.selectFromListOptions(validUsers, "Select User With Vaccination: ", false);
    }

    @Override
    public void run() {
        printTitle("VACCINE ADMINISTRATION");

        try {
            VaccinationCenter vaccinationCenter = vaccinationCenterController.selectRepositoryOption("Select Vaccination Center");

            if (vaccinationCenter.getWaitingRoomSNSUserCount() == 0) {
                System.out.println();
                System.out.println("Waiting room has no SNS Users...");
                return;
            }

            // get user
            SNSUser snsUser = vaccinationCenter.selectSNSUserInWaitingRoom();

            // see if he has vaccination
            List<Vaccination> vaccinations = vaccinationController.getVaccinationsBySNSUSerAndVaccinationCenter(snsUser, vaccinationCenter);
            if (vaccinations.isEmpty()) {
                vaccinationCenter.removeSNSUserFromWaitingRoon(snsUser);
                System.out.println(String.format("There are no vaccinations for User: %s", snsUser.getEmailAdress()));
                return;
            }

            Vaccination vaccination = TiUtils.Lists.selectFromListOptions(vaccinations, "Select Vaccination to Administer: ", false);

            if (vaccination == null) {
                System.out.println(String.format("Vaccination is null for User: %s", snsUser.getEmailAdress()));
                return;
            }

            // apply and remove from waiting room
            vaccinationCenter.removeSNSUserFromWaitingRoon(snsUser);
            vaccineAdministrationController.createVaccineAdministration(vaccination);

            vaccinations.remove(vaccination);

            if (vaccinationController.confirm() && vaccineAdministrationController.confirm()) {
                TiUtils.print("Applied Vaccine to User: %s of Type: %s at Date: %s", snsUser.getEmailAdress(), vaccination.getVaccineType().getOptionDetails(), vaccination.getDate().toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
