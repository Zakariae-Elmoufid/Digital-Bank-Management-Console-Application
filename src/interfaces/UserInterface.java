package interfaces;

import java.util.List;
import model.User;

public interface UserInterface {

     User createUser(String fullName, String email ,String password ,String address);
     List<User> getAllUsers();
     User findUserByEmail(String email);

}
