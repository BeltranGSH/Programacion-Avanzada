package Vista;

import MODELO.Entidad;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VistaEditarEntidad extends JFrame {
    private Map<String, JTextField> camposTexto;
    private JButton btnGuardar;

    public VistaEditarEntidad(Entidad entidad) {
        setTitle("Editar Entidad");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        camposTexto = new HashMap<>();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(entidad.getAtributos().size(), 2, 5, 5));

        for (Map.Entry<String, Object> entry : entidad.getAtributos().entrySet()) {
            String nombre = entry.getKey();
            Object valor = entry.getValue();

            JLabel etiqueta = new JLabel(nombre + ":");
            JTextField campo = new JTextField(String.valueOf(valor));
            camposTexto.put(nombre, campo);

            panel.add(etiqueta);
            panel.add(campo);
        }

        btnGuardar = new JButton("Guardar cambios");

        add(panel, BorderLayout.CENTER);
        add(btnGuardar, BorderLayout.SOUTH);
    }

    public Map<String, String> getValoresEditados() {
        Map<String, String> valores = new HashMap<>();
        for (Map.Entry<String, JTextField> entry : camposTexto.entrySet()) {
            valores.put(entry.getKey(), entry.getValue().getText().trim());
        }
        return valores;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
