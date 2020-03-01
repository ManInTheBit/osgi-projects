package org.burakisik.osgi.user.interfaces.component;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.burakisik.osgi.user.interfaces.InternationalizingManager;
import org.burakisik.osgi.user.interfaces.base.dialog.AbstractDialog;

public class ErrorDialog extends AbstractDialog { 
	
	public ErrorDialog() {
		super();
		txtField.setText("Error message");
	}
}