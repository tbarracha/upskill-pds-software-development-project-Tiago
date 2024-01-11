package pt.org.upskill.controller;

import TiWorks.TiUtils;
import pt.org.upskill.domain.IOption;
import pt.org.upskill.domain.VaccineCode;
import pt.org.upskill.domain.VaccineTech;
import pt.org.upskill.domain.VaccineType;

import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccineTechRepository;
import pt.org.upskill.repository.VaccineTypeRepository;

import java.util.ArrayList;
import java.util.Random;

public class VaccineTypeController extends Controller<VaccineType, VaccineTypeRepository> {
    public void createVaccineType(VaccineCode code, String shortDescription, int vaccineTechId) {
        VaccineTechRepository vaccineTechRepository = Repositories.getInstance().vaccineTechRepository();
        VaccineTech vaccineTech = vaccineTechRepository.getById(vaccineTechId);

        repositoryItem = repository.createVaccineType(code, shortDescription, vaccineTech);
    }

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated())
            return;

        ArrayList<VaccineTech> vaccineTechList = Repositories.getInstance().vaccineTechRepository().getContentList();
        ArrayList<VaccineCode> vaccineCodes = Repositories.getInstance().vaccineCodeRepository().getContentList();

        for (int i = repository.size(); i < vaccineCodes.size(); i++) {
            VaccineCode code = vaccineCodes.get(i);
            String description = String.format("Description of Vaccine Type: %s", code);

            repository.addToRepository(new VaccineType(code, description, TiUtils.Randomizer.getRandomFromList(vaccineTechList)));
        }
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().vaccineTypeRepository();
    }
}