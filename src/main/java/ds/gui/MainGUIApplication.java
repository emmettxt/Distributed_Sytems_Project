package ds.gui;

// package ds.examples.maths;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ScrollPaneLayout;
import javax.swing.JButton;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUIApplication {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUIApplication window = new MainGUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUIApplication() {

		initialize();
	}
	
	AnimalLocatorPanel animalLocatorPanel = new AnimalLocatorPanel();
	AlerterPanel alerterPanel = new AlerterPanel();
	StockManagerPanel stockManagerPanel = new StockManagerPanel();

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		// frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

		frame.getContentPane().setLayout(bl);

		JPanel panel_service_selector = new JPanel();
		frame.getContentPane().add(panel_service_selector);
		panel_service_selector.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		class ServicePanels {

			private JPanel servicePanels[] = new JPanel[] { animalLocatorPanel.servicePanel, alerterPanel.servicePanel,
					stockManagerPanel.servicePanel};

			public void toggleVisiblePanel(int index) {
				// set visibile for those with index i and visible = false for others
				for (int i = 0; i < servicePanels.length; i++) {
					servicePanels[i].setVisible(index == i);
				}
				frame.pack();

			}

			// add service panels to frame
			public void addservicePanels() {
				for (JPanel panel : servicePanels) {
					frame.add(panel);
				}
				frame.pack();
			}

		}
		ServicePanels servicePanels = new ServicePanels();
		JButton service1Button = new JButton(animalLocatorPanel.Label);
		service1Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Service Button 1 Pressed");
				servicePanels.toggleVisiblePanel(0);
			}

		});
		panel_service_selector.add(service1Button);

		JButton service2Button = new JButton(alerterPanel.Label);
		service2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Service Button 2 Pressed");
				servicePanels.toggleVisiblePanel(1);

			}

		});
		panel_service_selector.add(service2Button);

		JButton service3Button = new JButton("Service 3");
		service3Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Service Button 3 Pressed");
				servicePanels.toggleVisiblePanel(2);
			}

		});
		panel_service_selector.add(service3Button);

		servicePanels.addservicePanels();
	}

}
