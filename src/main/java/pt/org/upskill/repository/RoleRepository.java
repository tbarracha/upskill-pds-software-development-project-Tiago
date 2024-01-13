package pt.org.upskill.repository;

import pt.org.upskill.auth.User;
import pt.org.upskill.domain.Role;


public class RoleRepository extends Repository<Role> {
    public static final String ROLE_MASTER_ADMIN = "MASTER ADMIN";
    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    public static final String ROLE_NURSE = "NURSE";
    public static final String ROLE_RECEPTIONIST = "RECEPTIONIST";
    public static final String ROLE_SNSUSER = "SNSUSER";

    public static final String ROLE_CODE_MASTER_ADMIN = "mad";
    public static final String ROLE_CODE_ADMIN = "adm";
    public static final String ROLE_CODE_NURSE = "nur";
    public static final String ROLE_CODE_RECEPTIONIST = "rec";
    public static final String ROLE_CODE_SNSUSER = "usr";

    private Role masterAdmin;

    public Role createRole(User user, String roleName) {
        if (isAdmin(user) == false) {
            return null;
        }

        return new Role(roleName);
    }

    public void setMasterAdmin() {
        if (masterAdmin != null)
            return;

        masterAdmin = new Role(ROLE_MASTER_ADMIN);
        addToRepository(masterAdmin);
    }

    private boolean isAdmin(User user) {
        return user.hasRole(getRoleByName(ROLE_ADMIN)) || user.hasRole(getRoleByName(ROLE_MASTER_ADMIN));
    }

    public Role getRoleByName(String name) {
        for (Role role : contentList) {
            if (name.equalsIgnoreCase(role.getRoleName())) {
                return role;
            }
        }

        return null;
    }
}
