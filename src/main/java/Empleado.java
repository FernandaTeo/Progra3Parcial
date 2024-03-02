// Clase que viola el SRP al tener múltiples responsabilidades
class Empleado {
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    // Método para calcular el impuesto sobre el salario
    public double calcularImpuesto() {
        return salario * 0.2; // Supongamos un impuesto fijo del 20%
    }

    // Método para generar un informe sobre el empleado
    public String generarInforme() {
        return "Informe del empleado: " + nombre + ", Salario: " + salario;
    }
}



















