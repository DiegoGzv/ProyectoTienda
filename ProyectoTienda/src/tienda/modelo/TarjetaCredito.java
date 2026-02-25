package tienda.modelo;

public class TarjetaCredito extends MetodoPago {

    private String numeroTarjeta;

    public TarjetaCredito(String numeroTarjeta) {

        if (!numeroTarjeta.matches("\\d{16}")) {
            throw new IllegalArgumentException(
                "La tarjeta debe contener exactamente 16 números."
            );
        }

        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " con Tarjeta de Crédito.");
        System.out.println("Tarjeta: ****" + numeroTarjeta.substring(12));
    }
}