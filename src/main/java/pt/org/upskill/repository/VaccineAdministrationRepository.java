package pt.org.upskill.repository;

import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.Vaccination;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.domain.VaccineAdministration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VaccineAdministrationRepository extends Repository<VaccineAdministration> {

    public VaccineAdministration createVaccineAdministration(Employee nurse, SNSUser snsUser, VaccinationCenter vaccinationCenter, Date date) {
        return new VaccineAdministration(nurse, snsUser, vaccinationCenter, date);
    }

    public VaccineAdministration createVaccineAdministration(Vaccination vaccination) {
        return new VaccineAdministration(vaccination.getNurse(), vaccination.getSnsUser(), vaccination.getVaccinationCenter(), vaccination.getDate());
    }

    public List<VaccineAdministration> getVaccineAdministrationsBySNSUser(SNSUser snsUser) {
        List<VaccineAdministration> list = new ArrayList<>();

        for (VaccineAdministration administration : contentList) {
            if (administration.getSnsUser().equals(snsUser)) {
                list.add(administration);
            }
        }

        return list;
    }

    public List<VaccineAdministration> getVaccineAdministrationsByVaccinationCenter(VaccinationCenter vaccinationCenter) {
        List<VaccineAdministration> list = new ArrayList<>();

        for (VaccineAdministration administration : contentList) {
            if (administration.getVaccinationCenter().equals(vaccinationCenter)) {
                list.add(administration);
            }
        }

        return list;
    }
}
