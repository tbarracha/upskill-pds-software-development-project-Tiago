package pt.org.upskill.controller;

import TiWorks.TiUtils;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.domain.*;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccinationRepository;

import java.util.Date;
import java.util.List;

public class VaccinationController extends Controller<Vaccination, VaccinationRepository> {

    public void createVaccination(Employee nurse, SNSUser snsUser, VaccineType vaccine, VaccinationCenter vaccinationCenter, Date date) {
        repositoryItem = repository.createVaccination(nurse, snsUser, vaccine, vaccinationCenter, date);
    }

    public List<Vaccination> getVaccinationsForSNSUser(SNSUser snsUser) {
        return repository.getVaccinationBySNSUser(snsUser);
    }

    public List<Vaccination> getVaccinationsByVaccinationCenter(VaccinationCenter vaccinationCenter) {
        return repository.getVaccinationByVaccinationCenter(vaccinationCenter);
    }

    public List<Vaccination> getVaccinationsBySNSUSerAndVaccinationCenter(SNSUser snsUser, VaccinationCenter vaccinationCenter) {
        return repository.getVaccinationsBySNSUSerAndVaccinationCenter(snsUser, vaccinationCenter);
    }

    @Override
    public void generateContentModels() {
        
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getVaccinationRepository();
    }
}
