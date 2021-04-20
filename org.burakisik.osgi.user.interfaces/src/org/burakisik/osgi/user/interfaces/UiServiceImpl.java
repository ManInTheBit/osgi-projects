package org.burakisik.osgi.user.interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.burakisik.osgi.common.service.ui.UiService;
import org.burakisik.osgi.user.interfaces.component.ErrorDialog;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(service = UiService.class, immediate = true)
public class UiServiceImpl implements UiService{
	
	private JFrame mainFrame;
	
	@Activate
	protected void activate() {
		this.mainFrame = new MyFrame();
	}

	@Override
	public JPanel getEmergencyPanel() {
		return null;
	}

	@Override
	public JPanel getGpsPanel() {
		return null;
	}

	@Override
	public JPanel getHeaderPanel() {
		return null;
	}

	@Override
	public JPanel getFooterPanel() {
		return null;
	}

	@Override
	public JFrame getMainFrame() {
		return mainFrame;
	}

	@Override
	public JPanel getLeftSidePanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanel getRightSidePanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JFrame getErrorDialog() {
		// TODO Auto-generated method stub
		return new ErrorDialog();
	}

	@Override
	public void showMainFrame() {
		mainFrame.setVisible(true);
	}

}
