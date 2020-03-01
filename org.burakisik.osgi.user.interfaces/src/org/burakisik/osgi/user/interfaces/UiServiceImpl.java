package org.burakisik.osgi.user.interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.burakisik.osgi.user.interfaces.component.ErrorDialog;
import org.osgi.service.component.annotations.Component;

@Component(service = UiService.class, immediate = true)
public class UiServiceImpl implements UiService{

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
		return new MyFrame();
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

}
