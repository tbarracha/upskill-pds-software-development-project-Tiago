package pt.org.upskill.auth;

import pt.org.upskill.domain.Role;

public class SNSUser extends User {
    private String snsNumber;
    private String citizenCardNumber;
    private String phoneNumber;

    public SNSUser(String code, Role role, Email email, Password password, String SNSNumber, String citizenCardNumber, String phoneNumber) {
        super(code, role, email, password);
        this.snsNumber = SNSNumber;
        this.citizenCardNumber = citizenCardNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getSNSNumber() {
        return snsNumber;
    }

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setSnsNumber(String snsNumber) {
        this.snsNumber = snsNumber;
    }

    public void setCitizenCardNumber(String citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static boolean isPhoneNumberValid(String phoneNumberStr) {
        // Check if the phone number has 9 digits and starts with 2 (landlines) or 9 (mobile)
        return phoneNumberStr.matches("^[29]\\d{8}$");
    }

    public static boolean isSNSNumberValid(String snsNumberStr) {
        return snsNumberStr.length() == 9;
    }

    public static boolean isCitizenCardNumberValid(String citizenCardNumberStr) {
        return citizenCardNumberStr.length() == 9;
    }

    @Override
    public String getOptionDetails() {
        return String.format("%s, %s, SNS Num: %s", getCode(), getEmail().getEmailAddress(), snsNumber);
    }

    @Override
    public String toString() {
        return getOptionDetails();
    }
}
