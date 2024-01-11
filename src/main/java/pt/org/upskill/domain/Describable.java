package pt.org.upskill.domain;

public abstract class Describable {
    protected String name;
    protected String description;

    public Describable(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Describable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        if (description != null && description.isEmpty() == false) {
            return String.format("Name: %s, Description: %s", name, description);
        } else {
            return String.format("Name: %s", name);
        }
    }
}
