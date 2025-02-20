package cordi;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActividadDeClase01 extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JButton Bmensaje;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ActividadDeClase01 frame = new ActividadDeClase01();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor
    public ActividadDeClase01() {
        // Configura la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        // Crear el panel y configurar el borde
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Establecer el panel como contenido principal
        setContentPane(panel);

        // Crear el botón y agregar el Listener
        Bmensaje = new JButton("Oprimir");
        Bmensaje.addActionListener(this);
        panel.add(Bmensaje);
    }

    // Implementación del método actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.Bmensaje) {
            JOptionPane.showMessageDialog(this, "Hola");
        }
    }
}

