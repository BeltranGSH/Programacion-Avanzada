package cordi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Persona {
    protected String nombre;
    protected int id;

    public Persona(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
}

class Alumno extends Persona {
    private ArrayList<Materia> materias = new ArrayList<>();

    public Alumno(String nombre, int id) {
        super(nombre, id);
    }

    public void inscribirMateria(Materia materia) {
        materias.add(materia);
    }
}

class Maestro extends Persona {
    private Materia materiaAsignada;

    public Maestro(String nombre, int id) {
        super(nombre, id);
    }

    public void asignarMateria(Materia materia) {
        this.materiaAsignada = materia;
    }
}

class Materia {
    private String nombre;
    private String codigo;

    public Materia(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    
}

public class Crudbase extends JFrame {
    
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private ArrayList<Maestro> maestros = new ArrayList<>();
    private ArrayList<Materia> materias = new ArrayList<>();

    public Crudbase() {
        setTitle("Sistema Escolar");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel headerPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        headerPanel.add(createHeaderLabel("Flamme"));
        headerPanel.add(createHeaderLabel("Joorstwalder"));
        headerPanel.add(createHeaderLabel("Cru"));

        JPanel centerPanel = new JPanel(new GridLayout(4, 2, 10, 15));
        String[] campos = {"On81", "Cgu.", "On67", "Cmu.", "On83", "C", "On37", "Ov5"};
        for(String campo : campos) {
            centerPanel.add(createInputField(campo));
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        String[] botones = {"getTight", "getModelg", "getModelo", "SetHabla"};
        for(String boton : botones) {
            buttonPanel.add(createActionButton(boton));
        }

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JLabel createHeaderLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        label.setFont(new Font("Arial", Font.BOLD, 16));
        return label;
    }

    private JPanel createInputField(String labelText) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField(20);
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    private JButton createActionButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 40));
        button.addActionListener(e -> handleButtonAction(text));
        return button;
    }

    private void handleButtonAction(String action) {
        switch(action) {
            case "getTight":
                crearNuevaEntidad();
                break;
            case "getModelg":
                generarReporte();
                break;
            case "getModelo":
                mostrarModelos();
                break;
            case "SetHabla":
                configurarIdioma();
                break;
        }
    }

    private void configurarIdioma() {
    	String[] idiomas = {"Español", "Inglés", "Francés"};
        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el idioma:",
                "Configurar Idioma",
                JOptionPane.PLAIN_MESSAGE,
                null,
                idiomas,
                idiomas[0]);

        if(seleccion != null) {
            JOptionPane.showMessageDialog(this, "Idioma configurado a: " + seleccion, "Idioma", JOptionPane.INFORMATION_MESSAGE);
        }
	}

	private void mostrarModelos() {
		StringBuilder modelos = new StringBuilder();
	    modelos.append("=== Alumnos ===\n");
	    for (Alumno alumno : alumnos) {
	        modelos.append("Nombre: ").append(alumno.nombre).append(", ID: ").append(alumno.id).append("\n");
	    }

	    modelos.append("\n=== Maestros ===\n");
	    for (Maestro maestro : maestros) {
	        modelos.append("Nombre: ").append(maestro.nombre).append(", ID: ").append(maestro.id).append("\n");
	    }

	    modelos.append("\n=== Materias ===\n");
	    for (Materia materia : materias) {
	        modelos.append("Nombre: ").append(materia.getNombre()).append(", Código: ").append(materia.getCodigo()).append("\n");
	    }

	    JOptionPane.showMessageDialog(this, modelos.toString(), "Modelos Registrados", JOptionPane.INFORMATION_MESSAGE);
	}

	private void crearNuevaEntidad() {
        String[] opciones = {"Alumno", "Maestro", "Materia"};
        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el tipo de entidad:",
                "Crear Nueva Entidad",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if(seleccion != null) {
            switch(seleccion) {
                case "Alumno":
                    crearAlumno();
                    break;
                case "Maestro":
                    crearMaestro();
                    break;
                case "Materia":
                    crearMateria();
                    break;
            }
        }
    }

    private void crearMateria() {
    	JTextField nombreField = new JTextField();
        JTextField codigoField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Código:"));
        panel.add(codigoField);

        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Nueva Materia",
                JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.OK_OPTION) {
            materias.add(new Materia(nombreField.getText(), codigoField.getText()));
        }
	}

	private void crearMaestro() {
		JTextField nombreField = new JTextField();
	    JTextField idField = new JTextField();

	    JPanel panel = new JPanel(new GridLayout(2, 2));
	    panel.add(new JLabel("Nombre:"));
	    panel.add(nombreField);
	    panel.add(new JLabel("ID:"));
	    panel.add(idField);

	    int result = JOptionPane.showConfirmDialog(
	            this,
	            panel,
	            "Nuevo Maestro",
	            JOptionPane.OK_CANCEL_OPTION);

	    if(result == JOptionPane.OK_OPTION) {
	        maestros.add(new Maestro(nombreField.getText(), Integer.parseInt(idField.getText())));
	    }
		
	}

	private void crearAlumno() {
        JTextField nombreField = new JTextField();
        JTextField idField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Nuevo Alumno",
                JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.OK_OPTION) {
            alumnos.add(new Alumno(nombreField.getText(), Integer.parseInt(idField.getText())));
        }
    }

    private void generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== Sistema Escolar ===\n");
        reporte.append("Alumnos: ").append(alumnos.size()).append("\n");
        reporte.append("Maestros: ").append(maestros.size()).append("\n");
        reporte.append("Materias: ").append(materias.size()).append("\n");
        
        JOptionPane.showMessageDialog(this, reporte.toString(), "Reporte General", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Crudbase().setVisible(true);
        });
    }
}
