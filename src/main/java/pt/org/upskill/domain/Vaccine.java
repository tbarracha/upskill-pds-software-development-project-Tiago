package pt.org.upskill.domain;

import java.io.Serializable;
import java.util.Objects;

public class Vaccine implements Serializable, IOption {
    private int id;
    private String name;
    private Brand brand;
    private VaccineType vaccineType;

    private static int VaccineCount = 1;

    public Vaccine(String name, Brand brand, VaccineType vaccineType) {
        this.id = generateID();
        this.name = name;
        this.brand = brand;
        this.vaccineType = vaccineType;
    }

    private Vaccine(String name, Brand brand, VaccineType vaccineType, boolean isCopy) {
        if (isCopy) {
            this.id = generateID();
        } else {
            this.id = -1;
        }

        this.name = name;
        this.brand = brand;
        this.vaccineType = vaccineType;
    }

    private int generateID() {
        return VaccineCount++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    public VaccineCode getVaccineTypeCode() {
        return vaccineType.getCode();
    }

    public String getVaccineTypeCodeString() {
        return getVaccineTypeCode().getCodeString();
    }

    public static int getVaccineCount() {
        return VaccineCount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vaccine{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", brand=").append(brand);
        sb.append(", vaccineType=").append(vaccineType);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String getOptionDetails() {
        return String.format("ID: %d, %s-%s, Tech: %s, Brand: %s", id, name, vaccineType.getCodeString(), vaccineType.getVaccineTech().getName(), brand.getName());
    }

    @Override
    public Vaccine getOptionType() {
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Vaccine vaccine = (Vaccine) object;
        return id == vaccine.id && Objects.equals(name, vaccine.name) && Objects.equals(brand, vaccine.brand) && Objects.equals(vaccineType, vaccine.vaccineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, vaccineType);
    }
}
