package interfaces;

import java.util.List;
import model.User;

public interface UserInterface {

     boolean createUser(String fullName, String email ,String password ,String address);
     List<User> getAllUsers();
}
