package ecommerce.modelo;

import ecommerce.interfaces.Pagable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable {
    private int numeroPedido;
    private List<Producto> productos;
    private String estado;
    private Cliente cliente;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.productos = new ArrayList<>();
        this.estado = "PENDIENTE";
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularTotal();
        }
        return total;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        if (cliente != null) {
            cliente.notificar("Pedido #" + numeroPedido + " cambió a estado: " + nuevoEstado);
        }
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public String getEstado() {
        return estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido #").append(numeroPedido).append(" [").append(estado).append("]\n");
        sb.append("Productos:\n");
        for (Producto p : productos) {
            sb.append("  - ").append(p).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }
}