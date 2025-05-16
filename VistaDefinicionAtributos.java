package Vista;

import MODELO.DefinicionAtributo;
import MODELO.DefinicionAtributo.TipoDato;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaDefinicionAtributos extends JFrame {
    private JTextField txtNombreAtributo;
    private JComboBox<TipoDato> comboTipoDato;
    private JButton btnAgregar;
    private DefaultListModel<DefinicionAtributo> modeloLista;
    private JList<DefinicionAtributo> listaAtributos;
    private JButton btnContinuar;

    public VistaDefinicionAtributos() {
        setTitle("Definir Atributos");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));

        txtNombreAtributo = new JTextField();
        comboTipoDato = new JComboBox<>(TipoDato.values());
        btnAgregar = new JButton("Agregar Atributo");

        panelFormulario.add(new JLabel("Nombre del Atributo:"));
        panelFormulario.add(txtNombreAtributo);
        panelFormulario.add(new JLabel("Tipo de Dato:"));
        panelFormulario.add(comboTipoDato);
        panelFormulario.add(new JLabel());
        panelFormulario.add(btnAgregar);

        modeloLista = new DefaultListModel<>();
        listaAtributos = new JList<>(modeloLista);
        listaAtributos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        btnContinuar = new JButton("Continuar");

        panel.add(panelFormulario, BorderLayout.NORTH);
        panel.add(new JScrollPane(listaAtributos), BorderLayout.CENTER);
        panel.add(btnContinuar, BorderLayout.SOUTH);

        add(panel);
    }

    public String getNombreAtributo() {
        return txtNombreAtributo.getText().trim();
    }

    public TipoDato getTipoDatoSeleccionado() {
        return (TipoDato) comboTipoDato.getSelectedItem();
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnContinuar() {
        return btnContinuar;
    }

    public void agregarAtributoLista(DefinicionAtributo atributo) {
        modeloLista.addElement(atributo);
    }

    public List<DefinicionAtributo> getAtributosDefinidos() {
        List<DefinicionAtributo> atributos = new ArrayList<>();
        for (int i = 0; i < modeloLista.size(); i++) {
            atributos.add(modeloLista.get(i));
        }
        return atributos;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtNombreAtributo.setText("");
        comboTipoDato.setSelectedIndex(0);
    }
}
