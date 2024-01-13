package pt.org.upskill.domain;

import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccineTechRepository;

import java.io.Serializable;
import java.util.Objects;

public class VaccineTech extends Describable implements IOption<VaccineTech>, Serializable {
    private int id;

    public VaccineTech(String name, String description) {
        super(name, description);
        this.id = Repositories.getInstance().getVaccineTechRepository().nextId();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VaccineTech{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String getOptionDetails() {
        //return String.format("%s", name);
        return name;
    }

    @Override
    public VaccineTech getOptionType() {
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VaccineTech that = (VaccineTech) object;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}