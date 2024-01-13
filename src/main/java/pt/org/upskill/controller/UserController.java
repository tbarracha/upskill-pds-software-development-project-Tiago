package pt.org.upskill.controller;

import TiWorks.TiUtils;
import pt.org.upskill.auth.Email;
import pt.org.upskill.auth.Password;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;
import pt.org.upskill.domain.Role;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.RoleRepository;
import pt.org.upskill.repository.UserRepository;
import pt.org.upskill.repository.UserRepositoryOutputer;

import java.util.List;

public class UserController extends Controller<User, UserRepository> {

    public void createUser(String code, Role role, Email email, Password password) {
        repositoryItem = repository.createUser(code, role, email, password);
    }

    public void createSNSUser(String code, Role role, Email email, Password password, String snsNumber, String citizenCardNumber, String phoneNumber) {
        repositoryItem = repository.createSNSUser(code, role, email, password, snsNumber, citizenCardNumber, phoneNumber);
    }

    @Override
    public void generateContentModels() {
        //if (areContentModelsCreated())
        //    return;

        for (int i = 0; i < 5; i++) {
            String code = RoleRepository.ROLE_CODE_SNSUSER;
            Role role = Repositories.getInstance().getRoleRepository().getRoleByName(RoleRepository.ROLE_SNSUSER);
            Email email = new Email(TiUtils.UpSkill.getRandomEmail());
            Password password = new Password("1234");
            String snsNumber = TiUtils.Randomizer.getRandomNumberString(9);
            String citizenCardNumber = TiUtils.Randomizer.getRandomNumberString(9);
            String phoneNumber = "9" + TiUtils.Randomizer.getRandomNumberString(8);

            createSNSUser(code, role, email, password, snsNumber, citizenCardNumber, phoneNumber);
            confirm();
        }
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getUserRepository();
        repositoryOutputer = new UserRepositoryOutputer(repository);
    }
}
