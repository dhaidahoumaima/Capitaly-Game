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
public class Property extends Fields{
    private Player proprietor;
    private Boolean ishouse;
    
    public Property() {
        super("property");
        this.proprietor = null;
        this.ishouse=false;
    }
    //getter 
    public Player getProprietor() {
        return proprietor;
    }
    //setter
    public void setProprietor(Player proprietor) {
        this.proprietor = proprietor;
    }
    //getter
    public Boolean getIshouse() {
        return ishouse;
    }
    //getter
    public void setIshouse(Boolean ishouse) {
        this.ishouse = ishouse;
    }
    //this function return true if the property has a proprietor and return false if doesn't have it.
    public boolean hasProprietor(){
        if(proprietor!=null){
            return true;
        }
        return false;
    }
    //this function remove the property from the prorietor if he lost.
    
    public void lostproperty(){
        this.ishouse=false;
        this.proprietor=null;
    }
   
  
}
