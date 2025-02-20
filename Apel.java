package ejercicio_unidad1;

import javax.swing.JFrame;

public class Apel {
    public static void main(String[] args) {
        // Ejecutar en el hilo de la interfaz gráfica
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearVentana();
            }
        });
    }

    public static void crearVentana() {
        JFrame frame = new JFrame("Hola Mundo");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
