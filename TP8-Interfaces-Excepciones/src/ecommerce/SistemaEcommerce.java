package ecommerce;

import ecommerce.modelo.*;
import ecommerce.pagos.*;
import ecommerce.interfaces.PagoConDescuento;

public class SistemaEcommerce {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE E-COMMERCE ===\n");

        // Crear cliente
        Cliente cliente1 = new Cliente("Juan Pérez", "juan@email.com");

        // Crear productos
        Producto p1 = new Producto("Notebook Lenovo", 850000.00);
        Producto p2 = new Producto("Mouse Logitech", 25000.00);
        Producto p3 = new Producto("Teclado Mecánico", 45000.00);

        // Crear pedido
        Pedido pedido = new Pedido(1001);
        pedido.setCliente(cliente1);
        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);
        pedido.agregarProducto(p3);

        System.out.println(pedido);
        System.out.println();

        // Cambiar estados del pedido (genera notificaciones)
        pedido.cambiarEstado("EN_PREPARACION");
        pedido.cambiarEstado("ENVIADO");
        pedido.cambiarEstado("ENTREGADO");

        // Procesar pago con tarjeta de crédito (con descuento)
        PagoConDescuento tarjeta = new TarjetaCredito("1234567890123456", "Juan Pérez");
        double total = pedido.calcularTotal();
        double descuento = 10.0;
        tarjeta.aplicarDescuento(descuento);
        double montoFinal = tarjeta.obtenerMontoConDescuento(total, descuento);
        tarjeta.procesarPago(montoFinal);

        System.out.println("\n--- Segundo pedido ---\n");

        // Segundo pedido con PayPal
        Cliente cliente2 = new Cliente("María García", "maria@email.com");
        Pedido pedido2 = new Pedido(1002);
        pedido2.setCliente(cliente2);
        pedido2.agregarProducto(new Producto("Auriculares Sony", 35000.00));
        pedido2.agregarProducto(new Producto("Webcam HD", 28000.00));

        System.out.println(pedido2);
        System.out.println();

        pedido2.cambiarEstado("CONFIRMADO");

        // Pago con PayPal
        PagoConDescuento paypal = new PayPal("maria@email.com");
        double total2 = pedido2.calcularTotal();
        double descuento2 = 5.0;
        paypal.aplicarDescuento(descuento2);
        double montoFinal2 = paypal.obtenerMontoConDescuento(total2, descuento2);
        paypal.procesarPago(montoFinal2);
    }

    // Minimal nested Pedido class to resolve "Pedido cannot be resolved to a type"
    public static class Pedido {
        private int id;
        private Cliente cliente;
        private java.util.List<Producto> productos = new java.util.ArrayList<>();

        public Pedido(int id) {
            this.id = id;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public void agregarProducto(Producto producto) {
            this.productos.add(producto);
        }

        public void cambiarEstado(String estado) {
            System.out.println("Pedido " + id + " cambio a estado: " + estado);
        }

        public double calcularTotal() {
            double total = 0.0;
            for (Producto p : productos) {
                // Try typical getter or field names via reflection to remain compatible
                try {
                    java.lang.reflect.Method m = p.getClass().getMethod("getPrecio");
                    Object val = m.invoke(p);
                    if (val instanceof Number) {
                        total += ((Number) val).doubleValue();
                        continue;
                    }
                } catch (Exception e) {
                    // ignore and try other options
                }
                try {
                    java.lang.reflect.Field f = p.getClass().getDeclaredField("precio");
                    f.setAccessible(true);
                    Object val = f.get(p);
                    if (val instanceof Number) {
                        total += ((Number) val).doubleValue();
                        continue;
                    }
                } catch (Exception e) {
                    // ignore
                }
                try {
                    java.lang.reflect.Method m = p.getClass().getMethod("getPrice");
                    Object val = m.invoke(p);
                    if (val instanceof Number) {
                        total += ((Number) val).doubleValue();
                    }
                } catch (Exception e) {
                    // ignore
                }
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Pedido{id=").append(id).append(", cliente=").append(cliente).append(", productos=").append(productos).append('}');
            return sb.toString();
        }
    }
}