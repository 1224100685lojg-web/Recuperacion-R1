/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cola;

import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * @author Owen_04
 */
/**
 * Clase Supermercado
 * 
 * Simula el funcionamiento de un supermercado con carritos y cajas.
 * Se utilizan colas para modelar las cajas y una cola adicional para los carritos disponibles.
 * 
 * @author Luis Owen Jaramillo Guerrero
 */
public class Supermercado {
    
    private Queue<Integer> carritos;        // Carritos disponibles
    private Queue<Cliente>[] cajas;         // Colas de cajas
    private int totalClientes = 0;          // Contador de clientes que han llegado

    /**
     * Constructor: Inicializa las colas de carritos y cajas.
     */
    public Supermercado(int numCarritos, int numCajas) {
        carritos = new LinkedList<>();
        for (int i = 1; i <= numCarritos; i++) {
            carritos.offer(i);
        }

        cajas = new LinkedList[numCajas];
        for (int i = 0; i < numCajas; i++) {
            cajas[i] = new LinkedList<>();
        }
    }

    /**
     * Simula un nuevo cliente que llega al supermercado.
     */
    public void llegaCliente() {
        totalClientes++;
        System.out.println("\n🧍 Llega el cliente #" + totalClientes);

        if (carritos.isEmpty()) {
            System.out.println("🚫 No hay carritos disponibles, el cliente espera...");
            return;
        }

        int carrito = carritos.poll();
        Cliente nuevo = new Cliente(totalClientes, carrito);

        // Buscar la caja con menos clientes
        int cajaElegida = 0;
        for (int i = 1; i < cajas.length; i++) {
            if (cajas[i].size() < cajas[cajaElegida].size()) {
                cajaElegida = i;
            }
        }

        cajas[cajaElegida].offer(nuevo);
        System.out.println("🛒 Cliente #" + nuevo.getId() + " toma el carrito #" + carrito +
                " y se forma en la caja " + (cajaElegida + 1));
    }

    /**
     * Atiende un cliente por caja.
     */
    public void atenderClientes() {
        for (int i = 0; i < cajas.length; i++) {
            if (!cajas[i].isEmpty()) {
                Cliente atendido = cajas[i].poll();
                System.out.println(" Caja " + (i + 1) + " atendió al cliente #" + atendido.getId());
                carritos.offer(atendido.getCarrito());
                System.out.println(" Carrito #" + atendido.getCarrito() + " liberado.");
            } else {
                System.out.println(" Caja " + (i + 1) + " está vacía.");
            }
        }
    }

    /**
     * Muestra el estado actual del supermercado.
     */
    public void mostrarEstado() {
        System.out.println("\n===== ESTADO ACTUAL =====");
        System.out.println("Carritos disponibles: " + carritos.size());

        for (int i = 0; i < cajas.length; i++) {
            System.out.print("Caja " + (i + 1) + ": ");
            if (cajas[i].isEmpty()) {
                System.out.println("(vacía)");
            } else {
                for (Cliente c : cajas[i]) {
                    System.out.print("#" + c.getId() + " ");
                }
                System.out.println();
            }
        }
        System.out.println("==========================");
    }
}
/***********************/