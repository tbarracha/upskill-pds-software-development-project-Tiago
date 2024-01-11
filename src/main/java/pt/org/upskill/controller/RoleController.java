package pt.org.upskill.controller;

import pt.org.upskill.domain.Role;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.RoleRepository;

import java.util.List;

public class RoleController extends Controller<Role, RoleRepository> {
    /*
    public boolean createRole(RoleDTO roleDTO) {
        RoleRepository repo = Repositories.getInstance().roleRepository();
        try {
            Role role = new Role(roleDTO.name);
            repo.save(role);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    */

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated())
            return;
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().roleRepository();
    }
}
