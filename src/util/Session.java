package util;

import model.User;
import java.util.Map;
import java.util.HashMap;

public class Session {

    private  static  Session instance;
    private  Map<String , String> session =  new HashMap<>();


    public  static Session getInstance(){
        if(instance==null){
            instance=new Session();
        }
        return instance;
    }

    public static  void endSession(){
        instance = null;
    }

    public void setAttribute(String key, String value) {
        session.put(key, value);
    }

    public String getAttribute(String key) {
        return session.get(key);
    }




}
