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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }
    public String getAddress(){
        return this.address;
    }
}
