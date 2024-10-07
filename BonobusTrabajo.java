package Modulo4;

import com.toedter.calendar.JMonthChooser;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BonobusTrabajo extends JFrame {

    //  nombres de meses
    private final String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                                    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public BonobusTrabajo() {
        // Configuración básica de la ventana
        setTitle("Recarga de Abono de Transporte");
        setSize(400, 300);  // Ajustar tamaño para un diseño más espacioso
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear el panel principal con BorderLayout para mejor control del diseño
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20)); // Añadir márgenes

        // Crear el panel superior para el mensaje de instrucción
        JLabel label = new JLabel("Seleccione el mes para recargar su abono:", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Cambiar la fuente y el tamaño
        panelPrincipal.add(label, BorderLayout.NORTH);

        // Crear el panel central con un FlowLayout para centrar los componentes
        JPanel panelCentral = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));

        // Crear el selector de mes (JMonthChooser)
        JMonthChooser monthChooser = new JMonthChooser();
        monthChooser.setPreferredSize(new Dimension(150, 30));  // Ajustar el tamaño del selector
        panelCentral.add(monthChooser);

        // Crear una etiqueta y campo de texto para el importe
        JLabel labelImporte = new JLabel("Importe de la recarga (€):", SwingConstants.CENTER);
        labelImporte.setFont(new Font("Arial", Font.PLAIN, 14));
        panelCentral.add(labelImporte);

        JTextField textFieldImporte = new JTextField(10);  // Añadir un ancho predefinido al campo de texto
        textFieldImporte.setPreferredSize(new Dimension(150, 30));  // Ajustar el tamaño
        panelCentral.add(textFieldImporte);

        // Añadir el panel central al centro del layout principal
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);

        // Crear el botón de recarga
        JButton btnRecargar = new JButton("Recargar Abono");
        btnRecargar.setFont(new Font("Arial", Font.BOLD, 14));  // Cambiar la fuente del botón
        btnRecargar.setBackground(new Color(51, 153, 255));  // Cambiar el color de fondo del botón
        btnRecargar.setForeground(Color.WHITE);  // Cambiar el color del texto del botón
        btnRecargar.setFocusPainted(false);  // Quitar el borde de enfoque del botón
        btnRecargar.setPreferredSize(new Dimension(200, 40));  // Ajustar el tamaño del botón

        // Agregar acción al botón
        btnRecargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el mes seleccionado (0 es enero, 11 es diciembre)
                int mesSeleccionado = monthChooser.getMonth();
                String nombreMes = meses[mesSeleccionado]; // Obtener el nombre en español

                // Obtener el importe ingresado por el usuario
                String importe = textFieldImporte.getText();

                // Validar que el importe no esté vacío o no sea válido
                if (importe.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Por favor, introduzca un importe válido.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return; // Salir si no hay un importe válido
                }

                // Mostrar mensaje de confirmación
                JOptionPane.showMessageDialog(
                        null,
                        "Su abono de transporte ha sido recargado para el mes de: " + nombreMes + 
                        "\nImporte: " + importe + " euros.",
                        "Recarga Exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // Añadir el botón en la parte inferior de la ventana
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnRecargar);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        // Añadir el panel principal a la ventana
        add(panelPrincipal);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BonobusTrabajo().setVisible(true); // Mostrar la ventana
            }
        });
    }
}
