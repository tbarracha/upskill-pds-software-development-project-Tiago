package pt.org.upskill.ui.BaseUI;

import TiWorks.TiUtils;
import pt.org.upskill.auth.Email;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.ui.utils.Utils;

import java.util.List;

public abstract class SNSUserUI extends UI {

    protected SNSUser getSNSUSer() {
        List<SNSUser> snsUserList = Repositories.getInstance().getUserRepository().getSNSUsers();
        SNSUser snsUser = (SNSUser) TiUtils.Lists.selectFromArrayOptions(snsUserList.toArray(), "Select SNS User (-1 to exit)",false);

        while (snsUser == null) {
            String emailAddress = Utils.readLineFromConsole("\nSNS User Email: ");

            if (!Email.isValidAddress(emailAddress)) {
                System.out.println("Invalid email...");
                continue;
            }

            snsUser = Repositories.getInstance().getUserRepository().getSNSUserByEmail(emailAddress);

            if (snsUser == null) {
                System.out.println(String.format("No user found with email: %s", emailAddress));
                return null;
            }
        }

        return null;
    }
}
