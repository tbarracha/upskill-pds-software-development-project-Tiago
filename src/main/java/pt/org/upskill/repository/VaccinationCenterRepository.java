package pt.org.upskill.repository;

import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.domain.VaccineType;
import pt.org.upskill.domain.WaitingRoom;

import java.util.ArrayList;
import java.util.List;

public class VaccinationCenterRepository extends Repository<VaccinationCenter> {
    public VaccinationCenter createVaccinationCenter(String name, String location, VaccineType vaccineType) {
        return new VaccinationCenter(name, location, vaccineType);
    }

    public VaccinationCenter createVaccinationCenter(String name, String location, VaccineType vaccineType, WaitingRoom waitingRoom) {
        return new VaccinationCenter(name, location, vaccineType, waitingRoom);
    }

    public VaccinationCenter createVaccinationCenter(String name, String location, VaccineType vaccineType, List<SNSUser> usersWaiting) {
        return new VaccinationCenter(name, location, vaccineType, usersWaiting);
    }

    public VaccinationCenter getVaccinationCenterWithVaccineType(VaccineType vaccineType) {
        for (VaccinationCenter vacCenter : contentList) {
            if (vacCenter.getVaccineType().equals(vaccineType)) {
                return vacCenter;
            }
        }

        return null;
    }

    public List<VaccinationCenter> getVaccinationCentersWithVaccineType(VaccineType vaccineType) {
        List<VaccinationCenter> list = new ArrayList<>();

        for (VaccinationCenter vacCenter : contentList) {
            if (vacCenter.getVaccineType().equals(vaccineType)) {
                list.add(vacCenter);
            }
        }

        return list;
    }
}
