package pt.org.upskill.repository;

import pt.org.upskill.auth.Email;
import pt.org.upskill.auth.Password;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;
import pt.org.upskill.domain.Role;

import java.util.ArrayList;
import java.util.List;

public class UserRepository extends Repository<User> {

    private final List<SNSUser> snsUserList = new ArrayList<>();

    public User createUser(String code, Role role, Email email, Password password) {
        return new User(code, role, email, password);
    }

    public SNSUser createSNSUser(String code, Role role, Email email, Password password, String snsNumber, String citizenCardNumber, String phoneNumber) {
        return new SNSUser(code, role, email, password, snsNumber, citizenCardNumber, phoneNumber);
    }

    public User getUserByEmail(String address) {
        for (User user : contentList) {
            if (user.getEmail().getEmailAddress().equals(address)) {
                return user;
            }
        }

        return null;
    }

    public SNSUser getSNSUserByEmail(String address) {
        for (User user : contentList) {
            if (user instanceof SNSUser && user.getEmail().getEmailAddress().equals(address)) {
                return (SNSUser) user;
            }
        }

        return null;
    }

    public List<SNSUser> getSNSUsers() {
        return snsUserList;
    }

    @Override
    public boolean save(User user) {
        if (user instanceof SNSUser) {
            SNSUser snsUser = (SNSUser) user;

            if (snsUserList.contains(snsUser) == false) {
                snsUserList.add(snsUser);
                return true;
            }

            return false;
        } else {
            return addToRepository(user);
        }
    }
}
