package CapitalyGame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author oumai
 */
public abstract class Fields {
    
    private String type;

    //constractor  
    public Fields(String type){

    this.type = type;

    }
    //getter
      public String getType(){

        return type;

    }
     //setter
    public void setType(String type) {
        this.type = type;
    }
      
      
}
