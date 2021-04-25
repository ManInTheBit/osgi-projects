package org.burakisik.osgi.display.manager;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.burakisik.osgi.common.data.DisplayInfo;
import org.burakisik.osgi.common.service.i18n.InternationalizationService;
import org.burakisik.osgi.common.service.ui.PanelPresenter;
import org.burakisik.osgi.common.service.utils.Environment;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class DisplayFormatter {
	
	private String mainScreenTitle;
	private Environment environment;
	private List<JPanel>  panels = new ArrayList<JPanel>();
	
	@Activate
	protected void activate() {
		showMainScreen();
	}
	
	@Reference
	protected void setPanel(PanelPresenter pp) {
		panels.addAll(pp.present());
	}
	
	@Reference
	protected void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	@Reference
	protected void setI18n(InternationalizationService i18n) {
		mainScreenTitle = i18n.fetchTextfromResourceBundle("main_frame_title");
	}
	
	private void showMainScreen() {
		DisplayInfo displayInfo =  environment.displayInfo();
		MainFrame mainFrame = new MainFrame(panels, mainScreenTitle);
		//mainFrame.setSize(new Dimension(displayInfo.width(), displayInfo.height()));
		mainFrame.setVisible(true);
	}
}