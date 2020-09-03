package org.burakisik.osgi.user.interfaces;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static org.burakisik.osgi.user.interfaces.UIConstants.*;


public class MyFrame extends JFrame {
	final Logger logger = LogManager.getLogger(MyFrame.class);

	
	private JButton btnNorth, btnSouth, btnCenter, btnEast, btnWest;

	public MyFrame() {
		setTitle(InternationalizingManager.fetchTextfromResourceBundle(MAIN_FRAME_TITLE));
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(new Point(300, 200));
		setLayout(null);
		setResizable(false);

		initComponent();
		initEvent();
		setVisible(true);
	}

	private void initComponent() {
		setLayout(new BorderLayout(3, 3));

		btnNorth = new JButton(HEADER_PANEL_TITLE);
		add(btnNorth, BorderLayout.NORTH);
		btnSouth = new JButton(FOOTER_PANEL_TITLE);
		add(btnSouth, BorderLayout.SOUTH);
		btnCenter = new JButton(GPS_PANEL_TITLE);
		add(btnCenter, BorderLayout.CENTER);
		btnEast = new JButton(LEFT_PANEL_TITLE);
		add(btnEast, BorderLayout.EAST);
		btnWest = new JButton(RIGHT_PANEL_TITLE);
		add(btnWest, BorderLayout.WEST);
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
