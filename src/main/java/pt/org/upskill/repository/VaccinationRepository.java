package pt.org.upskill.repository;

import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VaccinationRepository extends Repository<Vaccination> {
    public Vaccination createVaccination(Employee nurse, SNSUser snsUser, VaccineType vaccine, VaccinationCenter vaccinationCenter, Date date) {
        return new Vaccination(nurse, snsUser, vaccine, vaccinationCenter, date);
    }

    public List<Vaccination> getVaccinationBySNSUser(SNSUser snsUser) {
        if (snsUser == null) {
            System.out.println("SNS User is null...!");
            return null;
        }

        List<Vaccination> list = new ArrayList<>();

        for (Vaccination vaccination : contentList) {
            if (vaccination.getSnsUser().equals(snsUser)) {
                list.add(vaccination);
            }
        }

        return list;
    }

    public List<Vaccination> getVaccinationByVaccinationCenter(VaccinationCenter center) {
        List<Vaccination> list = new ArrayList<>();

        for (Vaccination vaccination : contentList) {
            if (vaccination.getVaccinationCenter().equals(center)) {
                list.add(vaccination);
            }
        }

        return list;
    }

    public List<Vaccination> getVaccinationsBySNSUSerAndVaccinationCenter(SNSUser snsUser, VaccinationCenter center) {
        List<Vaccination> list = new ArrayList<>();

        for (Vaccination vaccination : contentList) {
            if (vaccination.getSnsUser().equals(snsUser) && vaccination.getVaccinationCenter().equals(center)) {
                list.add(vaccination);
            }
        }

        return list;
    }
}
