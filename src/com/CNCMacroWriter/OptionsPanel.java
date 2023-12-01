package com.CNCMacroWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel implements ActionListener {
    OptionsCheckBox g10Logic;
    G10section g10Section;
    boolean g10 = false;

    OptionsCheckBox statusMacro;
    StatusSection statusMacroSection;

    public OptionsPanel() {
	this.setSize(425, 900);
	this.setOpaque(false);
	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	this.setBorder(new EmptyBorder(75, 50, 100, 50));

	g10Logic = new OptionsCheckBox("Add G10 Command");
	g10Logic.addActionListener(this);
	g10Section = new G10section();

	statusMacro = new OptionsCheckBox("Add Status Macros");
	statusMacro.addActionListener(this);
	statusMacroSection = new StatusSection();

	OptionsCheckBox engravingLogic = new OptionsCheckBox("Add Engraving Logic");

	OptionsCheckBox engravingLogic2 = new OptionsCheckBox("Add Engraving Logic");

	this.add(g10Logic);
	this.add(g10Section);

	this.add(statusMacro);
	this.add(statusMacroSection);

	this.add(engravingLogic);
	this.add(engravingLogic2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (g10Logic.isSelected()) {
	    g10Section.setVisible(true);
	    g10 = true;

	} else if (!g10Logic.isSelected()) {
	    g10Section.setVisible(false);
	    g10 = false;
	}

	if (statusMacro.isSelected()) {
	    statusMacroSection.setVisible(true);
	} else if (!statusMacro.isSelected()) {
	    statusMacroSection.setVisible(false);
	}

    }

}
