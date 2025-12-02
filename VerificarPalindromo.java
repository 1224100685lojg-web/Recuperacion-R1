/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pila;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 Este codigo permite leer una palabra desde consola,
 * invertirla utilizando una pila y determinar si es un palíndromo.
 * 
 * Un palíndromo es una palabra que se lee igual de izquierda a derecha
 * que de derecha a izquierda (ignorando mayúsculas/minúsculas).
 
 * @author Luis Owen Jaramillo Guerrero
 */
public class VerificarPalindromo {

    /**
     * Método principal del programa. Solicita al usuario una palabra,
     * la inserta carácter por carácter en una pila y luego la invierte
     * desapilando su contenido. Posteriormente compara la palabra original
     * con su versión invertida para determinar si es un palíndromo.
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner sc = new Scanner(System.in); 
    System.out.print("Ingrese palabra: "); 
    String palabra = sc.nextLine(); 

     // Pila que almacenará los caracteres de la palabra
    Stack<Character> pila = new Stack<>(); 
        
    // Insertar cada carácter de la palabra en la pila
    for (char c : palabra.toCharArray()) 
    pila.push(c); 
        
     // Construcción de la palabra invertida
        String invertida = ""; 
    while (!pila.isEmpty()) invertida += pila.pop(); 

    // Verificar si original e invertida son iguales ignorando mayúsculas/minúsculas
    if (palabra.equalsIgnoreCase(invertida)) 
    System.out.println("Es palíndromo"); 
    else 
    System.out.println("No es palíndromo"); 
    } 
}
   
    

