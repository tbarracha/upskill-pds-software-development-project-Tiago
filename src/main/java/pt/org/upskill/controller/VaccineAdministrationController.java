package pt.org.upskill.controller;

import TiWorks.TiUtils;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;
import pt.org.upskill.domain.*;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccineAdministrationRepository;

import java.util.Date;
import java.util.List;

public class VaccineAdministrationController extends Controller<VaccineAdministration, VaccineAdministrationRepository> {

    public void createVaccineAdministration(Employee nurse, SNSUser snsUser, VaccinationCenter vaccinationCenter, Date date) {
        repositoryItem = repository.createVaccineAdministration(nurse, snsUser, vaccinationCenter, date);
    }

    public void createVaccineAdministration(Vaccination vaccination) {
        repositoryItem = repository.createVaccineAdministration(vaccination);
    }

    @Override
    public void generateContentModels() {

    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getVaccineAdministrationRepository();
    }
}
