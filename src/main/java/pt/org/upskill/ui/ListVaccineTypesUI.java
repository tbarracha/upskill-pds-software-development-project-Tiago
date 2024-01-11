package pt.org.upskill.ui;

import pt.org.upskill.controller.VaccineTechController;
import pt.org.upskill.controller.VaccineTypeController;
import pt.org.upskill.domain.VaccineTech;
import pt.org.upskill.domain.VaccineType;

import java.util.List;

public class ListVaccineTypesUI extends UI {

    private final VaccineTypeController vaccineTypeController = new VaccineTypeController();
    private final VaccineTechController vaccineTechController = new VaccineTechController();

    public void run() {
        try {
            vaccineTypeController.listRepositoryOptions("LIST VACCINE TYPES", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
