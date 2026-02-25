package tienda.modelo;

public class Nequi extends MetodoPago {

    private String numeroCelular;

    public Nequi(String numeroCelular) {

        if (!numeroCelular.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                "El número de Nequi debe tener exactamente 10 dígitos."
            );
        }

        this.numeroCelular = numeroCelular;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " con Nequi.");
        System.out.println("Número asociado: " + numeroCelular);
    }
}