package excepciones;

import java.io.*;
import java.util.Scanner;

public class EjerciciosExcepciones {
    
    public static void divisionSegura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== EJERCICIO 1: DIVISIÓN SEGURA ===");
        
        try {
            System.out.print("Ingrese el dividendo: ");
            int dividendo = scanner.nextInt();
            System.out.print("Ingrese el divisor: ");
            int divisor = scanner.nextInt();
            
            int resultado = dividendo / divisor;
            System.out.println("Resultado: " + dividendo + " / " + divisor + " = " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("❌ Error: No se puede dividir por cero");
        } catch (Exception e) {
            System.out.println("❌ Error: Entrada inválida");
        }
    }
    
    public static void conversionCadenaNumero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== EJERCICIO 2: CONVERSIÓN DE CADENA A NÚMERO ===");
        
        try {
            System.out.print("Ingrese un número: ");
            String entrada = scanner.nextLine();
            
            int numero = Integer.parseInt(entrada);
            System.out.println("✓ Conversión exitosa. Número ingresado: " + numero);
            System.out.println("El doble del número es: " + (numero * 2));
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: La cadena ingresada no es un número válido");
        }
    }
    
    public static void lecturaArchivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== EJERCICIO 3: LECTURA DE ARCHIVO ===");
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            int numeroLinea = 1;
            
            System.out.println("\n--- Contenido del archivo ---");
            while ((linea = reader.readLine()) != null) {
                System.out.println(numeroLinea + ": " + linea);
                numeroLinea++;
            }
            System.out.println("--- Fin del archivo ---\n");
        } catch (FileNotFoundException e) {
            System.out.println("❌ Error: El archivo no existe");
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("✓ Archivo cerrado correctamente");
                }
            } catch (IOException e) {
                System.out.println("❌ Error al cerrar el archivo");
            }
        }
    }
    
    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0) {
            throw new EdadInvalidaException("La edad no puede ser negativa");
        }
        if (edad > 120) {
            throw new EdadInvalidaException("La edad no puede ser mayor a 120 años");
        }
        System.out.println("✓ Edad válida: " + edad + " años");
    }
    
    public static void excepcionPersonalizada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== EJERCICIO 4: EXCEPCIÓN PERSONALIZADA ===");
        
        try {
            System.out.print("Ingrese su edad: ");
            int edad = scanner.nextInt();
            
            validarEdad(edad);
            
            if (edad < 18) {
                System.out.println("Categoría: Menor de edad");
            } else if (edad < 65) {
                System.out.println("Categoría: Adulto");
            } else {
                System.out.println("Categoría: Adulto mayor");
            }
        } catch (EdadInvalidaException e) {
            System.out.println("❌ Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error: Debe ingresar un número entero");
        }
    }
    
    public static void tryWithResources() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== EJERCICIO 5: TRY-WITH-RESOURCES ===");
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int numeroLinea = 1;
            int totalLineas = 0;
            int totalCaracteres = 0;
            
            System.out.println("\n--- Contenido del archivo ---");
            while ((linea = reader.readLine()) != null) {
                System.out.println(numeroLinea + ": " + linea);
                numeroLinea++;
                totalLineas++;
                totalCaracteres += linea.length();
            }
            
            System.out.println("--- Fin del archivo ---");
            System.out.println("\n📊 Estadísticas:");
            System.out.println("   Total de líneas: " + totalLineas);
            System.out.println("   Total de caracteres: " + totalCaracteres);
            System.out.println("   ✓ Recurso cerrado automáticamente\n");
        } catch (FileNotFoundException e) {
            System.out.println("❌ Error: El archivo no existe");
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo");
        }
    }
    
    public static void crearArchivoPrueba() {
        String nombreArchivo = "archivo_prueba.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("Esta es la primera línea del archivo de prueba\n");
            writer.write("Segunda línea con más contenido\n");
            writer.write("Tercera línea para demostrar la lectura\n");
            writer.write("Última línea del archivo\n");
            
            System.out.println("✓ Archivo de prueba creado exitosamente");
        } catch (IOException e) {
            System.out.println("❌ Error al crear archivo de prueba");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  EJERCICIOS DE MANEJO DE EXCEPCIONES      ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. División segura");
            System.out.println("2. Conversión de cadena a número");
            System.out.println("3. Lectura de archivo (con finally)");
            System.out.println("4. Validación de edad (excepción personalizada)");
            System.out.println("5. Lectura de archivo (try-with-resources)");
            System.out.println("6. Crear archivo de prueba");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1: divisionSegura(); break;
                    case 2: conversionCadenaNumero(); break;
                    case 3: lecturaArchivo(); break;
                    case 4: excepcionPersonalizada(); break;
                    case 5: tryWithResources(); break;
                    case 6: crearArchivoPrueba(); break;
                    case 0:
                        continuar = false;
                        System.out.println("\n¡Hasta luego! 👋");
                        break;
                    default:
                        System.out.println("❌ Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("❌ Error en la entrada del menú");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}