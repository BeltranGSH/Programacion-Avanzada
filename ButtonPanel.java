package ejercicio_unidad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton clearButton;
    private TextPanel textPanel;

    public ButtonPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
        setLayout(new FlowLayout());

        // Crear el botón de limpiar
        clearButton = new JButton("Limpiar");
        
        // Acción cuando se presiona el botón
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textPanel.clearText(); // Limpiar el texto
            }
        });

        // Agregar el botón al panel
        add(clearButton);
    }
}
