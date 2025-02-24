package aplicacion;

/*
 * Main de la aplicación
 * @author (Tu Nombre)
 */

import interfaz.VentanaPrincipal;

public class Aplicacion {
	private VentanaPrincipal miVentanaPrincipal;
    public static void main(String[] args) {
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
        
        miVentanaPrincipal.setLocationRelativeTo(null);
        miVentanaPrincipal.setVisible(true);
    }
}