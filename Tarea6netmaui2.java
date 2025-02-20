package cordi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tarea6netmaui2 {
    public static void main(String[] args) {
        // Crear la ventana principal (JFrame)
        JFrame frame = new JFrame("Calculadora de Propinas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        
        // Usar un BoxLayout para organizar los elementos en vertical
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Crear paneles y configurar el layout para cada uno
        JPanel billPanel = createBillPanel();
        JPanel tipPanel = createTipPanel();
        JPanel totalPanel = createTotalPanel();
        JPanel tipPercentagePanel = createTipPercentagePanel();
        JPanel buttonsPanel1 = createButtonsPanel("15%", "20%");
        JPanel buttonsPanel2 = createButtonsPanel("Round Down", "Round Up");
        
        // Añadir los paneles a la ventana principal
        frame.add(billPanel);
        frame.add(tipPanel);
        frame.add(totalPanel);
        frame.add(tipPercentagePanel);
        frame.add(buttonsPanel1);
        frame.add(buttonsPanel2);
        
        // Hacer visible la ventana
        frame.setVisible(true);
    }

    // Panel para la entrada de la factura
    private static JPanel createBillPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Alineación horizontal (de izquierda a derecha)
        
        JLabel label = new JLabel("Bill: ");
        JTextField billInput = new JTextField(10);
        panel.add(label);
        panel.add(billInput);
        return panel;
    }

    // Panel para el monto de la propina
    private static JPanel createTipPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Alineación horizontal
        
        JLabel label = new JLabel("Tip: ");
        JLabel tipOutput = new JLabel("0.00");
        panel.add(label);
        panel.add(tipOutput);
        return panel;
    }

    // Panel para el total
    private static JPanel createTotalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Alineación horizontal
        
        JLabel label = new JLabel("Total: ");
        JLabel totalOutput = new JLabel("0.00");
        panel.add(label);
        panel.add(totalOutput);
        return panel;
    }

    // Panel para el porcentaje de propina
    private static JPanel createTipPercentagePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Alineación horizontal
        
        JLabel label = new JLabel("Tip Percentage: ");
        JLabel tipPercent = new JLabel("15%");
        panel.add(label);
        panel.add(tipPercent);
        
        JSlider slider = new JSlider(0, 100, 15);
        panel.add(slider);
        
        return panel;
    }

    // Panel para los botones
    private static JPanel createButtonsPanel(String button1Text, String button2Text) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20)); // Alineación horizontal con espaciado

        JButton button1 = new JButton(button1Text);
        JButton button2 = new JButton(button2Text);
        panel.add(button1);
        panel.add(button2);

        // Establecer las propiedades de los botones
        button1.setPreferredSize(new Dimension(150, 40));
        button2.setPreferredSize(new Dimension(150, 40));

        return panel;
    }
}

