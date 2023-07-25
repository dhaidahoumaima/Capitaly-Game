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
public class Service extends Fields{
       private int cost;
    //constractor   
        public Service(int cost){
            super("service");
            this.cost=cost;
        }

        
    //getter

    public int getCost() {
        return cost;
    }
    //setter
    public void setCost(int cost) {
        this.cost = cost;
    }
     
    
}
