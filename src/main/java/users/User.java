package users;

import org.springframework.stereotype.Service;

@Service
public class User {
    private String username;
    private String password;



    public void setUsername(String name){
        this.username =name;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){this.password = password;}

    public String getPassword(){return this.password;}



}
