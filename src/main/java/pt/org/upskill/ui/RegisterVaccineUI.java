package pt.org.upskill.ui;

import pt.org.upskill.controller.BrandController;
import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.VaccineController;
import pt.org.upskill.controller.VaccineTypeController;
import pt.org.upskill.domain.Brand;
import pt.org.upskill.domain.Vaccine;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.ui.BaseUI.RegisterUI;
import pt.org.upskill.ui.utils.Utils;

public class RegisterVaccineUI extends RegisterUI<Vaccine> {

    VaccineController vaccineController = Controllers.getInstance().getVaccineController();
    BrandController brandController = Controllers.getInstance().getBrandController();
    VaccineTypeController vaccineTypeController = Controllers.getInstance().getVaccineTypeController();

    @Override
    public void run() {
        printTitle("CREATE VACCINE");

        try {
            String name = Utils.readLineFromConsole("Vaccine Name: ");
            Brand brand = brandController.selectRepositoryOption("Vaccine Brand:");
            VaccineType vaccineType = vaccineTypeController.selectRepositoryOption("Vaccine Type:");

            //data
            vaccineController.createVaccine(name, brand, vaccineType);

            //confirmation
            if (vaccineController.confirm()) {
                System.out.println();
                System.out.println(String.format("Registered Vaccine { Name: %s, Brand: %s, Type: %s }", name, brand.getName(), vaccineType.getOptionDetails()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
