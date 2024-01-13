package pt.org.upskill.controller;

import pt.org.upskill.domain.Brand;
import pt.org.upskill.repository.BrandRepository;
import pt.org.upskill.repository.Repositories;

public class BrandController extends Controller<Brand, BrandRepository> {

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated())
            return;

        repository.addToRepository(new Brand("Pfizer"));
        repository.addToRepository(new Brand("Moderna"));
        repository.addToRepository(new Brand("Johnson & Johnson's Janssen"));
        repository.addToRepository(new Brand("AstraZeneca"));
        repository.addToRepository(new Brand("Sinovac"));
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getBrandRepository();
    }
}
