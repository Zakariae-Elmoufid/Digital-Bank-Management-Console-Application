package util;

import model.User;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

public class Session {

    private UUID userId;
    private String password;
    private String email;
    private String fullName;
    private String address;

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    private  static  Session instance;

    public  static Session getInstance(){
        if(instance==null){
            instance=new Session();
        }
        return instance;
    }

    public static  void endSession(){
        instance.userId = null;
        instance.password = null;
        instance.email = null;
        instance.fullName = null;
        instance.address = null;
        instance = null;
    }





}
