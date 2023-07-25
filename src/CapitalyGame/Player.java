package CapitalyGame;


import java.util.ArrayList;



/**
 *
 * @author oumai
 */
public abstract class Player {
    private int balance;
    private ArrayList<Property> propreties;
    private String name;
    private String strategy;
    private int position;
    

    public Player(String name,String strategy) {
        this.balance=10000;
        this.name=name;
        this.strategy=strategy;
        this.propreties=new ArrayList<Property>();
        this.position=0;
    
    }
    //getter 
    public int getBalance() {
        return balance;
    }
    //setter
    public void setBalance(int balance) {
        this.balance = balance;
    }
    //getter
    public ArrayList<Property> getPropreties() {
        return propreties;
    }
    //setter
    public void setPropreties(ArrayList<Property> propreties) {
        this.propreties = propreties;
    }
    //getter
    public String getName() {
        return name;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }
    //getter
    public String getStrategy() {
        return strategy;
    }
    //setter
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
    //getter
    public int getPosition() {
        return position;
    }
    //setter
    public void setPosition(int position) {
        this.position = position;
    }
    
    
    //this function return false in case the player  lost and their properties became free to buy
    
    public boolean is_living(){
        if(this.balance>0){
            return true;
        }else
            return false;
    }
    //abstracts functions 
    
    public abstract void buy_Property(Property pr);
    public abstract void Build_House(Property pr);
    
    /*   this function is if a player steps on a property field that is owned by somebody else, 
         the player should pay the owner 500 if there is no house on the field, or 2000 if there is a house on it.
    */
    
    public void pay_to_Proprietor(Property pr){
        if(pr.getIshouse() ==true){
           if(this.balance>=2000){
            this.balance=this.balance-2000;
            pr.getProprietor().setBalance(pr.getProprietor().getBalance()+2000);
             

        }  
        }else{
           if(this.balance>=500){
            this.balance=this.balance-500;
             pr.getProprietor().setBalance(pr.getProprietor().getBalance()+500);

        }  
        }
        
    }

    //if a player Stepping on a lucky field,you will get money from bank.
    public void get_money_luck(Lucky lk){
       this.balance=this.balance+lk.getCost();
    }
       
    //if a player Stepping on a service field,you will give money to bank.
    
    public void pay_to_bank(Service sr){
      this.balance=this.balance-sr.getCost();
    }
    //print out the winner with his strategy and his balance and his properties.
    
    @Override
    public String toString() {
        return "the winner is the Player{" +  ": name=" + name +  ",with a strategy=" + strategy +" and with a balance=" + balance + ", propreties=" + propreties + '}';
    }
    //this function change position of the player
    public void changePosition(int stp,int numberfield){
        int current_position=this.getPosition()+stp;
        if(current_position<numberfield){
            this.setPosition(current_position);
        }else{
            this.setPosition(current_position%numberfield);
        }
    }

    
}
