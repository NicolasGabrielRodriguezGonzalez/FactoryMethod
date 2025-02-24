package mundo;

public abstract class VehiculoBase {
    private String nombre;
    private double precioPorDia;

    public VehiculoBase(String nombre, double precioPorDia) {
        this.nombre = nombre;
        this.precioPorDia = precioPorDia;
    }

    public String getNombre() { // 🔹 Agrega este método
        return nombre;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }
    @Override
    public String toString() {
        return getNombre();  // Devuelve el nombre del vehículo en el JComboBox
    }
}
