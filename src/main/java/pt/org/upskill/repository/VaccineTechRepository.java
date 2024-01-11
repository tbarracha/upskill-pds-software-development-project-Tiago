package pt.org.upskill.repository;

import pt.org.upskill.domain.VaccineTech;

import java.util.List;

public class VaccineTechRepository extends Repository<VaccineTech> {

    public List<VaccineTech> vaccineTechList() {
        return contentList;
    }

    public int nextId() {
        int maxId = 0;
        for (VaccineTech vaccineTech : contentList) {
            if (vaccineTech.getId() > maxId) {
                maxId = vaccineTech.getId();
            }
        }

        return maxId+1;
    }

    public VaccineTech getById(int id) {
        for (VaccineTech vaccineTech : contentList) {
            if (vaccineTech.getId() == id) {
                return vaccineTech;
            }
        }

        return null;
    }

    public VaccineTech createVaccineTech(String name, String description) {
        return new VaccineTech(name, description);
    }
}