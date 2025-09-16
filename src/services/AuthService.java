package services;

import  model.User;
import  repositories.UserRepository;

import java.util.List;


public class AuthService {


    UserRepository userRepository;

    public  AuthService (){
          userRepository = new UserRepository();
    }

    public void Register(String fullName ,String email,String password,String address){
        if(password.toCharArray().length > 6){
            System.out.println("password must less than 6");
        }

        List<User> users = userRepository.getAllUsers();

        for(User user : users){
            if(user.getEmail().equals(email)){
                System.out.println("Email already exists");
                break;
            }
        }
        boolean isCreated = userRepository.createUser(fullName,  email, password, address);
        if(isCreated){
            System.out.println("User created successfully");

        }
        else{
            System.out.println("User creation failed");
        }
    }

    public void Login(){

    }
}
