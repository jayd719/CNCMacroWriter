package com.CNCMacroWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class BottomSection extends JPanel implements ActionListener {
    JButton selectSource;
    JButton macroMize;
    final JFileChooser fileSelector = new JFileChooser();
    ReadProgramContent model= null;


    public BottomSection(final ReadProgramContent model) {
        this.model = model;
        selectSource = new JButton("MacroMize");
        selectSource.addActionListener(this);

        this.setOpaque(false);
        this.add(selectSource);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectSource) {
            int selected = fileSelector.showOpenDialog(fileSelector);
            if (selected == JFileChooser.APPROVE_OPTION) {
                String selectedFile = fileSelector.getSelectedFile().getPath();
                this.model.getContent(selectedFile);

            }
        }
    }

}
