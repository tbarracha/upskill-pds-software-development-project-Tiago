package pt.org.upskill.domain;

import java.io.Serializable;
import java.util.Objects;

public class VaccineCode implements Serializable, IOption<VaccineCode> {

    private String code;

    public VaccineCode(String code) {
        this.code = code.toUpperCase();
    }

    public String getCodeString() {
        return code;
    }

    @Override
    public String getOptionDetails() {
        return code;
    }

    @Override
    public VaccineCode getOptionType() {
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VaccineCode code1 = (VaccineCode) object;
        return Objects.equals(code, code1.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
