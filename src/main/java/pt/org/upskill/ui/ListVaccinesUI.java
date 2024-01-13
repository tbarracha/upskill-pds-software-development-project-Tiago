package pt.org.upskill.ui;

import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccineController;
import pt.org.upskill.domain.Vaccine;
import pt.org.upskill.ui.BaseUI.ListUI;
import pt.org.upskill.ui.BaseUI.UI;

public class ListVaccinesUI extends ListUI<Vaccine> {

    VaccineController vaccineController = Controllers.getInstance().getVaccineController();

    public void run() {
        printTitle("LIST VACCINES");

        try {
            vaccineController.listRepositoryOptions("LIST VACCINES", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
