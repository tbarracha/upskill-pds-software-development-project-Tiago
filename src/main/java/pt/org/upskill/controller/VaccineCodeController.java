package pt.org.upskill.controller;

import pt.org.upskill.domain.VaccineCode;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccineCodeRepository;

public class VaccineCodeController extends Controller<VaccineCode, VaccineCodeRepository> {

    public void createCode(String codeString) {
        repositoryItem = repository.createCode(codeString);
    }

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated())
            return;

        repository.addToRepository(new VaccineCode("CVD19"));
        repository.addToRepository(new VaccineCode("FLU00"));
        repository.addToRepository(new VaccineCode("INFLU"));
        repository.addToRepository(new VaccineCode("POLIO"));
        repository.addToRepository(new VaccineCode("TUBRC"));
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().vaccineCodeRepository();
    }
}
