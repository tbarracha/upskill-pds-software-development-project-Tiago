package pt.org.upskill.controller;

import pt.org.upskill.domain.VaccineTech;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccineTechRepository;

import java.util.List;

public class VaccineTechController extends Controller<VaccineTech, VaccineTechRepository> {
    public void createVaccineTech(String name, String description) {
        repositoryItem = repository.createVaccineTech(name, description);
    }

    public List<VaccineTech> vaccineTechList() {
        return repository.vaccineTechList();
    }

    public String getVaccineTechName(int id) {
        return repository.getById(id).getName();
    }

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated())
            return;

        repository.addToRepository(new VaccineTech("Live-Attenuated","Contain weakened live pathogens, evoke strong and long-lasting immune response."));
        repository.addToRepository(new VaccineTech("Inactivated",    "Use killed pathogens to induce an immune response, may require multiple doses."));
        repository.addToRepository(new VaccineTech("Subunit",        "Made from parts of pathogens, safe as they don't contain the whole organism."));
        repository.addToRepository(new VaccineTech("Toxoid",         "Use inactivated toxins to neutralize bacterial toxins, preventing diseases like tetanus and diphtheria."));
        repository.addToRepository(new VaccineTech("Viral Vector",   "Use harmless viruses to deliver genetic code, often requiring fewer doses."));
        repository.addToRepository(new VaccineTech("mRNA",           "Use genetic code to instruct the body to produce viral proteins, adaptable for quick development and modification."));
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getVaccineTechRepository();
    }
}
