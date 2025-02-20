package ejercicio_unidad1;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JTextArea textArea;

    public TextPanel() {
        // Configurar el layout del panel
        setLayout(new BorderLayout());

        // Crear un JTextArea
        textArea = new JTextArea();
        textArea.setEditable(true);

        // Agregar el JTextArea al panel en el centro
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    // Método para obtener el texto
    public String getText() {
        return textArea.getText();
    }

    // Método para limpiar el área de texto
    public void clearText() {
        textArea.setText("");
    }
}

