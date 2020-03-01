package org.burakisik.osgi.user.interfaces;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private JButton btnNorth, btnSouth, btnCenter, btnEast, btnWest;

	public MyFrame() {
		setTitle(InternationalizingManager.fetchTextfromResourceBundle("main_frame_title"));
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

		btnNorth = new JButton("Header Panel");
		add(btnNorth, BorderLayout.NORTH);
		btnSouth = new JButton("Footer Panel");
		add(btnSouth, BorderLayout.SOUTH);
		btnCenter = new JButton("GPS Panel");
		add(btnCenter, BorderLayout.CENTER);
		btnEast = new JButton("Left Panel");
		add(btnEast, BorderLayout.EAST);
		btnWest = new JButton("Right Panel");
		add(btnWest, BorderLayout.WEST);
	}

	private void initEvent() {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

		/*
		 * btnStart.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { btnStartClick(e); } });
		 * 
		 * btnStop.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { btnStopClick(e); } });
		 */
	}

	private void btnStartClick(ActionEvent evt) {
		System.exit(0);
	}

	private void btnStopClick(ActionEvent evt) {

	}
}
