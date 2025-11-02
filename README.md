# 🎓 TP 8: Interfaces y Excepciones en Java

[![Java](https://img.shields.io/badge/Java-8%2B-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Educational-blue.svg)]()
[![Status](https://img.shields.io/badge/Status-Complete-success.svg)]()

> Trabajo Práctico N°8 - Programación II  
> **Tecnicatura Universitaria en Programación**

Sistema de E-commerce completo implementado con interfaces y manejo robusto de excepciones en Java, demostrando buenas prácticas de diseño orientado a objetos.

---

## 📋 Tabla de Contenidos

- [Descripción](#-descripción)
- [Características](#-características)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Requisitos](#-requisitos)
- [Instalación](#-instalación)
- [Uso](#-uso)
- [Conceptos Aplicados](#-conceptos-aplicados)
- [Ejemplos de Ejecución](#-ejemplos-de-ejecución)
- [Autor](#-autor)

---

## 🎯 Descripción

Este proyecto implementa dos componentes principales:

### **Parte 1: Sistema de E-commerce**
Sistema completo de comercio electrónico que utiliza interfaces para definir contratos de comportamiento, implementando:
- Gestión de productos y pedidos
- Múltiples métodos de pago (Tarjeta de Crédito, PayPal)
- Sistema de notificaciones para clientes
- Cálculo de totales con descuentos

### **Parte 2: Ejercicios de Manejo de Excepciones**
Suite de ejercicios prácticos que demuestran:
- Manejo de excepciones estándar (checked y unchecked)
- Creación de excepciones personalizadas
- Uso de try-with-resources para gestión de recursos
- Buenas prácticas con bloques finally

---

## ✨ Características

### 🛒 Sistema E-commerce

- ✅ **Interfaces como contratos**: `Pagable`, `Pago`, `PagoConDescuento`, `Notificable`
- ✅ **Herencia múltiple**: Clases que implementan múltiples interfaces
- ✅ **Polimorfismo**: Uso de interfaces para flexibilidad en el diseño
- ✅ **Patrón Observer**: Sistema de notificaciones para cambios de estado
- ✅ **Gestión de pedidos**: Lista dinámica de productos con cálculo automático de totales
- ✅ **Múltiples medios de pago**: TarjetaCredito y PayPal con descuentos aplicables

### 🛡️ Manejo de Excepciones

- ✅ **División segura**: Captura de `ArithmeticException`
- ✅ **Conversión de tipos**: Manejo de `NumberFormatException`
- ✅ **Lectura de archivos**: Gestión de `FileNotFoundException` e `IOException`
- ✅ **Excepción personalizada**: `EdadInvalidaException` para validación de datos
- ✅ **Try-with-resources**: Cierre automático de recursos
- ✅ **Menú interactivo**: Interfaz de usuario para probar cada ejercicio

---

## 📁 Estructura del Proyecto

```
TP8-Interfaces-Excepciones/
│
├── 📂 src/
│   ├── 📂 ecommerce/                    # Parte 1: Sistema E-commerce
│   │   ├── 📄 SistemaEcommerce.java     # Clase principal con ejemplos
│   │   │
│   │   ├── 📂 interfaces/               # Contratos de comportamiento
│   │   │   ├── 📄 Pagable.java
│   │   │   ├── 📄 Pago.java
│   │   │   ├── 📄 PagoConDescuento.java
│   │   │   └── 📄 Notificable.java
│   │   │
│   │   ├── 📂 modelo/                   # Clases de dominio
│   │   │   ├── 📄 Producto.java
│   │   │   ├── 📄 Pedido.java
│   │   │   └── 📄 Cliente.java
│   │   │
│   │   └── 📂 pagos/                    # Implementaciones de pago
│   │       ├── 📄 TarjetaCredito.java
│   │       └── 📄 PayPal.java
│   │
│   └── 📂 excepciones/                  # Parte 2: Manejo de Excepciones
│       ├── 📄 EjerciciosExcepciones.java  # Ejercicios prácticos
│       └── 📄 EdadInvalidaException.java  # Excepción personalizada
│
├── 📂 docs/                             # Documentación adicional
├── 📄 .gitignore                        # Archivos ignorados por Git
└── 📄 README.md                         # Este archivo
```

---

## 💻 Requisitos

- **Java JDK**: 8 o superior
- **IDE recomendado**: 
  - Visual Studio Code (con Extension Pack for Java)
  - IntelliJ IDEA
  - Eclipse
- **Sistema operativo**: Windows, Linux o macOS

---

## 🚀 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/TU_USUARIO/TP8-Interfaces-Excepciones.git
cd TP8-Interfaces-Excepciones
```

### 2. Verificar instalación de Java

```bash
java -version
javac -version
```

---

## 🎮 Uso

### Opción 1: Compilar y ejecutar desde terminal

#### Sistema E-commerce:

```bash
# Navegar a la carpeta src
cd src

# Compilar
javac ecommerce/SistemaEcommerce.java

# Ejecutar
java ecommerce.SistemaEcommerce
```

#### Ejercicios de Excepciones:

```bash
# Navegar a la carpeta src
cd src

# Compilar
javac excepciones/EjerciciosExcepciones.java

# Ejecutar
java excepciones.EjerciciosExcepciones
```

### Opción 2: Usar VS Code

1. Abrir la carpeta del proyecto en VS Code
2. Instalar la extensión **Extension Pack for Java**
3. Abrir cualquier archivo `.java`
4. Click derecho → **Run Java** o presionar `F5`

### Opción 3: Compilar todo con salida organizada

```bash
# Crear carpeta para archivos compilados
mkdir -p bin

# Compilar todo el proyecto
javac -d bin src/ecommerce/**/*.java src/ecommerce/*.java
javac -d bin src/excepciones/*.java

# Ejecutar
java -cp bin ecommerce.SistemaEcommerce
java -cp bin excepciones.EjerciciosExcepciones
```

---

## 📚 Conceptos Aplicados

### Interfaces

| Concepto | Descripción | Implementación |
|----------|-------------|----------------|
| **Definición de contratos** | Interfaces definen métodos que las clases deben implementar | `Pagable`, `Pago`, `Notificable` |
| **Herencia múltiple** | Una clase puede implementar múltiples interfaces | `PagoConDescuento extends Pago` |
| **Polimorfismo** | Referencias a interfaces para mayor flexibilidad | `PagoConDescuento tarjeta = new TarjetaCredito(...)` |
| **Desacoplamiento** | Código independiente de implementaciones concretas | Sistema de pagos intercambiable |

### Excepciones

| Tipo | Ejemplos | Uso en el Proyecto |
|------|----------|-------------------|
| **Checked** | `IOException`, `FileNotFoundException` | Lectura de archivos |
| **Unchecked** | `ArithmeticException`, `NumberFormatException` | División por cero, conversión de tipos |
| **Personalizadas** | `EdadInvalidaException` | Validación de reglas de negocio |
| **Try-with-resources** | `BufferedReader`, `BufferedWriter` | Cierre automático de recursos |
| **Finally** | Garantiza ejecución de código | Liberación manual de recursos |

---

## 🎬 Ejemplos de Ejecución

### Sistema E-commerce

```
=== SISTEMA DE E-COMMERCE ===

Pedido #1001 [PENDIENTE]
Productos:
  - Notebook Lenovo - $850000.00
  - Mouse Logitech - $25000.00
  - Teclado Mecánico - $45000.00
Total: $920000.00

📧 Notificación para Juan Pérez (juan@email.com):
   Pedido #1001 cambió a estado: EN_PREPARACION

📧 Notificación para Juan Pérez (juan@email.com):
   Pedido #1001 cambió a estado: ENVIADO

💳 Procesando pago con Tarjeta de Crédito
   Titular: Juan Pérez
   Tarjeta: **** **** **** 3456
   ✓ Descuento del 10.0% aplicado (promoción tarjeta)
   Monto: $828000.00
   ✓ Pago aprobado
```

### Ejercicios de Excepciones - Menú

```
╔════════════════════════════════════════════╗
║  EJERCICIOS DE MANEJO DE EXCEPCIONES      ║
╚════════════════════════════════════════════╝

--- MENÚ PRINCIPAL ---
1. División segura
2. Conversión de cadena a número
3. Lectura de archivo (con finally)
4. Validación de edad (excepción personalizada)
5. Lectura de archivo (try-with-resources)
6. Crear archivo de prueba
0. Salir

Seleccione una opción: 
```

---

## 🧪 Casos de Prueba

### División Segura
```java
Entrada: dividendo=10, divisor=2  → Resultado: 5
Entrada: dividendo=10, divisor=0  → Error: No se puede dividir por cero
```

### Validación de Edad
```java
Entrada: edad=25   → ✓ Edad válida: 25 años (Categoría: Adulto)
Entrada: edad=-5   → ❌ Error: La edad no puede ser negativa
Entrada: edad=150  → ❌ Error: La edad no puede ser mayor a 120 años
```

---

## 🎓 Objetivos de Aprendizaje

Este proyecto permite practicar y comprender:

- ✅ Diseño de software usando interfaces
- ✅ Implementación de contratos de comportamiento
- ✅ Polimorfismo y desacoplamiento de código
- ✅ Jerarquía de excepciones en Java
- ✅ Diferencias entre excepciones checked y unchecked
- ✅ Creación de excepciones personalizadas
- ✅ Gestión correcta de recursos con try-with-resources
- ✅ Manejo robusto de errores en aplicaciones

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java 8+
- **Paradigma**: Programación Orientada a Objetos
- **Patrones**: Observer (notificaciones), Strategy (pagos)
- **Control de versiones**: Git & GitHub

---

## 📝 Notas Importantes

### Arquitectura del Sistema E-commerce

El sistema utiliza una arquitectura por capas:

1. **Capa de Interfaces**: Define contratos (`Pagable`, `Pago`, etc.)
2. **Capa de Modelo**: Entidades del dominio (`Producto`, `Pedido`, `Cliente`)
3. **Capa de Implementación**: Lógica específica (`TarjetaCredito`, `PayPal`)
4. **Capa de Aplicación**: Punto de entrada (`SistemaEcommerce.main()`)

### Buenas Prácticas Implementadas

- 📦 **Organización en paquetes** para modularidad
- 🔒 **Encapsulamiento** con atributos privados
- 🔄 **Reutilización** mediante interfaces
- 📋 **Documentación** con comentarios claros
- ⚠️ **Manejo de errores** robusto y descriptivo
- 🧹 **Gestión de recursos** automática (try-with-resources)

---

## 🐛 Solución de Problemas

### Error: "Could not find or load main class"

**Solución**: Asegúrate de estar en la carpeta `src` y usar el nombre completo del paquete:
```bash
cd src
java ecommerce.SistemaEcommerce
```

### Error: "package X does not exist"

**Solución**: Compila todos los archivos necesarios primero:
```bash
javac ecommerce/interfaces/*.java
javac ecommerce/modelo/*.java
javac ecommerce/pagos/*.java
javac ecommerce/SistemaEcommerce.java
```

### Error en lectura de archivos

**Solución**: Usa la opción 6 del menú para crear un archivo de prueba automáticamente.

---


[⬆ Volver arriba](#-tp-8-interfaces-y-excepciones-en-java)

</div>
