package org.burakisik.osgi.user.interfaces;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.burakisik.osgi.common.data.Placement;
import org.burakisik.osgi.common.service.i18n.InternationalizationService;
import org.burakisik.osgi.common.service.ui.AircraftDetectorService;
import org.burakisik.osgi.common.service.ui.PanelPresenter;
import org.burakisik.osgi.common.service.ui.component.CustomPanel;
import org.burakisik.osgi.common.type.LocationOnScreen;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = PanelPresenter.class, immediate = true)
public class UiServiceImpl implements PanelPresenter {
		
	@Activate
	protected void activate() {
		System.out.println("UiServiceImpl.activate()");
	}
	
	@Reference
	protected void setI18n(InternationalizationService service) {
		Services.getInstance().setI18n(service);
	}
	
	@Reference
	protected void setSFDS(AircraftDetectorService service) {
		Services.getInstance().setAircraftDetectorService(service);
	}

	@Override
	public List<JPanel> present() {
		List<JPanel> panels = new ArrayList<>();
		panels.add(leftPanel());
		panels.add(rightPanel());
		panels.add(contentPane());
		return panels;
	}

	private JPanel rightPanel() {
		JPanel topPanel = new CustomPanel(new Placement(LocationOnScreen.TOP, 1));
		JLabel header = new JLabel("Header");
		topPanel.add(header);
		topPanel.setBackground(Color.LIGHT_GRAY);
		topPanel.setLayout(new FlowLayout());
		return topPanel;
	}

	private JPanel leftPanel() {
		JPanel leftSideBar = new CustomPanel(new Placement(LocationOnScreen.LEFT, 1));
		leftSideBar.add(new Label("Item1"));
		leftSideBar.add(new Label("Item2"));
		leftSideBar.add(new Label("Item3"));
		leftSideBar.add(new Label("Item4"));
		leftSideBar.setBackground(Color.LIGHT_GRAY);
		leftSideBar.setLayout(new BoxLayout(leftSideBar, BoxLayout.Y_AXIS));
		return leftSideBar;
	}
	
	private JPanel contentPane() {
		JPanel contentPane  = Services.getInstance().getAircraftDetectorService().getView();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(new FlowLayout());
		return contentPane;
	}
}
