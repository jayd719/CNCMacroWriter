package com.CNCMacroWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel implements ActionListener {
	private ReadProgramContent model;

	OptionsCheckBox g10Logic;
	G10section g10Section;
	boolean g10 = false;

	OptionsCheckBox statusMacro;
	StatusSection statusMacroSection;
	boolean writeStatusMactos = false;

	public OptionsPanel(final ReadProgramContent mod) {
		this.model = mod;
		this.setSize(425, 900);
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(new EmptyBorder(75, 50, 100, 50));




		

		g10Logic = new OptionsCheckBox("Add G10 Command");
		g10Logic.addActionListener(this);
		g10Section = new G10section(model);

		statusMacro = new OptionsCheckBox("Add Status Macros");
		statusMacro.addActionListener(this);
		statusMacroSection = new StatusSection(model);

		OptionsCheckBox engravingLogic = new OptionsCheckBox("Add Engraving Logic");

		this.add(g10Logic);
		this.add(g10Section);

		this.add(statusMacro);
		this.add(statusMacroSection);

		this.add(engravingLogic);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (g10Logic.isSelected()) {
			g10Section.setVisible(true);
			this.model.setG10Macro(true);

		} else if (!g10Logic.isSelected()) {
			g10Section.setVisible(false);
			this.model.setG10Macro(false);
		}

		if (statusMacro.isSelected()) {
			statusMacroSection.setVisible(true);
			this.model.setStatusMacro(true);
		} else if (!statusMacro.isSelected()) {
			statusMacroSection.setVisible(false);
			this.model.setStatusMacro(false);
		}

	}

	



}
