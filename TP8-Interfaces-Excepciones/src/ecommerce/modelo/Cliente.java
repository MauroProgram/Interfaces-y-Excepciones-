package ecommerce.modelo;

import ecommerce.interfaces.Notificable;

public class Cliente implements Notificable {
    private String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("📧 Notificación para " + nombre + " (" + email + "):");
        System.out.println("   " + mensaje);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}