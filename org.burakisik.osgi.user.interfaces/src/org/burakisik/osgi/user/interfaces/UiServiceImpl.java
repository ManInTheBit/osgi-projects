package org.burakisik.osgi.user.interfaces;

import java.awt.Color;
import java.awt.Label;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.burakisik.osgi.common.data.Placement;
import org.burakisik.osgi.common.service.i18n.InternationalizationService;
import org.burakisik.osgi.common.service.ui.PanelPresenter;
import org.burakisik.osgi.common.service.ui.component.CustomPanel;
import org.burakisik.osgi.common.type.LocationOnScreen;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

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

	@Override
	public List<JPanel> present() {
		List<JPanel> panels = new ArrayList<>();
		panels.add(leftPanel());
		return panels;
	}

	private JPanel leftPanel() {
		JPanel leftSideBar = new CustomPanel(new Placement(LocationOnScreen.LEFT, new Rectangle(10,200)));
		leftSideBar.add(new Label("Item1"));
		leftSideBar.add(new Label("Item2"));
		leftSideBar.add(new Label("Item3"));
		leftSideBar.add(new Label("Item4"));
		leftSideBar.setBackground(Color.LIGHT_GRAY);
		leftSideBar.setLayout(new BoxLayout(leftSideBar, BoxLayout.Y_AXIS));
		return leftSideBar;
	}
}
