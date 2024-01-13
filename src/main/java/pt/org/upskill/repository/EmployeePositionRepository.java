package pt.org.upskill.repository;

import pt.org.upskill.domain.EmployeePosition;

public class EmployeePositionRepository extends Repository<EmployeePosition> {
    public EmployeePosition createEmployeePosition(String position) {
        return new EmployeePosition(position);
    }
}
