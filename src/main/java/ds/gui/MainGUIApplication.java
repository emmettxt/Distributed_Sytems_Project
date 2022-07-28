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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;

import ds.animalLocator.AnimalLocatorClient;
import ds.animalLocator.EmptyMessage;
import ds.animalLocator.HeardMemeberNMessage;
import ds.animalLocator.LocationMessage;
import ds.animalLocator.LocationResponse;
import ds.animalLocator.Point;
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
import io.grpc.netty.shaded.io.netty.handler.codec.compression.FastLzFrameDecoder;
import io.grpc.stub.StreamObserver;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
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
		// frame.setBounds(100, 100, 500, 300);
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
		{
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
	}

	/**
	 * object to connect to Animal Locator Service,
	 */
	public class AnimalLocatorPanel {
		public JPanel servicePanel;
		public String Label = "Animal Locator";
		// TODO Enable AnimalLocatorClient
		private AnimalLocatorClient client = new AnimalLocatorClient();
		StreamObserver<LocationResponse> locationUpdateResponseObserver;
		StreamObserver<LocationMessage> locationUpdateRequestObserver;

		AnimalLocatorPanel() {
			// intialise panel and set visibilty
			servicePanel = new JPanel();
			servicePanel.setVisible(false);
			servicePanel.setLayout(new BoxLayout(servicePanel, BoxLayout.Y_AXIS));
			servicePanel.add(locationUpdatePanel());
			servicePanel.add(LastNLocationsPanel());
			servicePanel.add(CurrentHeardLocationPanel());
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
			longitudeTextField.setColumns(2);
			longitudeTextField.setEnabled(false);

			// add label and field for latitude
			JLabel latitudeLabel = new JLabel("Latitude");
			locationUpdateJpanel.add(latitudeLabel);

			JTextField latitudeTextField = new JTextField();
			locationUpdateJpanel.add(latitudeTextField);
			latitudeTextField.setColumns(2);
			latitudeTextField.setEnabled(false);

			JComboBox<String> animalIdComboBox = new JComboBox<String>();
			animalIdComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "AnimalID_1",
					"AnimalID_2", "AnimalID_3", "AnimalID_4" }));
			animalIdComboBox.setEnabled(false);
			locationUpdateJpanel.add(animalIdComboBox);

			JButton sendButton = new JButton();
			sendButton.setText("Send Location");
			sendButton.setEnabled(false);
			locationUpdateJpanel.add(sendButton);

			JButton closeStreamButton = new JButton();
			closeStreamButton.setText("Close Stream");
			closeStreamButton.setEnabled(false);
			locationUpdateJpanel.add(closeStreamButton);

			newLocationStreamButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					latitudeTextField.setEnabled(true);
					longitudeTextField.setEnabled(true);
					animalIdComboBox.setEnabled(true);
					sendButton.setEnabled(true);
					closeStreamButton.setEnabled(true);
					newLocationStreamButton.setEnabled(false);

					locationUpdateResponseObserver = new StreamObserver<LocationResponse>() {

						@Override
						public void onNext(LocationResponse value) {
							System.out.println("Received " + value.getCountRecieved() + " Locations");

						}

						@Override
						public void onError(Throwable t) {
							t.printStackTrace();

						}

						@Override
						public void onCompleted() {
							System.out.println("stream is completed ... ");

						}

					};
					locationUpdateRequestObserver = client.getAsyncStub()
							.locationUpdater(locationUpdateResponseObserver);

				}

			});

			sendButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int lat = Integer.parseInt(latitudeTextField.getText());
					int lon = Integer.parseInt(longitudeTextField.getText());
					Point point = Point.newBuilder().setLatitude(lat).setLongitude(lon).build();

					String animalId = animalIdComboBox.getSelectedItem().toString();

					long millis = System.currentTimeMillis();
					Timestamp timestamp = Timestamp.newBuilder().setSeconds(millis / 1000)
							.setNanos((int) ((millis % 1000) * 1000000)).build();

					LocationMessage locationMessage = LocationMessage.newBuilder().setAnimalId(animalId).setPoint(point)
							.setTime(timestamp).build();
					locationUpdateRequestObserver.onNext(locationMessage);

					longitudeTextField.setText("");
					latitudeTextField.setText("");

				}

			});

			closeStreamButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					locationUpdateRequestObserver.onCompleted();

					latitudeTextField.setEnabled(false);
					longitudeTextField.setEnabled(false);
					animalIdComboBox.setEnabled(false);
					sendButton.setEnabled(false);
					closeStreamButton.setEnabled(false);
					newLocationStreamButton.setEnabled(true);

				}

			});
			return locationUpdateJpanel;
		}

		private JPanel LastNLocationsPanel() {
			JPanel lastNLocationsPanel = new JPanel();
			JButton lstNLocationsButton = new JButton("Last N Locations");

			JComboBox<String> animalIdComboBox = new JComboBox<String>();
			animalIdComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "AnimalID_1",
					"AnimalID_2", "AnimalID_3", "AnimalID_4" }));
			lastNLocationsPanel.add(animalIdComboBox);

			// add label and field for n
			JLabel nLabel = new JLabel("N");
			lastNLocationsPanel.add(nLabel);
			JTextField nTextField = new JTextField();
			lastNLocationsPanel.add(nTextField);
			nTextField.setColumns(2);

			// text area for result
			JTextArea textResponse = new JTextArea(3, 20);
			textResponse.setLineWrap(true);
			textResponse.setWrapStyleWord(true);
			textResponse.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textResponse);
			lastNLocationsPanel.add(scrollPane);

			lstNLocationsButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					textResponse.setText("");
					String animalId = animalIdComboBox.getSelectedItem().toString();
					int n = Integer.parseInt(nTextField.getText());
					HeardMemeberNMessage heardMemeberNMessage = HeardMemeberNMessage.newBuilder().setAnimalId(animalId)
							.setN(n).build();
					Iterator<LocationMessage> locationMessages = client.getBlockingStub()
							.lastNLocations(heardMemeberNMessage);
					while (locationMessages.hasNext()) {
						LocationMessage l = locationMessages.next();
						String time;
						try {
							time = JsonFormat.printer().print(l.getTime());
						} catch (InvalidProtocolBufferException t) {
							time = l.getTime().toString();
						}
						textResponse.append("Long: " + l.getPoint().getLongitude()
								+ " Lat: " + l.getPoint().getLatitude() + " @ " + time + "\n");

					}

				}

			});

			lastNLocationsPanel.add(lstNLocationsButton);
			return lastNLocationsPanel;
		}

		private JPanel CurrentHeardLocationPanel() {
			JPanel currentHeardLocPanel = new JPanel();

			JButton currentHeardLocButton = new JButton("Current Heard Location");
			currentHeardLocPanel.add(currentHeardLocButton);

			JTextArea textResponse = new JTextArea(3, 20);
			textResponse.setLineWrap(true);
			textResponse.setWrapStyleWord(true);
			textResponse.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textResponse);
			currentHeardLocPanel.add(scrollPane);

			currentHeardLocButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					textResponse.setText("");
					EmptyMessage emptyMessage = EmptyMessage.newBuilder().build();
					Iterator<LocationMessage> locationmessages;
					locationmessages = client.getBlockingStub().currentHeardLocation(emptyMessage);
					while (locationmessages.hasNext()) {
						LocationMessage l = locationmessages.next();
						String time;
						try {
							time = JsonFormat.printer().print(l.getTime());
						} catch (InvalidProtocolBufferException e1) {
							// TODO Auto-generated catch block
							time = l.getTime().toString();
						}
						textResponse.append(
								l.getAnimalId() + ": \n\t"
										+ "Long: " + l.getPoint().getLongitude()
										+ " Lat: " + l.getPoint().getLatitude()
										+ "\n\t" + time + "\n");

					}

				}

			});

			return currentHeardLocPanel;
		}
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
