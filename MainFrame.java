package ejercicio_unidad1;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        // Configuración básica de la ventana
        setTitle("Aplicación de Texto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los paneles
        TextPanel textPanel = new TextPanel();
        ButtonPanel buttonPanel = new ButtonPanel(textPanel);

        // Agregar los paneles a la ventana
        setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear la ventana principal en el hilo adecuado
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
