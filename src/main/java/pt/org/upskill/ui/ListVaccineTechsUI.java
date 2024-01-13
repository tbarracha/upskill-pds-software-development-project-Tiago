package pt.org.upskill.ui;

import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccineTechController;
import pt.org.upskill.domain.VaccineTech;
import pt.org.upskill.ui.BaseUI.ListUI;
import pt.org.upskill.ui.BaseUI.UI;

public class ListVaccineTechsUI extends ListUI<VaccineTech> {
    private final VaccineTechController vaccineTechController = Controllers.getInstance().getVaccineTechController();

    public void run() {
        printTitle("LIST VACCINE TECHNOLOGY");

        try {
            vaccineTechController.listRepositoryOptions("LIST VACCINE TECHNOLOGIES", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
