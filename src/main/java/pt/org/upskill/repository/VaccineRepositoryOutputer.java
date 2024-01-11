package pt.org.upskill.repository;

import TiWorks.TiUtils;
import pt.org.upskill.domain.Vaccine;
import pt.org.upskill.domain.VaccineCode;
import pt.org.upskill.domain.VaccineType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VaccineRepositoryOutputer extends RepositoryOutputer<Vaccine> {

    public VaccineRepositoryOutputer(Repository<Vaccine> repository) {
        super(repository);
    }

    @Override
    public void listOptionTypes() {
        List<Vaccine> vaccines = repository.getContentList();
        List<Vaccine> sorted = new ArrayList<>();

        List<VaccineCode> codes = Repositories.getInstance().vaccineCodeRepository().getContentList();
        Collections.sort(codes, Comparator.comparing(VaccineCode::getCodeString));

        for (int i = 0; i < codes.size(); i++) {

            for (int j = 0; j < vaccines.size(); j++) {
                Vaccine vaccine = vaccines.get(j);

                if (vaccine.getVaccineTypeCodeString().equals(codes.get(i).getCodeString())) {
                    sorted.add(vaccine);
                }
            }
        }

        // Display the sorted list
        for (Vaccine vaccine : sorted) {
            System.out.println(vaccine.getOptionDetails());
        }
    }

}
