package com.CNCMacroWriter;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
//    CONSTANTS
    String appTitle = "CNC MARCO WRITER";

    public MainFrame() {
	// TODO
	this.setSize(450, 900);
	this.setTitle(appTitle);
	this.setResizable(false);
	this.getContentPane().setBackground(new Color(123, 50, 255));
	this.setLayout(new BorderLayout());

	JLabel labelOne = new JLabel("Sect");

	JPanel temp = new JPanel();
	JPanel temp2 = new JPanel();
	temp.add(labelOne);
	temp2.add(labelOne);
	temp.setSize(100, 100);
	temp2.setSize(100, 100);

	this.add(new CenterOptionsDisplay(), BorderLayout.CENTER);
	this.add(temp, BorderLayout.SOUTH);
	this.setVisible(true);
	this.add(temp2, BorderLayout.NORTH);
    }

}
