package springTest;



public class Consumer {

    private String username;
    private String item;
    private String date;
    private int money;

    public void setUsername(String username){
        this.username =username;
    }
    public String getUsername(){
        return username;
    }


    public String getItem(){
        return item;
    }

    public void setItem(String item){
        this.item =item;
    }
    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money=money;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date =date;
    }
}
