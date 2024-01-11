package pt.org.upskill.repository;

import pt.org.upskill.auth.Email;
import pt.org.upskill.auth.Password;
import pt.org.upskill.auth.User;
import pt.org.upskill.domain.Role;

public class UserRepository extends Repository<User> {

    public User userByEmail(String address) throws Exception {
        for (User user : contentList) {
            if (user.email().address().equals(address)) {
                return user;
            }
        }

        return null;
    }
}
