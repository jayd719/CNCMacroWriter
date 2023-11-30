package com.CNCMacroWriter;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Main {
    static String appTitle = "CNC MARCO WRITER";

    public static void main(String[] args) {

//	final RTModel model = new RTModel();
//	final OneFrameView view = new OneFrameView(model);
	final OptionsPanel opPanel = new OptionsPanel();
	final Header header = new Header();

	final JFrame f = new JFrame(appTitle);
	f.setResizable(false);
	f.getContentPane().setBackground(new Color(123, 50, 255));
	f.setSize(450, 900);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	f.setLayout(new BorderLayout());
	f.add(opPanel, BorderLayout.CENTER);
	f.add(header, BorderLayout.NORTH);
	f.setVisible(true);
    }

}
