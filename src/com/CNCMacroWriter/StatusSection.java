package com.CNCMacroWriter;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StatusSection extends JPanel {
	ReadProgramContent model = null;

	public StatusSection(ReadProgramContent model) {
		this.model = model;
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

		textBoxWorkOrder.addFocusListener(new workOrderListener());
		textBoxProgrammer.addFocusListener(new ProgrammercordListener());
		textboxOp.addFocusListener(new operationNumberListener());

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

	private class ProgrammercordListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			field.getHighlighter();

		}

		@Override
		public void focusLost(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			model.setProgramer(field.getText());
		}
	}

	private class workOrderListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			field.getHighlighter();

		}

		@Override
		public void focusLost(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			model.setWorkOrder(field.getText());
		}
	}

	private class operationNumberListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			field.getHighlighter();

		}

		@Override
		public void focusLost(FocusEvent e) {
			JTextField field = (JTextField) e.getSource();
			model.setOperationNumber(field.getText());
		}
	}

}
