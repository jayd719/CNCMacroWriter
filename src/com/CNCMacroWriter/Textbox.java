package com.CNCMacroWriter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Textbox extends JTextField {

	public Textbox(final String title) {
		this.setText(title);
		this.setFont(new Font("Arial", Font.PLAIN, 15));
		this.setOpaque(true);
		this.setBackground(new Color(0, 0, 0, 80));
		this.setCaretColor(Color.white);
		this.setForeground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.white));
		this.setHorizontalAlignment(CENTER);
	}

}
