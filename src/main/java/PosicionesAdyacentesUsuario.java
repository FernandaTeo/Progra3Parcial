import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PosicionesAdyacentesUsuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ejemplo de una matriz 3x3
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Solicitar al usuario ingresar la fila y la columna
        System.out.println("Ingrese la fila:");
        int fila = scanner.nextInt();

        System.out.println("Ingrese la columna:");
        int columna = scanner.nextInt();

        List<Posicion> adyacentes = encontrarPosicionesAdyacentes(matriz, fila, columna);

        System.out.println("Las posiciones adyacentes a la posición (" + fila + ", " + columna + ") son:");
        for (Posicion posicion : adyacentes) {
            System.out.println("(" + posicion.fila + ", " + posicion.columna + ")");
        }

        scanner.close();
    }

    static class Posicion {
        int fila;
        int columna;

        Posicion(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }
    }

    public static List<Posicion> encontrarPosicionesAdyacentes(int[][] matriz, int fila, int columna) {
        List<Posicion> adyacentes = new ArrayList<>();

        // Verificar posición arriba
        if (fila - 1 >= 0) {
            adyacentes.add(new Posicion(fila - 1, columna));
        }

        // Verificar posición abajo
        if (fila + 1 < matriz.length) {
            adyacentes.add(new Posicion(fila + 1, columna));
        }

        // Verificar posición izquierda
        if (columna - 1 >= 0) {
            adyacentes.add(new Posicion(fila, columna - 1));
        }

        // Verificar posición derecha
        if (columna + 1 < matriz[0].length) {
            adyacentes.add(new Posicion(fila, columna + 1));
        }

        return adyacentes;
    }
}
