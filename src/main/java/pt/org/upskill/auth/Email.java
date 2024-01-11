package pt.org.upskill.auth;

public class Email {
    private String address;

    public Email(String address, boolean ignoreValidation) throws Exception {
        if (ignoreValidation == false && validate(address) == false) {
            throw new Exception(String.format("Invalid email address: %s", address));
        }

        this.address = address;
    }

    public Email() {}

    private boolean validate(String email) {
        return email.contains("@");
    }

    public String address() {
        return address;
    }
}
