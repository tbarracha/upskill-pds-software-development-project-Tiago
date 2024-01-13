package pt.org.upskill.ui;

import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccineTechController;
import pt.org.upskill.domain.VaccineTech;
import pt.org.upskill.ui.BaseUI.RegisterUI;
import pt.org.upskill.ui.BaseUI.UI;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class RegisterVaccineTechUI extends RegisterUI<VaccineTech> {
    private final VaccineTechController vaccineTechController = Controllers.getInstance().getVaccineTechController();

    @Override
    public void run() {
        printTitle("CREATE VACCINE TECHNOLOGY");

        try {
            String name = readLineFromConsole("Vaccine Technology Name: ");
            String description = readLineFromConsole("Vaccine Technology Description: ");

            //Set data
            vaccineTechController.createVaccineTech(name, description);

            //Confirm
            vaccineTechController.confirm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
