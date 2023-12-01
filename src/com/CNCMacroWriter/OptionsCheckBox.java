package com.CNCMacroWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OptionsCheckBox extends JCheckBox {

    public OptionsCheckBox(final String title) {
	this.setText(title);
	this.setFont(new Font("Monospace", Font.BOLD, 18));
	this.setForeground(Color.white);
	this.setBorder(new EmptyBorder(0, 5, 5, 5));
	this.setOpaque(false); // Make the checkbox transparent
	this.setBorderPainted(false); // Remove the default border
	this.setFocusPainted(false); // Remove focus border for a cleaner look
	this.setContentAreaFilled(false);

	Icon selectedIcon = new ImageIcon(
		new ImageIcon("check-mark.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));

	Icon unSelectedIcon = new ImageIcon(
		new ImageIcon("check.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
	this.setIcon(unSelectedIcon);
	this.setIconTextGap(15);

	// Add a listener to change the icon when clicked
	this.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (isSelected()) {
		    setIcon(selectedIcon);
		} else {
		    setIcon(unSelectedIcon);
		}
	    }
	});

    }

}
