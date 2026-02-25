package tienda.app;

import tienda.modelo.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Producto p1 = new Producto("Laptop", 2500000);
        Producto p2 = new Producto("Mouse", 50000);
        Producto p3 = new Producto("Teclado", 80000);

        CarritoCompra carrito = new CarritoCompra("Diego");

        carrito.añadirProducto(p1);
        carrito.añadirProducto(p2);
        carrito.añadirProducto(p3);

        carrito.eliminarProducto(p2);

        Factura factura = carrito.generarFactura("F001");

        System.out.println("Subtotal: $" + factura.calcularSubtotal());
        System.out.println("IVA: $" + factura.calcularIva());
        System.out.println("Total: $" + factura.calcularTotal());

        System.out.println("\nSeleccione método de pago:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. Nequi");

        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        MetodoPago metodo = null;

        try {

            if (opcion == 1) {
                System.out.print("Ingrese número de tarjeta (16 dígitos): ");
                String numero = sc.nextLine();
                metodo = new TarjetaCredito(numero);

            } else if (opcion == 2) {
                System.out.print("Ingrese número de celular Nequi (10 dígitos): ");
                String numero = sc.nextLine();
                metodo = new Nequi(numero);

            } else {
                System.out.println("Opción inválida.");
                return;
            }

            metodo.procesarPago(factura.calcularTotal());

        } catch (IllegalArgumentException e) {
            System.out.println("Error en el pago: " + e.getMessage());
        }

        sc.close();
    }
}
    
