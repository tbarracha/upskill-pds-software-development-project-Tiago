package pt.org.upskill.ui;

import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccineCodeController;
import pt.org.upskill.controller.VaccineTechController;
import pt.org.upskill.controller.VaccineTypeController;
import pt.org.upskill.domain.VaccineCode;
import pt.org.upskill.domain.VaccineTech;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.ui.BaseUI.RegisterUI;
import pt.org.upskill.ui.BaseUI.UI;

import java.util.List;

import static pt.org.upskill.ui.utils.Utils.readIntegerFromConsole;
import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class RegisterVaccineTypeUI extends RegisterUI<VaccineType> {
    private final VaccineCodeController vaccineCodeController = Controllers.getInstance().getVaccineCodeController();
    private final VaccineTypeController vaccineTypeController = Controllers.getInstance().getVaccineTypeController();
    private final VaccineTechController vaccineTechController = Controllers.getInstance().getVaccineTechController();

    @Override
    public void run() {
        printTitle("CREATE VACCINE TYPE");

        try {
            VaccineCode code = vaccineCodeController.selectRepositoryOption("CODES");
            String shortDescription = readLineFromConsole("Vaccine Type Short Description: ");

            System.out.println("Vaccine Technologies");
            List<VaccineTech> vaccineTechList = vaccineTechController.vaccineTechList();
            for (VaccineTech vaccineTech : vaccineTechList) {
                System.out.println(vaccineTech.getId() + " - " + vaccineTech.getName());
            }
            int key = readIntegerFromConsole("Select a vaccine technology: ");

            //data
            vaccineTypeController.createVaccineType(code, shortDescription, key);

            //confirmation
            vaccineTypeController.confirm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
