package FLASHCARDS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlashcardsApp {
    private JFrame frame;
    private JPanel panel;
    private JLabel preguntaLabel;
    private JTextArea respuestaTextArea;
    private JButton mostrarRespuestaButton;
    private JButton siguienteButton;
    
    private ArrayList<String[]> flashcards;
    private int indiceActual = 0;
    
    public FlashcardsApp() {
        frame = new JFrame("Tarjetas de Memoria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        preguntaLabel = new JLabel("Pregunta:");
        respuestaTextArea = new JTextArea(5, 20);
        respuestaTextArea.setEditable(false);
        
        mostrarRespuestaButton = new JButton("Mostrar Respuesta");
        siguienteButton = new JButton("Siguiente");
        
        mostrarRespuestaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respuestaTextArea.setText(flashcards.get(indiceActual)[1]);
            }
        });
        
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indiceActual = (indiceActual + 1) % flashcards.size();
                actualizarTarjeta();
            }
        });
        
        JPanel botonesPanel = new JPanel();
        botonesPanel.add(mostrarRespuestaButton);
        botonesPanel.add(siguienteButton);
        
        panel.add(preguntaLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(respuestaTextArea), BorderLayout.CENTER);
        panel.add(botonesPanel, BorderLayout.SOUTH);
        
        frame.add(panel);
        
        cargarFlashcards();
        actualizarTarjeta();
        
        frame.setVisible(true);
    }
    
    private void cargarFlashcards() {
        flashcards = new ArrayList<>();
        flashcards.add(new String[]{"¿Cuál es la capital de Francia?", "París"});
        flashcards.add(new String[]{"¿Cuántos planetas hay en el sistema solar?", "Ocho"});
        flashcards.add(new String[]{"¿Quién escribió 'Don Quijote'?", "Miguel de Cervantes"});
    }
    
    private void actualizarTarjeta() {
        preguntaLabel.setText("Pregunta: " + flashcards.get(indiceActual)[0]);
        respuestaTextArea.setText("");
    }
    
    public static void main(String[] args) {
        new FlashcardsApp();
    }
}