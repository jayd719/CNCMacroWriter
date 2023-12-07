package com.CNCMacroWriter;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class G10section extends JPanel {
	Textbox xCords;
	Textbox yCords;
	Textbox zCords;

	ReadProgramContent model = null;

	public G10section(ReadProgramContent model) {
		this.model = model;
		this.setVisible(false);
		this.setLayout(null);
		this.setSize(800, 75);
		this.setMaximumSize(new Dimension(this.getMaximumSize().width, this.getPreferredSize().height));
		this.setOpaque(false);

		xCords = new Textbox("X Value");
		yCords = new Textbox("Y Value");
		zCords = new Textbox("Z Value");

		xCords.addFocusListener(new XcordListener());
		yCords.addFocusListener(new YcordListener());
		zCords.addFocusListener(new ZcordListener());

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

	private class XcordListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			field.getHighlighter();

		}

		@Override
		public void focusLost(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			model.setXCord(field.getText());
			System.out.println(field.getText());
		}
	}

	private class YcordListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			field.getHighlighter();

		}

		@Override
		public void focusLost(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			model.setYCord(field.getText());
			System.out.println(field.getText());
		}
	}

	private class ZcordListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			field.getHighlighter();

		}

		@Override
		public void focusLost(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			model.setZCord(field.getText());
			System.out.println(field.getText());
		}
	}

}
