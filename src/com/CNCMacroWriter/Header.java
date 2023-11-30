package com.CNCMacroWriter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Header extends JPanel {

    public Header() {
	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	this.setOpaque(false);

	this.setBorder(new EmptyBorder(25, 20, 10, 20));

	ImageIcon headerIcon = new ImageIcon(
		new ImageIcon("image.png").getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));

	JLabel headerText = new JLabel(" " + Main.appTitle);

	headerText.setFont(new Font("Serif", Font.BOLD, 25));
	headerText.setForeground(Color.white);
	headerText.setSize(100, 100);
	headerText.setIcon(headerIcon);

	this.add(headerText);
    }

}
