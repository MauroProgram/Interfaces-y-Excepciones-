package ecommerce.interfaces;

public interface PagoConDescuento extends Pago {
    void aplicarDescuento(double porcentaje);
    double obtenerMontoConDescuento(double monto, double porcentaje);
}