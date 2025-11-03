package ecommerce.pagos;

import ecommerce.interfaces.PagoConDescuento;

public class TarjetaCredito implements PagoConDescuento {
    private String numeroTarjeta;
    private String titular;

    public TarjetaCredito(String numeroTarjeta, String titular) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("\n💳 Procesando pago con Tarjeta de Crédito");
        System.out.println("   Titular: " + titular);
        System.out.println("   Tarjeta: **** **** **** " + numeroTarjeta.substring(numeroTarjeta.length() - 4));
        System.out.println("   Monto: $" + String.format("%.2f", monto));
        System.out.println("   ✓ Pago aprobado");
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        System.out.println("   ✓ Descuento del " + porcentaje + "% aplicado (promoción tarjeta)");
    }

    @Override
    public double obtenerMontoConDescuento(double monto, double porcentaje) {
        return monto * (1 - porcentaje / 100);
    }
}