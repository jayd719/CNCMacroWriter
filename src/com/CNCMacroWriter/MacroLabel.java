package com.CNCMacroWriter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MacroLabel extends JLabel {

    public MacroLabel(final String text) {
	this.setText(text);
	this.setFont(new Font("Serif", Font.BOLD, 15));
	this.setForeground(Color.white);
    }

}
