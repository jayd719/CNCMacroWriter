package com.CNCMacroWriter;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class G10section extends JPanel {

    public G10section() {
	this.setVisible(false);
	this.setLayout(null);
	this.setSize(800, 75);
	this.setMaximumSize(new Dimension(this.getMaximumSize().width, this.getPreferredSize().height));
	this.setOpaque(false);

	Textbox xCords = new Textbox("X Value");
	Textbox yCords = new Textbox("Y Value");
	Textbox zCords = new Textbox("Z Value");

	MacroLabel xLabel = new MacroLabel("X");
	MacroLabel yLabel = new MacroLabel("Y");
	MacroLabel zLabel = new MacroLabel("Z");

	xCords.setBounds(10, 10, 100, 25);
	yCords.setBounds(120, 10, 100, 25);
	zCords.setBounds(230, 10, 100, 25);

	xLabel.setBounds(50, 32, 100, 20);
	yLabel.setBounds(165, 32, 100, 20);
	zLabel.setBounds(275, 32, 100, 20);

	this.add(xCords);
	this.add(yCords);
	this.add(zCords);
	this.add(xLabel);
	this.add(yLabel);
	this.add(zLabel);
    }

}
