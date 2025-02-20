package cordi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tarea6netmaui {
    public static void main(String[] args) {
        // Crear la ventana principal (JFrame)
        JFrame frame = new JFrame("Exploración de Opciones de Alineación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Crear un JPanel con un layout específico para contener la etiqueta
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());  // Usamos FlowLayout para controlar la alineación

        // Crear una etiqueta (JLabel)
        JLabel label = new JLabel("Texto de prueba");
        label.setPreferredSize(new Dimension(200, 30));  // Definir un tamaño para la etiqueta
        panel.add(label);  // Añadir la etiqueta al panel

        // Crear botones para cambiar la alineación
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnStart = new JButton("Start");
        JButton btnCenter = new JButton("Center");
        JButton btnEnd = new JButton("End");
        JButton btnFill = new JButton("Fill");

        // Añadir los botones al panel
        buttonPanel.add(btnStart);
        buttonPanel.add(btnCenter);
        buttonPanel.add(btnEnd);
        buttonPanel.add(btnFill);

        // Añadir los paneles a la ventana principal
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Acciones para cambiar la alineación
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setLayout(new FlowLayout(FlowLayout.LEFT));  // Alineación Start
                panel.revalidate();
                panel.repaint();
            }
        });

        btnCenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Alineación Center
                panel.revalidate();
                panel.repaint();
            }
        });

        btnEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setLayout(new FlowLayout(FlowLayout.RIGHT));  // Alineación End
                panel.revalidate();
                panel.repaint();
            }
        });

        btnFill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setLayout(new FlowLayout(FlowLayout.LEADING));  // Alineación Fill
                panel.revalidate();
                panel.repaint();
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
