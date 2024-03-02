import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    // Constructor para crear un nodo con un valor dado
    ListNode(int val) {
        this.val = val;
    }
}

public class OrdenarListaEnlazada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario ingresar la lista enlazada separada por espacios
        System.out.println("Ingrese la lista enlazada separada por espacios (por ejemplo, 4 2 1 3):");
        String input = scanner.nextLine();

        // Crear la lista enlazada a partir de la entrada del usuario
        ListNode cabeza = crearListaEnlazada(input);

        // Imprimir la lista original
        System.out.println("Lista original:");
        imprimirLista(cabeza);

        // Ordenar la lista enlazada
        ListNode listaOrdenada = ordenarListaEnlazada(cabeza);

        // Imprimir la lista ordenada
        System.out.println("Lista ordenada:");
        imprimirLista(listaOrdenada);

        scanner.close();
    }

    // Método para crear una lista enlazada a partir de una cadena de entrada
    private static ListNode crearListaEnlazada(String input) {
        String[] valores = input.split(" ");
        ListNode cabezaFalsa = new ListNode(0);  // Usamos un nodo falso para facilitar la construcción
        ListNode actual = cabezaFalsa;

        for (String valor : valores) {
            int valorEntero = Integer.parseInt(valor);
            actual.next = new ListNode(valorEntero);
            actual = actual.next;
        }

        return cabezaFalsa.next;  // Devolvemos el siguiente del nodo falso, que es el comienzo real de la lista
    }

    // Método para ordenar una lista enlazada utilizando el algoritmo de fusión
    private static ListNode ordenarListaEnlazada(ListNode cabeza) {
        if (cabeza == null || cabeza.next == null) {
            return cabeza;
        }

        // Encontrar el nodo del medio y dividir la lista en dos
        ListNode mitad = encontrarMitad(cabeza);
        ListNode segundaMitad = mitad.next;
        mitad.next = null;

        // Ordenar ambas mitades de forma recursiva
        ListNode primeraMitadOrdenada = ordenarListaEnlazada(cabeza);
        ListNode segundaMitadOrdenada = ordenarListaEnlazada(segundaMitad);

        // Combinar las dos listas ordenadas
        return combinarListasOrdenadas(primeraMitadOrdenada, segundaMitadOrdenada);
    }

    // Método para encontrar el nodo del medio de una lista enlazada
    private static ListNode encontrarMitad(ListNode cabeza) {
        if (cabeza == null) {
            return null;
        }

        ListNode lento = cabeza;
        ListNode rapido = cabeza;

        while (rapido.next != null && rapido.next.next != null) {
            lento = lento.next;
            rapido = rapido.next.next;
        }

        return lento;
    }

    // Método para combinar dos listas enlazadas ordenadas
    private static ListNode combinarListasOrdenadas(ListNode lista1, ListNode lista2) {
        ListNode cabezaFalsa = new ListNode(0);
        ListNode actual = cabezaFalsa;

        while (lista1 != null && lista2 != null) {
            if (lista1.val < lista2.val) {
                actual.next = lista1;
                lista1 = lista1.next;
            } else {
                actual.next = lista2;
                lista2 = lista2.next;
            }
            actual = actual.next;
        }

        if (lista1 != null) {
            actual.next = lista1;
        } else {
            actual.next = lista2;
        }

        return cabezaFalsa.next;
    }

    // Método para imprimir una lista enlazada
    private static void imprimirLista(ListNode cabeza) {
        ListNode actual = cabeza;
        while (actual != null) {
            System.out.print(actual.val + " ");
            actual = actual.next;
        }
        System.out.println();
    }
}
