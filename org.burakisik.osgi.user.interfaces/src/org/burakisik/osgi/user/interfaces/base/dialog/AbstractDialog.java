package org.burakisik.osgi.user.interfaces.base.dialog;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.burakisik.osgi.user.interfaces.Services;

public abstract class  AbstractDialog extends JFrame{
	
	
	protected JTextField txtField = new JTextField(); 
	
	public AbstractDialog() {
		init();	
	}
	
	private void init( ) {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout()); 
		txtField = new JTextField(Services.getInstance().getI18n().fetchTextfromResourceBundle("default_dialog_message"));
		txtField.setHorizontalAlignment(JTextField.CENTER);
		txtField.setEditable(false);
		cp.add(txtField, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setTitle("Error Dialog");
		setSize(300, 100); 
		setVisible(true); 
	}	
}
