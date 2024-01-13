package pt.org.upskill.controller;

import pt.org.upskill.auth.User;
import pt.org.upskill.domain.Role;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.RoleRepository;

import java.util.List;

public class RoleController extends Controller<Role, RoleRepository> {
    public void createRole(User user, String roleName) {
        repositoryItem = repository.createRole(user, roleName);
    }

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated())
            return;
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getRoleRepository();
    }
}
