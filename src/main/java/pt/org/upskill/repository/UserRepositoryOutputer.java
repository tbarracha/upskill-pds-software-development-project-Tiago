package pt.org.upskill.repository;

import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;

public class UserRepositoryOutputer extends RepositoryOutputer<User> {
    public UserRepositoryOutputer(Repository<User> repository) {
        super(repository);
    }

    public SNSUser selectSNSUSerOption(boolean listOptions) {
        return selectOptionType(listOptions, SNSUser.class);
    }
}
