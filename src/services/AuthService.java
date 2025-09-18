package services;

import  model.User;
import  repositories.UserRepository;
import ui.AccountMenu;
import util.Session;

import java.util.List;


public class AuthService {


    private UserRepository userRepository;
    private Session session =  Session.getInstance();


    public  AuthService (UserRepository userRepository){
          this.userRepository = userRepository;
    }

    public User Register(String fullName ,String email,String password,String address){


        User existing = userRepository.findUserByEmail(email);


        return userRepository.createUser(fullName,  email, password, address);
    }

    public User Login(String email,String password){
         User  user = userRepository.findUserByEmail(email);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public  User   updateProfile(String email, String address){
        List<User> users = userRepository.getAllUsers();
        for(User user : users){
            if(user.getEmail().equals(this.session.getEmail())){
                user.setAddress(address);
                user.setEmail(email);
                this.session.setEmail(email);
                this.session.setAddress(address);
                return user;
            }
        }
        return null;
    }

    public boolean changePassword(String oldPassword, String newPassword){
        List<User> users = userRepository.getAllUsers();
        for(User user : users){
            if(user.getEmail().equals(this.session.getEmail()) && user.getPassword().equals(oldPassword)){
                user.setPassword(newPassword);
               return true;
            }
        }
        return false;
    }
}
