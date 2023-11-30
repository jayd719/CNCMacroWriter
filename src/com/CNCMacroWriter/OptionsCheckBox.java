package com.CNCMacroWriter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OptionsCheckBox extends JCheckBox {

    public OptionsCheckBox(final String title) {
	this.setText(title);
	this.setFont(new Font("Monospace", Font.BOLD, 18));
	this.setForeground(Color.white);
	this.setBorder(new EmptyBorder(0, 5, 5, 5));
    }

}
