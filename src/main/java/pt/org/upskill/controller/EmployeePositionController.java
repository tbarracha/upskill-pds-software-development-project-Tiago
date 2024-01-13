package pt.org.upskill.controller;

import pt.org.upskill.domain.EmployeePosition;
import pt.org.upskill.repository.EmployeePositionRepository;
import pt.org.upskill.repository.Repositories;

public class EmployeePositionController extends Controller<EmployeePosition, EmployeePositionRepository> {

    public void createEmployeePosition(String position) {
        repositoryItem = repository.createEmployeePosition(position);
    }

    @Override
    public void generateContentModels() {
        repository.addToRepository(new EmployeePosition(EmployeePosition.NO_POSITION));
        repository.addToRepository(new EmployeePosition(EmployeePosition.RECEPTIONIST));
        repository.addToRepository(new EmployeePosition(EmployeePosition.NURSE));
    }

    @Override
    protected void setRepository() {
        repository = Repositories.getInstance().getEmployeePositionRepository();
    }
}
