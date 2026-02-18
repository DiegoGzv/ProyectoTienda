package tienda.app;

import tienda.modelo.*;

public class Main {

    public static void main(String[] args) {

        Producto p1 = new Producto("Laptop", 2500000);
        Producto p2 = new Producto("Mouse", 50000);
        Producto p3 = new Producto("Teclado", 80000);

        CarritoCompra carrito = new CarritoCompra("Diego");

        carrito.añadirProducto(p1);
        carrito.añadirProducto(p2);
        carrito.añadirProducto(p3);

        // El usuario decide quitar el mouse
        carrito.eliminarProducto(p2);

        // Ahora sí genera la factura
        Factura factura = carrito.generarFactura("F001");

        System.out.println("Subtotal: $" + factura.calcularSubtotal());
        System.out.println("IVA: $" + factura.calcularIva());
        System.out.println("Total: $" + factura.calcularTotal());
    }
}
