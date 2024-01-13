package pt.org.upskill.ui;

import TiWorks.TiUtils;
import pt.org.upskill.auth.Email;
import pt.org.upskill.auth.Password;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.controller.Controllers;
import pt.org.upskill.controller.UserController;
import pt.org.upskill.domain.Role;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.RoleRepository;
import pt.org.upskill.ui.BaseUI.UI;
import pt.org.upskill.ui.utils.Utils;

import java.util.List;

public class RegisterSNSUserUI extends UI {

    UserController userController = Controllers.getInstance().getUserController();

    @Override
    public void run() {
        printTitle("REGISTER SNS USER");

        try {
            String code = RoleRepository.ROLE_SNSUSER;
            Role role = Repositories.getInstance().getRoleRepository().getRoleByName(RoleRepository.ROLE_SNSUSER);
            String adress = "";

            do {
                adress = Utils.readLineFromConsole("SNS User email: ");
            } while (!Email.isValidAddress(adress));

            Email email = new Email(adress);

            String phoneNumber = "";
            do {
                phoneNumber = Utils.readLineFromConsole("Phone Number (9 digits): ");

                if (!SNSUser.isPhoneNumberValid(phoneNumber)) {
                    System.out.println("Phone number is invalid");
                    continue;
                }

                break;
            } while (true);

            String snsNumber = "";
            boolean isValid = false;
            List<SNSUser> snsUsers = Repositories.getInstance().getUserRepository().getSNSUsers();
            do {
                snsNumber = Utils.readLineFromConsole("SNS Number (9 digits): ");

                if (!SNSUser.isSNSNumberValid(snsNumber)) {
                    System.out.println("SNS number is invalid");
                    continue;
                } else {
                    boolean foundSameNumber = false;
                    for (SNSUser user : snsUsers) {
                        if (user.getSNSNumber().equals(snsNumber)) {
                            foundSameNumber = true;
                            break;
                        }
                    }

                    isValid = !foundSameNumber;
                }

                if (isValid) {
                    break;
                }
            } while (true);

            String citizenCardNumber = "";
            do {
                citizenCardNumber = Utils.readLineFromConsole("Citizen Card Number (9 digits): ");

                if (!SNSUser.isCitizenCardNumberValid(citizenCardNumber)) {
                    System.out.println("Citizien Card Number is invalid");
                    continue;
                }

                for (SNSUser user : snsUsers) {
                    if (user.getCitizenCardNumber().equals(citizenCardNumber)) {
                        break;
                    }
                }

                break;
            } while (true);

            String pass = Utils.readLineFromConsole("SNS User password: ");

            userController.createSNSUser(code, role, email, new Password(pass), snsNumber, citizenCardNumber, phoneNumber);

            if (userController.confirm()) {
                System.out.println(String.format("\nCreated SNS User: %s", email.getEmailAddress()));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
