package factory;
import mundo.Camion;
import mundo.VehiculoBase;

public class CamionFactory extends VehiculoFactory {
    @Override
    public VehiculoBase crearVehiculo() {
        return new Camion();
    }
}
