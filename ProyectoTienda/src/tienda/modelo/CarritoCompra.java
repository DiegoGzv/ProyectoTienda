/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.modelo;
import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private String usuario;
    private List<Producto> productos;
    
    public CarritoCompra(String usuario){
    this.usuario = usuario;
    this.productos = new ArrayList<>();
    }
    
    public void añadirProducto(Producto producto){
    productos.add(producto);
    }
    
    public Factura generarFactura(String numero){
    Factura factura = new Factura(numero, java.time.LocalDate.now());
    
    for (Producto p : productos){
        factura.agregarItem(
        new ItemFactura(p.getNombre(), p.getPrecio())
        );
    }
    return factura;
    }
}
