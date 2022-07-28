package ds.gui;

// package ds.examples.maths;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ds.animalLocator.AnimalLocatorClient;
import ds.animalLocator.animalLocatorGrpc;
import ds.animalLocator.animalLocatorGrpc.animalLocatorBlockingStub;
import ds.animalLocator.animalLocatorGrpc.animalLocatorStub;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// import ds.examples.maths.CalculateRequest.Operation;
// import ds.examples.maths.MathServiceGrpc.MathServiceBlockingStub;
// import ds.examples.maths.MathServiceGrpc.MathServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
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

		// String math_service_type = "_maths._tcp.local.";
		// discoverMathService(math_service_type);

		// String host = mathServiceInfo.getHostAddresses()[0];
		// int port = mathServiceInfo.getPort();

		// ManagedChannel channel = ManagedChannelBuilder
		// .forAddress(host, port)
		// .usePlaintext()
		// .build();

		// stubs -- generate from proto
		// blockingStub = MathServiceGrpc.newBlockingStub(channel);

		// asyncStub = MathServiceGrpc.newStub(channel);

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	// private void changeVisibleServicePanel(int servicePanelN) {

	// }
	AnimalLocatorPanel animalLocatorPanel = new AnimalLocatorPanel();

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

		frame.getContentPane().setLayout(bl);

		JPanel panel_service_selector = new JPanel();
		frame.getContentPane().add(panel_service_selector);
		panel_service_selector.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// JPanel servicePanels[] = new
		// JPanel[]{service1Initialise(),service2Initialise(),service3Initialise()};
		class ServicePanels {

			private JPanel servicePanels[] = new JPanel[] { animalLocatorPanel.servicePanel, service2Initialise(),
					service3Initialise() };

			public void toggleVisiblePanel(int index) {
				// set visibile for those with index i and visible = false for others
				for (int i = 0; i < servicePanels.length; i++) {
					servicePanels[i].setVisible(index == i);
				}
			}

			// add service panels to frame
			public void addservicePanels() {
				for (JPanel panel : servicePanels) {
					frame.add(panel);
				}
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

		JButton service2Button = new JButton("Service 2");
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

		// JPanel panel_service_1 = new JPanel();
		// frame.getContentPane().add(panel_service_1);
		// panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// JLabel lblNewLabel_1 = new JLabel("Longitude");
		// panel_service_1.add(lblNewLabel_1);

		// textNumber1 = new JTextField();
		// panel_service_1.add(textNumber1);
		// textNumber1.setColumns(10);

		// JLabel lblNewLabel_2 = new JLabel("Latitude");
		// panel_service_1.add(lblNewLabel_2);

		// textNumber2 = new JTextField();
		// panel_service_1.add(textNumber2);
		// textNumber2.setColumns(10);

		// JComboBox comboOperation = new JComboBox();
		// comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ADDITION",
		// "SUBTRACTION", "MULTIPLICATION", "DIVISION"}));
		// panel_service_1.add(comboOperation);

		// JButton btnCalculate = new JButton("Calculate");
		// btnCalculate.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {

		// int num1 = Integer.parseInt(textNumber1.getText());
		// int num2 = Integer.parseInt(textNumber2.getText());

		// int index = comboOperation.getSelectedIndex();
		// // Operation operation = Operation.forNumber(index);

		// // CalculateRequest req =
		// CalculateRequest.newBuilder().setNumber1(num1).setNumber2(num2).setOperation(operation).build();

		// // CalculateResponse response = blockingStub.calculate(req);

		// //textResponse.append("reply:"+ response.getResult() + " mes:"+
		// response.getMessage() + "\n");

		// // System.out.println("res: " + response.getResult() + " mes: " +
		// response.getMessage());

		// }
		// });
		// panel_service_1.add(btnCalculate);

		// textResponse = new JTextArea(3, 20);
		// textResponse .setLineWrap(true);
		// textResponse.setWrapStyleWord(true);

		// JScrollPane scrollPane = new JScrollPane(textResponse);

		// //textResponse.setSize(new Dimension(15, 30));
		// panel_service_1.add(scrollPane);

		// JPanel panel_service_2 = new JPanel();
		// frame.getContentPane().add(panel_service_2);

		// JPanel panel_service_3 = new JPanel();
		// frame.getContentPane().add(panel_service_3);

	}

	/**
	 * object to connect to Animal Locator Service,
	 */
	public class AnimalLocatorPanel {
		public JPanel servicePanel;
		public String Label = "Animal Locator";

		private AnimalLocatorClient client = new AnimalLocatorClient();

		AnimalLocatorPanel() {
			// intialise panel and set visibilty
			servicePanel = new JPanel();
			servicePanel.setVisible(false);
			servicePanel.setLayout(new BoxLayout(servicePanel, BoxLayout.Y_AXIS));
			servicePanel.add(locationUpdatePanel());
			servicePanel.add(LastNLocationsPanel());
		}

		private JPanel locationUpdatePanel() {
			JPanel locationUpdateJpanel = new JPanel();
			JButton newLocationStreamButton = new JButton("New Location Stream");
			locationUpdateJpanel.add(newLocationStreamButton);

			// add label and field for longitude
			JLabel longitudeLabel = new JLabel("Longitude");
			locationUpdateJpanel.add(longitudeLabel);

			JTextField longitudeTextField = new JTextField();
			locationUpdateJpanel.add(longitudeTextField);
			longitudeTextField.setColumns(10);

			// add label and field for latitude
			JLabel latitudeLabel = new JLabel("Latitude");
			locationUpdateJpanel.add(latitudeLabel);
			longitudeTextField.setColumns(10);


			JTextField latitudeTextField = new JTextField();
			locationUpdateJpanel.add(latitudeTextField);

			newLocationStreamButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				}

			});
			return locationUpdateJpanel;
		}

		private JPanel LastNLocationsPanel() {
			JPanel panel = new JPanel();
			JButton button = new JButton("Last N Locations");
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				}

			});
			panel.add(button);
			return panel;
		}
	}

	private JPanel service1Initialise() {

		JPanel panel_service_1 = new JPanel();

		JPanel panel_LocationUpdate = locationUpdateJpanel();

		// JLabel lblNewLabel_1 = new JLabel("Service 1 Label");

		panel_service_1.add(panel_LocationUpdate);

		panel_service_1.setVisible(false);

		return panel_service_1;

	}

	// panel to run locationUpdate method
	private JPanel locationUpdateJpanel() {
		JPanel locationUpdateJpanel = new JPanel();
		JButton service3Button = new JButton("New Location Stream");
		service3Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}

		});
		locationUpdateJpanel.add(service3Button);
		return locationUpdateJpanel;
	}

	private JPanel service2Initialise() {
		JPanel panel_service_1 = new JPanel();

		JLabel lblNewLabel_1 = new JLabel("Service 2 Label");

		panel_service_1.add(lblNewLabel_1);
		panel_service_1.setVisible(false);

		return panel_service_1;

	}

	private JPanel service3Initialise() {
		JPanel panel_service_1 = new JPanel();

		JLabel lblNewLabel_1 = new JLabel("Service 3 Label");

		panel_service_1.add(lblNewLabel_1);
		panel_service_1.setVisible(false);
		return panel_service_1;

	}

}
