package CapitalyGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oumai
 */
public class CapitalyGame {
    
    private final ArrayList<Fields> fields;
   // private static ArrayList<Property> properties;
    private final ArrayList<Player> players;
    private final ArrayList<Integer> dices;
    static int numberfields;
    static int numberplayers;
   
        //constractor
        public CapitalyGame() {
            
        fields = new ArrayList<>();
        players = new ArrayList<>();
        dices = new ArrayList<>();
       // properties= new ArrayList<>();
         }
    
        
     void read(String filetxt)throws FileNotFoundException, InvalidInputException {
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filetxt)));
        
         //number of the fields
         numberfields = sc.nextInt();

        for(int i=0;i<numberfields;i++) {

            Fields f;
            switch (sc.next()) {
                  //in case field is property
                case "property":
                    f = new  Property();
                    break;
                    //in case field is lucky field
                case "lucky":
                    f = new Lucky(Integer.parseInt(sc.next()));
                    break;
                    //in case field is service field
                case "service":
                    f = new Service(Integer.parseInt(sc.next()));
                    break;  
                default:

                    throw new InvalidInputException();

            }
             //add fields to the arraylist
           fields.add(f);
            
        }

        
        // number of players
        numberplayers = sc.nextInt();
            for (int i = 0; i < numberplayers; i++) {              
               
                Player player;
                
                switch (sc.next()) {
                    //in case player is tactical
                case "TacticalPlayer":
                    player = new TacticalPlayer(sc.next());
                    break;
                     //in case player is greedy
                case "GreedyPlayer":
                    player = new greedyPlayer(sc.next());
                    break;
                    //in case player is careful
                case "CarefulPlayer":
                    player = new CarefulPlayer(sc.next());
                    break;  
                    //others
                default:
                    throw new InvalidInputException();
            }
                //add player to the arraylist
                players.add(player);

            }
        //read the roll dices from the file.
        
        while (sc.hasNextInt()) {     
            int dice=sc.nextInt();
            dices.add(dice);
        }


    }

    void report() {
        
        for(int i=0;i<dices.size();i++){
            for(Player p:players){
                //number of steps
                int stp=dices.get(i);
                //if the proprietor doesn't lose
                if(p.is_living()){ 
                    p.changePosition(stp,numberfields);
                    Fields field = fields.get(p.getPosition());
              
                     //in case the field is property
                    if(field.getType().equals("Property")){
                        //if the property doesn't have Proprietor
                        if(!((Property)field).hasProprietor()) {
                           p.buy_Property((Property) field);
                        }
                        //if the Property have a proprietor
                        else{
                            //if the p is the proprietor
                            if(((Property)field).getProprietor().equals(p)){
                                //if there is no house in the property
                                if(!((Property)field).getIshouse()){
                                    p.Build_House((Property) field);
                                }
                            }
                            //if the proprietor of the property is another
                            else{
                                p.pay_to_Proprietor((Property) field);
                            }
                        }
                        
                    }
                    
                    
                    else{
                        //in case the field is lucky
                        
                        if(field.getType().equals("Lucky")){
                       
                            p.get_money_luck((Lucky) field);
                                    }
                        //in case the field is service
                        
                        if(field.getType().equals("service")){
                          p.pay_to_bank((Service) field);
                        }
                        
                    }
                    
                    
                    
                }
                 //if the proprietor lost
                else{
                    for(int j=0;j<p.getPropreties().size();j++){
                        Property pr=p.getPropreties().get(j);
                        pr.lostproperty();
                    }
                }
        
                
                
                
            }
        }

    }
    
    
    
    
    
    
    
    public void clear() {
         fields.clear();
           players.clear();
         dices.clear();

    }
    
    
    
}
