package ecommerce.pagos;

import ecommerce.interfaces.PagoConDescuento;

public class PayPal implements PagoConDescuento {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("\n🅿️ Procesando pago con PayPal");
        System.out.println("   Cuenta: " + email);
        System.out.println("   Monto: $" + String.format("%.2f", monto));
        System.out.println("   ✓ Pago procesado exitosamente");
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        System.out.println("   ✓ Descuento del " + porcentaje + "% aplicado");
    }

    @Override
    public double obtenerMontoConDescuento(double monto, double porcentaje) {
        return monto * (1 - porcentaje / 100);
    }
}