package pt.org.upskill.ui;

import TiWorks.TiUtils;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccinationCenterController;
import pt.org.upskill.domain.Vaccination;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.ui.BaseUI.SNSUserUI;

import java.util.ArrayList;
import java.util.List;

public class RegisterSNSUserArrivalUI extends SNSUserUI {

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
        printTitle("REGISTER SNS USER ARRIVAL");

        try {
            // select user
            SNSUser snsUser = getSNSUSer();
            if (snsUser == null) {
                return;
            }

            // add to vaccination center waiting room
            VaccinationCenterController vaccinationCenterController = Controllers.getInstance().getVaccinationCenterController();
            VaccinationCenter vaccinationCenter = vaccinationCenterController.selectRepositoryOption("Select Vaccination Center: ");
            vaccinationCenter.addSNSUserToWaitingRoom(snsUser);

            if (vaccinationCenterController.confirm()) {
                System.out.println(String.format("\nAdded SNS User: %s, to Waiting Room in Vac Center: %s", snsUser.getEmail().getEmailAddress(), vaccinationCenter.getName()));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
