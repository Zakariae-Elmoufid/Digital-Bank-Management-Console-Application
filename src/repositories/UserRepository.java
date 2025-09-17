package repositories;

import interfaces.UserInterface;
import model.User;
import java.util.List;
import java.util.ArrayList;

public class UserRepository implements UserInterface {

    private  static List<User> users = new ArrayList<>();


    public User createUser( String fullName, String email, String password, String address) {
        User  user = new User(fullName , email ,password,address);
        users.add(user);
        System.out.println("User created"+ user.getEmail());
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User findUserByEmail(String email){
        for(User user : users){
             if(user.getEmail().equals(email)){
             return user ;
            }
        }
        return null;
    }
}
