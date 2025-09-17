package model;
import java.util.UUID;

public class User {

    private UUID id;
    private String fullName;
    private String email;
    private String password;
    private String address;


    public User(String fullName, String email, String password, String address) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public UUID getId() {
        return this.id;
    }
    public String getFullName() {
        return this.fullName;
    }
    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }
}
