package pt.org.upskill.controller;

import TiWorks.TiUtils;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.domain.WaitingRoom;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccinationCenterRepository;

import java.util.List;

public class VaccinationCenterController extends Controller<VaccinationCenter, VaccinationCenterRepository> {

    public void createVaccinationCenter(String name, String location, VaccineType vaccineType) {
        repositoryItem = repository.createVaccinationCenter(name, location, vaccineType);
    }

    public void createVaccinationCenter(String name, String location, VaccineType vaccineType, WaitingRoom waitingRoom) {
        repositoryItem = repository.createVaccinationCenter(name, location, vaccineType, waitingRoom);
    }

    public void createVaccinationCenter(String name, String location, VaccineType vaccineType, List<SNSUser> usersWaiting) {
        repositoryItem = repository.createVaccinationCenter(name, location, vaccineType, usersWaiting);
    }

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated()) {
            return;
        }

        List<VaccineType> vaccineTypes = Repositories.getInstance().getVaccineTypeRepository().getContentList();

        //for (int j = 0; j < 2; j++) {
            for (int i = 0; i < vaccineTypes.size(); i++) {
                String name = String.format("Vac Center %s", TiUtils.Randomizer.getRandomAlphanumericString(2));
                String location = TiUtils.UpSkill.getRandomMorada();
                VaccineType type = vaccineTypes.get(i);

                repository.addToRepository(new VaccinationCenter(name, location, type));
            }
        //}
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getVaccinationCenterRepository();
    }
}
