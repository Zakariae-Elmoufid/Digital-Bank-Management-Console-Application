package services;

import  model.User;
import  repositories.UserRepository;
import ui.AccountMenu;

import java.util.List;


public class AuthService {


    private UserRepository userRepository;

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
}
