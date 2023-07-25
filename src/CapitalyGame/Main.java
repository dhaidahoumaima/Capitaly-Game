/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapitalyGame;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author oumai
 */
public class Main {
    public static void main(String[] args) {
        
     CapitalyGame capitaly = new CapitalyGame();
        try {
            capitaly.read("file.txt");
            
        } catch(FileNotFoundException ex){
            System.out.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException ex) {
            System.out.println("Invalid input!");
            System.exit(-1);
        }
        
        capitaly.report();
        capitaly.clear();
    }
    
}
