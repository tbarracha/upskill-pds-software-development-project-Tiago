package pt.org.upskill.repository;

import pt.org.upskill.domain.Brand;
import pt.org.upskill.domain.Vaccine;
import pt.org.upskill.domain.VaccineType;

public class VaccineRepository extends Repository<Vaccine> {
    public Vaccine createVaccine(String name, Brand brand, VaccineType vaccineType) {
        return new Vaccine(name, brand, vaccineType);
    }


}
