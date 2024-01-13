package pt.org.upskill.domain;

import java.io.Serializable;
import java.util.Objects;

public class VaccineType implements IOption<VaccineType>, Serializable {
    private VaccineCode code;
    private String shortDescription;
    private VaccineTech vaccineTech;

    public VaccineType(VaccineCode code, String shortDescription, VaccineTech vaccineTech) {
        this.code = code;
        this.shortDescription = shortDescription;
        this.vaccineTech = vaccineTech;
    }

    public VaccineCode getCode() {
        return code;
    }
    public String getCodeString() {
        return code.getCodeString();
    }

    public String getShortDescription() {
        return shortDescription;
    }
    public VaccineTech getVaccineTech() {
        return vaccineTech;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VaccineType{");
        sb.append("code='").append(code.getCodeString()).append('\'');
        sb.append(", shortDescription='").append(shortDescription).append('\'');
        sb.append(", vaccineTech=").append(vaccineTech);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String getOptionDetails() {
        return String.format("%s - Tech: %s", code.getCodeString(), vaccineTech.getOptionDetails());
    }

    @Override
    public VaccineType getOptionType() {
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VaccineType that = (VaccineType) object;
        return Objects.equals(code, that.code) && Objects.equals(shortDescription, that.shortDescription) && Objects.equals(vaccineTech, that.vaccineTech);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, shortDescription, vaccineTech);
    }
}
