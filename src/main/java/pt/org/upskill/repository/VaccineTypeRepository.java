package pt.org.upskill.repository;

import pt.org.upskill.domain.VaccineCode;
import pt.org.upskill.domain.VaccineTech;
import pt.org.upskill.domain.VaccineType;

import java.util.ArrayList;
import java.util.List;

public class VaccineTypeRepository extends Repository<VaccineType> {

    public VaccineType createVaccineType(VaccineCode code, String shortDescription, VaccineTech vaccineTech) {
        return new VaccineType(code, shortDescription, vaccineTech);
    }
}
