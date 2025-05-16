package Vista;

import MODELO.DefinicionAtributo;
import Singleton.AtributosSingleton;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VistaEntidadFormulario extends JFrame {
    private JPanel panelCampos;
    private JButton btnGuardar;
    private JButton btnVerEntidades;
    private Map<String, JComponent> campos;

    public VistaEntidadFormulario() {
        setTitle("Registrar Entidad");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        panelCampos = new JPanel();
        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));
        campos = new HashMap<>();

        List<DefinicionAtributo> atributos = AtributosSingleton.getInstancia().getAtributos();

        for (DefinicionAtributo atributo : atributos) {
            JPanel fila = new JPanel(new BorderLayout());
            JLabel etiqueta = new JLabel(atributo.getNombre() + ": ");
            JTextField campo = new JTextField();
            campos.put(atributo.getNombre(), campo);
            fila.add(etiqueta, BorderLayout.WEST);
            fila.add(campo, BorderLayout.CENTER);
            panelCampos.add(fila);
        }

        btnGuardar = new JButton("Guardar");
        btnVerEntidades = new JButton("Ver Entidades");

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnGuardar);
        panelBoton.add(btnVerEntidades);

        getContentPane().add(panelCampos, BorderLayout.CENTER);
        getContentPane().add(panelBoton, BorderLayout.SOUTH);
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnVerEntidades() {
        return btnVerEntidades;
    }

    public Map<String, String> obtenerValores() {
        Map<String, String> valores = new HashMap<>();
        for (Map.Entry<String, JComponent> entry : campos.entrySet()) {
            String nombre = entry.getKey();
            JTextField campo = (JTextField) entry.getValue();
            valores.put(nombre, campo.getText().trim());
        }
        return valores;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        for (JComponent comp : campos.values()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
        }
    }
}
