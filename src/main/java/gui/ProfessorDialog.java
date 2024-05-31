package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorDialog extends JDialog implements DialogWithAdditionalField {
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField materiaField;
    private boolean confirmed;

    public ProfessorDialog(Frame owner) {
        super(owner, "Inserisci Professore", true);
        setLayout(new GridLayout(4, 2));

        nomeField = new JTextField();
        cognomeField = new JTextField();
        materiaField = new JTextField();

        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Cognome:"));
        add(cognomeField);
        add(new JLabel("Materia:"));
        add(materiaField);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = true;
                setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = false;
                setVisible(false);
            }
        });

        add(okButton);
        add(cancelButton);

        pack();
        setLocationRelativeTo(owner);
    }

    @Override
    public boolean isConfirmed() {
        return confirmed;
    }

    @Override
    public String getNome() {
        return nomeField.getText();
    }

    @Override
    public String getCognome() {
        return cognomeField.getText();
    }

    @Override
    public String getAdditionalField() {
        return materiaField.getText();
    }

    public String getMateria() {
        return getAdditionalField();
    }
}

