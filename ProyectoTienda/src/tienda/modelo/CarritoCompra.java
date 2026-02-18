package tienda.modelo;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {

    private String usuario;
    private List<Producto> productos;

    public CarritoCompra(String usuario) {
        this.usuario = usuario;
        this.productos = new ArrayList<>();
    }

    // Añadir producto
    public void añadirProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto añadido: " + producto.getNombre());
    }

    // Eliminar producto
    public void eliminarProducto(Producto producto) {
        if (productos.remove(producto)) {
            System.out.println("Producto eliminado: " + producto.getNombre());
        } else {
            System.out.println("El producto no está en el carrito.");
        }
    }

    // Generar factura
    public Factura generarFactura(String numero) {

        Factura factura = new Factura(numero, java.time.LocalDate.now());

        for (Producto p : productos) {
            factura.agregarItem(
                new ItemFactura(p.getNombre(), p.getPrecio())
            );
        }

        return factura;
    }

    public String getUsuario() {
        return usuario;
    }
}
