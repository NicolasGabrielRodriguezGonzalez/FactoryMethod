package factory;
import mundo.Avion;
import mundo.VehiculoBase;

public class AvionFactory extends VehiculoFactory {
    @Override
    public VehiculoBase crearVehiculo() {
        return new Avion();
    }
}
