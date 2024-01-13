package pt.org.upskill.ui;

import TiWorks.Singleton.Singletons;
import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccinationCenterController;
import pt.org.upskill.controller.VaccineTypeController;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.ui.BaseUI.RegisterUI;
import pt.org.upskill.ui.utils.Utils;

public class RegisterVaccinationCenterUI extends RegisterUI<VaccinationCenter> {
    VaccinationCenterController vaccinationCenterController = Singletons.getInstance(VaccinationCenterController.class);
    VaccineTypeController vaccineTypeController = Controllers.getInstance().getVaccineTypeController();

    @Override
    public void run() {
        printTitle("REGISTER VACCINATION CENTER");

        try {
            String name = Utils.readLineFromConsole("Name: ");
            String location = Utils.readLineFromConsole("Location: ");
            VaccineType vaccineType = vaccineTypeController.selectRepositoryOption("Vaccine Type");

            vaccinationCenterController.createVaccinationCenter(name, location, vaccineType);
            vaccinationCenterController.confirm();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
