package pt.org.upskill.controller;

import pt.org.upskill.domain.Brand;
import pt.org.upskill.domain.Vaccine;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.repository.*;

public class VaccineController extends Controller<Vaccine, VaccineRepository> {

    public void createVaccine(String name, Brand brand, VaccineType vaccineType) {
        repositoryItem = repository.createVaccine(name, brand, vaccineType);
        EventController.OnVaccineCreated.invoke(repositoryItem);
    }

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated())
            return;

        BrandRepository brandRepository = Repositories.getInstance().getBrandRepository();
        VaccineTypeRepository vacTypeRepo = Repositories.getInstance().getVaccineTypeRepository();

        for (int i = 0; i < brandRepository.size(); i++) {
            for (int j = 0; j < vacTypeRepo.size(); j++) {
                String name = String.format("Vac%d", i*2+j);
                Brand brand = brandRepository.getAtIndex(i);
                VaccineType type = vacTypeRepo.getAtIndex(j);

                repository.addToRepository(new Vaccine(name, brand, type));
            }
        }
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getVaccineRepository();
        repositoryOutputer = new VaccineRepositoryOutputer(repository);
    }
}
