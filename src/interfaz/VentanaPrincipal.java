package interfaz;

import factory.*;
import mundo.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private JComboBox<VehiculoBase> comboVehiculos;
    private JLabel lblPrecio;
    private JTextField txtNombre, txtDocumento, txtTelefono, txtEmail, txtDias;
    private JLabel lblTotal;
    private List<VehiculoBase> vehiculos;

    public VentanaPrincipal() {
        setTitle("Alquiler de Vehículos");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Contenedor principal con BorderLayout
        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Cargar imagen y colocarla en un JLabel a la izquierda
        JLabel lblImagen = new JLabel();
        try {
            ImageIcon imagen = new ImageIcon(new URL("https://lh3.googleusercontent.com/M2JpI19gXK6S9l0e-vVoXS-PUV8wf5EmlVnHRe2khFrVmnADOoE1p36trYNojTsG-_cWy5eupdJfMtwO3JINNEA=w1280"));
            lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH))); // Aumentar ancho
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panelImagen = new JPanel();
        panelImagen.add(lblImagen);
        contentPane.add(panelImagen, BorderLayout.WEST); // Imagen a la izquierda

        // Instanciar vehículos usando el patrón Factory
        vehiculos = new ArrayList<>();
        vehiculos.add(new Carro());
        vehiculos.add(new Moto());
        vehiculos.add(new Camion());
        vehiculos.add(new Avion());

        // Panel de Datos Personales
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos Personales"));

        panelDatos.add(crearLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);

        panelDatos.add(crearLabel("Documento:"));
        txtDocumento = new JTextField();
        panelDatos.add(txtDocumento);

        panelDatos.add(crearLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelDatos.add(txtTelefono);

        panelDatos.add(crearLabel("Email:"));
        txtEmail = new JTextField();
        panelDatos.add(txtEmail);

        // Panel de Selección de Vehículo
        JPanel panelVehiculo = new JPanel(new GridLayout(4, 2, 5, 5));
        panelVehiculo.setBorder(BorderFactory.createTitledBorder("Selección de Vehículo"));

        comboVehiculos = new JComboBox<>(vehiculos.toArray(new VehiculoBase[0]));
        lblPrecio = crearLabel("Precio por día: $0.0");
        txtDias = new JTextField();
        JButton btnCalcular = new JButton("Calcular Precio");

        // Estilo del botón
        btnCalcular.setBackground(new Color(0, 150, 255));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.addActionListener(e -> calcularTotal());

        // Label Total
        lblTotal = crearLabel("Total: $0.0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);

        // Añadir los componentes
        panelVehiculo.add(crearLabel("Vehículo:"));
        panelVehiculo.add(comboVehiculos);
        panelVehiculo.add(crearLabel("Precio por día:"));
        panelVehiculo.add(lblPrecio);
        panelVehiculo.add(crearLabel("Días de alquiler:"));
        panelVehiculo.add(txtDias);
        panelVehiculo.add(btnCalcular);
        panelVehiculo.add(lblTotal);

        // Actualizar precio al cambiar de vehículo
        actualizarPrecio();
        comboVehiculos.addActionListener(e -> actualizarPrecio());

        // Agregar paneles a la ventana
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.add(panelDatos);
        panelContenido.add(panelVehiculo);

        contentPane.add(panelContenido, BorderLayout.CENTER);
    }

    private void actualizarPrecio() {
        VehiculoBase vehiculoSeleccionado = (VehiculoBase) comboVehiculos.getSelectedItem();
        if (vehiculoSeleccionado != null) {
            lblPrecio.setText("Precio por día: $" + vehiculoSeleccionado.getPrecioPorDia());
        }
    }

    private void calcularTotal() {
        try {
            int dias = Integer.parseInt(txtDias.getText());
            VehiculoBase vehiculoSeleccionado = (VehiculoBase) comboVehiculos.getSelectedItem();
            if (vehiculoSeleccionado != null) {
                double total = dias * vehiculoSeleccionado.getPrecioPorDia();
                lblTotal.setText("Total: $" + total);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido de días.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JLabel crearLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}