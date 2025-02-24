package factory;
import mundo.VehiculoBase;
import mundo.Carro;
public class CarroFactory extends VehiculoFactory{

	@Override
	public VehiculoBase crearVehiculo() {
		// TODO Auto-generated method stub
		return  new Carro();
	}
	

}
