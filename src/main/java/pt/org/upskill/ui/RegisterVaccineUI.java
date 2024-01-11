package pt.org.upskill.ui;

import TiWorks.Events.*;
import pt.org.upskill.controller.BrandController;
import pt.org.upskill.controller.EventController;
import pt.org.upskill.controller.VaccineController;
import pt.org.upskill.controller.VaccineTypeController;
import pt.org.upskill.domain.Brand;
import pt.org.upskill.domain.Vaccine;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.ui.utils.Utils;

import java.util.List;

public class RegisterVaccineUI extends UI implements EventListener {

    VaccineController vaccineController = new VaccineController();
    BrandController brandController = new BrandController();
    VaccineTypeController vaccineTypeController = new VaccineTypeController();

    public RegisterVaccineUI() {
        EventController.OnVaccineCreated.addListener(this);
    }

    public void run() {
        printTitle("CREATE VACCINE");

        try {
            String name = Utils.readLineFromConsole("Vaccine Name: ");
            Brand brand = brandController.selectRepositoryOption("Vaccine Brand:");
            VaccineType vaccineType = vaccineTypeController.selectRepositoryOption("Vaccine Type:");

            //data
            vaccineController.createVaccine(name, brand, vaccineType);

            //confirmation
            vaccineController.confirm();

            System.out.println("\nRegistered:");
            vaccineController.listRepositoryItem();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eventFired() {

    }

    @Override
    public void eventFiredParams(Object... params) {
        List<Vaccine> vaccines = Event.getObjectTypesFromParams(params, Vaccine.class);

        if (vaccines.getFirst() == null)
            return;

        Vaccine vaccine = vaccines.getFirst();
        System.out.println("Event Detected! Vaccine created: " + vaccine);
    }
}
