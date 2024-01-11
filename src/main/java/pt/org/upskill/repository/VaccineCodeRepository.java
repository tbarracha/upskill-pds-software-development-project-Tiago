package pt.org.upskill.repository;

import pt.org.upskill.domain.VaccineCode;

public class VaccineCodeRepository extends Repository<VaccineCode> {

    public VaccineCode createCode(String codeString) {
        return new VaccineCode(codeString);
    }
}
