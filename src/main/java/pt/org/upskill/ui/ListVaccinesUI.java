package pt.org.upskill.ui;

import pt.org.upskill.controller.VaccineController;
import pt.org.upskill.domain.VaccineTech;

import java.util.List;

public class ListVaccinesUI extends UI {

    VaccineController vaccineController = new VaccineController();

    public void run() {
        try {
            vaccineController.listRepositoryOptions("LIST VACCINES", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
