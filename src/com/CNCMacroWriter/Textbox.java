package com.CNCMacroWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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

	this.addFocusListener(new FocusListener() {
	    @Override
	    public void focusGained(FocusEvent e) {
		if (getText().equals(title)) {
		    setText("");
		}
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
		if (getText().isEmpty()) {
		    setText(title);
		}
	    }
	});

    }

}
