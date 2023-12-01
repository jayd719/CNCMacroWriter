package com.CNCMacroWriter;

import java.awt.Dimension;

import javax.swing.JPanel;

public class StatusSection extends JPanel {

    public StatusSection() {
	this.setVisible(false);
	this.setLayout(null);
	this.setSize(600, 125);
	this.setOpaque(false);
	this.setMaximumSize(new Dimension(this.getMaximumSize().width, this.getPreferredSize().height));

	// this.setMaximumSize(new Dimension(this.getMaximumSize().width,
	// this.getPreferredSize().height));

	MacroLabel labelWorkOrder = new MacroLabel("Work Order");
	MacroLabel labelprogrammer = new MacroLabel("Programmer");
	MacroLabel labelOperationNumber = new MacroLabel("Op#");

	Textbox textBoxWorkOrder = new Textbox("Work Order");
	Textbox textBoxProgrammer = new Textbox("Programmer");
	Textbox textboxOp = new Textbox("Op #");

	labelWorkOrder.setBounds(50, 10, 100, 25);
	textBoxWorkOrder.setBounds(150, 10, 200, 25);

	labelprogrammer.setBounds(50, 40, 100, 25);
	textBoxProgrammer.setBounds(150, 40, 200, 25);

	labelOperationNumber.setBounds(50, 70, 200, 25);
	textboxOp.setBounds(150, 70, 200, 25);

	this.add(labelWorkOrder);
	this.add(textBoxWorkOrder);
	this.add(labelprogrammer);
	this.add(textBoxProgrammer);
	this.add(labelOperationNumber);
	this.add(textboxOp);

    }

}
