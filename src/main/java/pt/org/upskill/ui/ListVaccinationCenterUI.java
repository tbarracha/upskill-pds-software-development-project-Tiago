package pt.org.upskill.ui;

import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccinationCenterController;
import pt.org.upskill.ui.BaseUI.SNSUserUI;

public class ListVaccinationCenterUI extends SNSUserUI {

    protected VaccinationCenterController vaccinationCenterController = Controllers.getInstance().getVaccinationCenterController();

    @Override
    public void run() {
        printTitle("LIST VACCINATION CENTERS");

        try {
            vaccinationCenterController.listRepositoryOptions("LIST VACCINATION CENTERS", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
