package pt.org.upskill.ui;

import pt.org.upskill.controller.VaccineTechController;
import pt.org.upskill.domain.VaccineTech;
import pt.org.upskill.domain.VaccineType;

import java.util.List;

public class ListVaccineTechsUI extends UI {
    private final VaccineTechController vaccineTechController = new VaccineTechController();

    public void run() {
        try {
            vaccineTechController.listRepositoryOptions("LIST VACCINE TECHNOLOGIES", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
