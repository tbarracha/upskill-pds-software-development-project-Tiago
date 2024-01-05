package org.upskill.controller;

public class UserController {
    /*
    public List<KeyValueDTO<String>> userList() {
        UserRepository repo = Repositories.getInstance().userRepository();
        return repo.keyValueList();
    }

    public boolean createUser(UserDTO userDTO) {
        UserRepository repo = Repositories.getInstance().userRepository();
        try {
            RoleController roleController = new RoleController();
            Role role = roleController.roleByName(userDTO.role);
            User user = new User(userDTO.code, role, new Email(userDTO.email), new Password(userDTO.password));
            repo.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

     */
}
