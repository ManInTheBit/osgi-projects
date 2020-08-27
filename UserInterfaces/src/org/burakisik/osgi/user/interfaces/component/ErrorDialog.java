package org.burakisik.osgi.user.interfaces.component;

import org.burakisik.osgi.user.interfaces.base.dialog.AbstractDialog;

public class ErrorDialog extends AbstractDialog { 
	
	public ErrorDialog() {
		super();
		txtField.setText("Error message");
	}
}