package pt.org.upskill.ui;

import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccineTechController;
import pt.org.upskill.controller.VaccineTypeController;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.ui.BaseUI.ListUI;
import pt.org.upskill.ui.BaseUI.UI;

public class ListVaccineTypesUI extends ListUI<VaccineType> {

    private final VaccineTypeController vaccineTypeController = Controllers.getInstance().getVaccineTypeController();
    private final VaccineTechController vaccineTechController = Controllers.getInstance().getVaccineTechController();

    @Override
    public void run() {
        printTitle("LIST VACCINE TYPES");

        try {
            vaccineTypeController.listRepositoryOptions("LIST VACCINE TYPES", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
