package pt.org.upskill.repository;

import TiWorks.TiUtils;
import pt.org.upskill.domain.Vaccine;
import pt.org.upskill.domain.VaccineCode;
import pt.org.upskill.domain.VaccineType;

import java.util.*;

public class VaccineRepositoryOutputer extends RepositoryOutputer<Vaccine> {

    public VaccineRepositoryOutputer(Repository<Vaccine> repository) {
        super(repository);
    }

    @Override
    public void listOptionTypes() {
        List<Vaccine> vaccines = repository.getContentList();
        LinkedHashMap<VaccineCode, List<Vaccine>> sortedHasMap = new LinkedHashMap<>();

        List<VaccineCode> codes = Repositories.getInstance().getVaccineCodeRepository().getContentList();
        Collections.sort(codes, Comparator.comparing(VaccineCode::getCodeString));

        for (int i = 0; i < codes.size(); i++) {

            VaccineCode code = codes.get(i);
            sortedHasMap.put(code, new ArrayList<>());

            for (int j = 0; j < vaccines.size(); j++) {
                Vaccine vaccine = vaccines.get(j);

                if (vaccine.getVaccineTypeCodeString().equals(codes.get(i).getCodeString())) {
                    sortedHasMap.get(code).add(vaccine);
                }
            }
        }

        // Display the sorted list
        int index = 0;
        for (Map.Entry<VaccineCode, List<Vaccine>> entry : sortedHasMap.entrySet()) {
            for (Vaccine vaccine : entry.getValue()) {
                System.out.println(String.format("%d - %s", index, vaccine.getOptionDetails()));
                index++;
            }
        }
    }

}
