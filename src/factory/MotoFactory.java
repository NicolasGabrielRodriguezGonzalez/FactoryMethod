package factory;
import mundo.Moto;
import mundo.VehiculoBase;

public class MotoFactory extends VehiculoFactory {
    @Override
    public VehiculoBase crearVehiculo() {
        return new Moto();
    }
}