// Definición de la clase Perro
class Perro {
    // Atributos (características del perro)
    String nombre;
    String raza;
    int edad;

    // Constructor de la clase Perro
    public Perro(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    // Método para ladrar
    public void ladrar() {
        System.out.println("¡Guau! ¡Guau!");
    }

    // Método para obtener la información del perro
    public void obtenerInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Edad: " + edad + " años");
    }
}

// Clase principal que contiene el método main para ejecutar el programa
public class Main {
    public static void main(String[] args) {
        // Crear instancias de la clase Perro (objetos)
        Perro perro1 = new Perro("Max", "Labrador", 3);
        Perro perro2 = new Perro("Bella", "Poodle", 2);

        // Acceder a los métodos y atributos de los objetos
        perro1.ladrar();
        perro1.obtenerInformacion();

        System.out.println(); // Línea en blanco para separar la información de los perros

        perro2.ladrar();
        perro2.obtenerInformacion();
    }
}
