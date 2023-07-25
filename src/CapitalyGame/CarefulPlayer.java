/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapitalyGame;

/**
 *
 * @author oumai
 */
public class CarefulPlayer extends Player{

    public CarefulPlayer(String name) {
        super(name,"carefulPlayer");
    }
    
    //in this function,a property can be bought for 1000, and it will be owned by a player
  
    @Override
    public void buy_Property(Property pr) {
           if (this.getBalance() >= 2000){
           this.setBalance(this.getBalance()-1000);
           pr.setProprietor(this);
           this.getPropreties().add(pr);
           System.out.println("the property is buy by "+this.getName());
         } 
           
         
    }
    
    //in this function, the proprietor that has a property can build a house on it  
    
    @Override
    public void Build_House(Property pr) {
        
          if (this.getBalance() >= 8000){
           this.setBalance(this.getBalance()-4000);
           pr.setIshouse(Boolean.TRUE);
           System.out.println("the house is build by "+this.getName());

        }
    }
    
}
