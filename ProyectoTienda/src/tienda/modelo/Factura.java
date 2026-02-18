package tienda.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    private String numero;
    private LocalDate fecha;
    private List<ItemFactura> items;

    public Factura(String numero, LocalDate fecha) {
        this.numero = numero;
        this.fecha = fecha;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemFactura item) {
        items.add(item);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemFactura i : items) {
            subtotal += i.getPrecio();
        }
        return subtotal;
    }

    public double calcularIva() {
        return calcularSubtotal() * 0.19;
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularIva();
    }
}
