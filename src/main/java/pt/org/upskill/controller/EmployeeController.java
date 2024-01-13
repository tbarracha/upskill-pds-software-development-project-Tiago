package pt.org.upskill.controller;

import TiWorks.Singleton.ISingleton;
import TiWorks.Singleton.Singletons;
import TiWorks.TiUtils;
import pt.org.upskill.auth.Email;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.EmployeePosition;
import pt.org.upskill.repository.EmployeeRepository;
import pt.org.upskill.repository.EmployeeRepositoryOutputer;
import pt.org.upskill.repository.Repositories;

public class EmployeeController extends Controller<Employee, EmployeeRepository> {

    public void createEmployee(String name, Email email) {
        repositoryItem = repository.createEmployee(name, email);
    }

    public void createEmployee(String name, Email email, EmployeePosition position) {
        repositoryItem = repository.createEmployee(name, email, position);
    }

    public void listEmployessWithPosition(EmployeePosition position) {
        new EmployeeRepositoryOutputer(repository).listEmployessOfPosition(position);
    }

    public Employee getEmployeeByEmail(String emailAdress) {
        return repository.getEmployeeWithEmail(emailAdress);
    }

    @Override
    public void generateContentModels() {
        if (areContentModelsCreated())
            return;

        for (int i = 0; i < 5; i++) {
            String name = TiUtils.UpSkill.getRandomNome();
            String apelido = TiUtils.UpSkill.getRandomApelido();
            Email email = new Email(TiUtils.UpSkill.getRandomEmail(name));

            repository.addToRepository(new Employee(String.format("%s %s", name, apelido), email));
        }
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getEmployeeRepository();
        repositoryOutputer = new EmployeeRepositoryOutputer(repository);
    }
}
