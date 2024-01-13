package pt.org.upskill.domain;

import java.util.Objects;

public class EmployeePosition implements IOption<EmployeePosition> {

    public static final String NO_POSITION = "NONE";
    public static final String RECEPTIONIST = "RECEPTIONIST";
    public static final String NURSE = "NURSE";

    private String position;

    public EmployeePosition(String function) {
        this.position = function;
    }

    public EmployeePosition() {
        position = NO_POSITION;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String getOptionDetails() {
        return position;
    }

    @Override
    public EmployeePosition getOptionType() {
        return this;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        EmployeePosition that = (EmployeePosition) other;
        return position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
