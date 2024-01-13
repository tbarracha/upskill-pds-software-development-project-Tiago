package pt.org.upskill.auth;

public class Email {
    private String address;

    public Email(String emailAddress, boolean ignoreValidation) throws Exception {
        if (ignoreValidation == false && isValidAddress(emailAddress) == false) {
            throw new Exception(String.format("Invalid email address: %s", emailAddress));
        }

        this.address = emailAddress;
    }

    public Email(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return address;
    }

    public static boolean isValidAddress(String emailAdress) {
        return emailAdress.contains("@");
    }
}
