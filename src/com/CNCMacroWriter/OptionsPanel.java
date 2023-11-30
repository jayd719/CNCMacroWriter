package com.CNCMacroWriter;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel {

    public OptionsPanel() {
	this.setSize(300, 600);
	this.setOpaque(false);
	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	this.setBorder(new EmptyBorder(150, 50, 100, 100));

	OptionsCheckBox statusMacro = new OptionsCheckBox("Add Status Macros");
	OptionsCheckBox engravingLogic = new OptionsCheckBox("Add Engraving Logic");
	OptionsCheckBox engravingLogic1 = new OptionsCheckBox("Add Engraving Logic");
	OptionsCheckBox engravingLogic2 = new OptionsCheckBox("Add Engraving Logic");

	this.add(statusMacro);
	this.add(engravingLogic);
	this.add(engravingLogic1);
	this.add(engravingLogic2);

    }

}
