/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pila;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Owen_04
 */
public class VerificarPalindromo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner sc = new Scanner(System.in); 
    System.out.print("Ingrese palabra: "); 
    String palabra = sc.nextLine(); 
    Stack<Character> pila = new Stack<>(); 
    
    for (char c : palabra.toCharArray()) pila.push(c); 
        String invertida = ""; 
    while (!pila.isEmpty()) invertida += pila.pop(); 
    
    if (palabra.equalsIgnoreCase(invertida)) 
    System.out.println("Es palíndromo"); 
    else 
    System.out.println("No es palíndromo"); 
    } 
}
   
    
