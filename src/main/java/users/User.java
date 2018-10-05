package users;

import org.springframework.stereotype.Service;
import springTest.Consumer;

import java.util.List;


@Service
public class User {

    private int id;
    private String username;
    private String password;
    private String valid;
    private List<Consumer> consumer;


    public void setUsername(String name){
        this.username =name;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){this.password = password;}

    public String getPassword(){return this.password;}


    public void setId(int id){
        this.id =id;
    }

    public int getId(){
        return id;
    }

    public String getValid(){
        return valid;
    }
    public void setValid(String valid){
        this.valid =valid;
    }


    public void setConsumers (List<Consumer> consumer){
        this.consumer = consumer;
    }
    public List<Consumer>getConsumer(){
        return consumer;
    }

}
