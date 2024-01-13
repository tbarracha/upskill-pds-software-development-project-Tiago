package pt.org.upskill.domain;

import java.io.Serializable;
import java.util.Objects;

public class Brand extends Describable implements IOption<Brand>, Serializable {
    public Brand(String name) {
        super(name);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Brand{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String getOptionDetails() {
        return name;
    }

    @Override
    public Brand getOptionType() {
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Brand brand = (Brand) object;
        return Objects.equals(name, brand.name);
    }
}
