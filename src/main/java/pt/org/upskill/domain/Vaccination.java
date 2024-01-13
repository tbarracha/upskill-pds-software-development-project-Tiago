package pt.org.upskill.domain;

import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;

import java.util.Date;

public class Vaccination implements IOption<Vaccination> {
    private Employee nurse;
    private SNSUser snsUser;
    private VaccineType vaccine;
    private VaccinationCenter vaccinationCenter;
    private Date date;

    public Vaccination(Employee nurse, SNSUser snsUser, VaccineType vaccine, VaccinationCenter vaccinationCenter, Date date) {
        this.nurse = nurse;
        this.snsUser = snsUser;
        this.vaccine = vaccine;
        this.vaccinationCenter = vaccinationCenter;
        this.date = date;
    }

    public Employee getNurse() {
        return nurse;
    }

    public SNSUser getSnsUser() {
        return snsUser;
    }

    public VaccineType getVaccineType() {
        return vaccine;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public Date getDate() {
        return date;
    }

    public void setNurse(Employee nurse) {
        this.nurse = nurse;
    }

    public void setVaccineType(VaccineType vaccine) {
        this.vaccine = vaccine;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getOptionDetails() {
        return String.format("Nurse: %s, SNSUser: %s, Vaccine { %s }, Date: %s", nurse.getOptionDetails(), snsUser.getEmail(), vaccine.getOptionDetails(), date.toString());
    }

    @Override
    public Vaccination getOptionType() {
        return this;
    }
}
