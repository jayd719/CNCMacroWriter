package com.CNCMacroWriter;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CenterOptionsDisplay extends JPanel {

	public CenterOptionsDisplay() {

		JLabel headingTextOne = new JLabel("Select Macros to Add to Program");

		this.add(headingTextOne);
		this.setSize(400, 500);
		this.setVisible(true);
	}

}
