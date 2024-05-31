package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDialog extends JDialog implements DialogWithAdditionalField {
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField mediaField;
    private boolean confirmed;

    public StudentDialog(Frame owner) {
        super(owner, "Inserisci Studente", true);
        setLayout(new GridLayout(4, 2));

        nomeField = new JTextField();
        cognomeField = new JTextField();
        mediaField = new JTextField();

        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Cognome:"));
        add(cognomeField);
        add(new JLabel("Media:"));
        add(mediaField);

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
        return mediaField.getText();
    }

    public String getMedia() {
        return getAdditionalField();
    }
}

