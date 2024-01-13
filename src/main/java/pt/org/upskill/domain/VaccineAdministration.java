package pt.org.upskill.domain;

import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;

import java.io.Serializable;
import java.util.Date;

public class VaccineAdministration implements IOption<VaccineAdministration>, Serializable {

    private Employee nurse;
    private SNSUser snsUser;
    private VaccinationCenter vaccinationCenter;
    private Date date;

    public VaccineAdministration(Employee nurse, SNSUser snsUser, VaccinationCenter vaccinationCenter, Date date) {
        this.nurse = nurse;
        this.snsUser = snsUser;
        this.vaccinationCenter = vaccinationCenter;
        this.date = date;
    }

    public Employee getNurse() {
        return nurse;
    }

    public SNSUser getSnsUser() {
        return snsUser;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String getOptionDetails() {
        return String.format("Nurse: %s, SNS User: %s, Location: %s, Date: %s", nurse.getEmail(), snsUser.getEmail(), vaccinationCenter.getName(), date.toString());
    }

    @Override
    public VaccineAdministration getOptionType() {
        return this;
    }
}
