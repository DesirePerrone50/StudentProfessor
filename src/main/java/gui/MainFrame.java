package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTable studentTable;
    private JTable professorTable;
    private JButton studentButton;
    private JButton professorButton;
    private JTextArea textArea;

    public MainFrame() {
        setTitle("Student and Professor Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize tables
        String[][] studentData = {{"1", "Mario", "Rossi", "28"}};
        String[] studentColumnNames = {"ID", "Nome", "Cognome", "Media"};
        studentTable = new JTable(studentData, studentColumnNames);

        String[][] professorData = {{"1", "Luca", "Bianchi", "Matematica"}};
        String[] professorColumnNames = {"ID", "Nome", "Cognome", "Materia"};
        professorTable = new JTable(professorData, professorColumnNames);

        // Initialize buttons
        studentButton = new JButton("Studente");
        professorButton = new JButton("Professore");

        // Initialize text area
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Add components to frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(studentButton);
        buttonPanel.add(professorButton);

        add(new JScrollPane(studentTable), BorderLayout.NORTH);
        add(new JScrollPane(professorTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(new JScrollPane(textArea), BorderLayout.EAST);

        // Add action listeners
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPersonDialog(new StudentDialog(MainFrame.this));
            }
        });

        professorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPersonDialog(new ProfessorDialog(MainFrame.this));
            }
        });
    }

    private void showPersonDialog(JDialog dialog) {
        dialog.setVisible(true);
        if (((DialogWithAdditionalField) dialog).isConfirmed()) {
            String nome = ((DialogWithAdditionalField) dialog).getNome();
            String cognome = ((DialogWithAdditionalField) dialog).getCognome();
            String additionalField = ((DialogWithAdditionalField) dialog).getAdditionalField();
            textArea.append(dialog instanceof StudentDialog ?
                    "Studente: " + nome + " " + cognome + ", Media: " + additionalField + "\n" :
                    "Professore: " + nome + " " + cognome + ", Materia: " + additionalField + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
