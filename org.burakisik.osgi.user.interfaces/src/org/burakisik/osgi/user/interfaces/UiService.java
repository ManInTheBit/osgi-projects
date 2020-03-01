package org.burakisik.osgi.user.interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface UiService {
	
	public JFrame getMainFrame();

	public JPanel getEmergencyPanel();
	
	public JPanel getGpsPanel();
	
	public JPanel getHeaderPanel();
	
	public JPanel getFooterPanel();
	
	public JPanel getLeftSidePanel();
	
	public JPanel getRightSidePanel();
	
	public JFrame getErrorDialog();
}
