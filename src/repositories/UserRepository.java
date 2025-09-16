package repositories;

import interfaces.UserInterface;
import model.User;
import java.util.List;
import java.util.ArrayList;

public class UserRepository implements UserInterface {

    List<User> users = new ArrayList<>();


    public boolean createUser(String id, String fullName, String email, String password, String address) {
        User  user = new User(fullName , email ,password,address);
        if(users.add(user)){
            return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
