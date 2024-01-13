package pt.org.upskill.domain;

import TiWorks.TiUtils;
import pt.org.upskill.auth.SNSUser;
import pt.org.upskill.auth.User;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.RoleRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WaitingRoom implements Serializable {
    private List<SNSUser> users;

    public WaitingRoom() {
        users = new ArrayList<>();
    }

    public WaitingRoom(List<SNSUser> users) {
        this.users = new ArrayList<>(users);
    }

    public SNSUser getAtIndex(int index) {
        try {
            return users.get(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int size() {
        return users.size();
    }

    private boolean isSNSUser(SNSUser user) {
        return user.hasRole(Repositories.getInstance().getRoleRepository().getRoleByName(RoleRepository.ROLE_SNSUSER));
    }

    public boolean addUser(SNSUser user) {
        if (isSNSUser(user) == false)
            return false;

        if (users.contains(user) == false) {
            users.add(user);
            return true;
        }

        return false;
    }

    public boolean removeUser(SNSUser user) {
        if (isSNSUser(user) == false)
            return false;

        return users.remove(user);
    }

    public SNSUser selectSNSUser() {
        return TiUtils.Lists.selectFromListOptions(users, "Select Waiting Room SNS User: ", false);
    }
}
