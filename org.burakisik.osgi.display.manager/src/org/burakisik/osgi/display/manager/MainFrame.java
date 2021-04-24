package org.burakisik.osgi.display.manager;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.burakisik.osgi.common.data.Placement;
import org.burakisik.osgi.common.service.ui.component.CustomPanel;

public class MainFrame extends JFrame {

	private final Logger logger = LogManager.getLogger(MainFrame.class);

	private static final long serialVersionUID = -809096053787527060L;
	private JButton btnNorth, btnSouth, btnEast, btnWest;

	public MainFrame(List<JPanel> panels) {
		// setTitle(Services.getInstance().getI18n().fetchTextfromResourceBundle(MAIN_FRAME_TITLE));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		initComponent(panels);
		initEvent();
		setVisible(true);
	}

	private void initComponent(List<JPanel> panels) {
		setLayout(new BorderLayout(3, 3));

		panels.forEach(panel -> {
			Placement placement = ((CustomPanel) panel).getPlacement();
			switch (placement.location()) {
			case LEFT: {
				add(panel, BorderLayout.WEST);
				break;
					}
			case RIGHT: {
				break;
			}
			case CENTER: {
				break;
			}
			case BOTTOM: {
				break;
			}
			case TOP: {
				break;
			}
			}});

		/*
		btnNorth = new JButton(HEADER_PANEL_TITLE);
		add(btnNorth, BorderLayout.NORTH);
		btnSouth = new JButton(FOOTER_PANEL_TITLE);
		add(btnSouth, BorderLayout.SOUTH);
		btnEast = new JButton(LEFT_PANEL_TITLE);
		add(btnEast, BorderLayout.EAST);
		btnWest = new JButton(RIGHT_PANEL_TITLE);
		add(btnWest, BorderLayout.WEST);
		*/
	}

	private void initEvent() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				logger.debug("Window exit button was clicked");
				System.exit(1);
			}
		});
	}
}
