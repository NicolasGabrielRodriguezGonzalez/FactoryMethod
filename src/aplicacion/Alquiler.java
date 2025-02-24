package aplicacion;

import mundo.VehiculoBase;

public class Alquiler {

    public double calcularPrecio(VehiculoBase vehiculo, int dias) {
        return (vehiculo != null) ? vehiculo.getPrecioPorDia() * dias : 0;
    }
}
