/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.util.Scanner;

/**
 *
 * @author Zeeshan Khan
 */
public class Helloworld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("What is your name? ");
        
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        
        System.out.println("Your name is " + name);
    }
    
}
