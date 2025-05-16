package Vista;

import MODELO.Entidad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class VistaTablaEntidades extends JFrame {
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JButton btnEliminar;
    private JButton btnEditar;

    public VistaTablaEntidades(List<Entidad> entidades) {
        setTitle("Lista de Entidades Guardadas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        inicializarComponentes(entidades);
    }

    private void inicializarComponentes(List<Entidad> entidades) {
        if (entidades == null || entidades.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay entidades registradas.");
            dispose();
            return;
        }

        Entidad primera = entidades.get(0);
        String[] columnas = primera.getAtributos().keySet().toArray(new String[0]);
        modeloTabla = new DefaultTableModel(columnas, 0);

        for (Entidad e : entidades) {
            Object[] fila = new Object[columnas.length];
            Map<String, Object> atributos = e.getAtributos();
            for (int i = 0; i < columnas.length; i++) {
                fila[i] = atributos.get(columnas[i]);
            }
            modeloTabla.addRow(fila);
        }

        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        btnEliminar = new JButton("Eliminar entidad seleccionada");
        btnEditar = new JButton("Editar entidad seleccionada");

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnEditar);
        panelBoton.add(btnEliminar);
        add(panelBoton, BorderLayout.SOUTH);
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
