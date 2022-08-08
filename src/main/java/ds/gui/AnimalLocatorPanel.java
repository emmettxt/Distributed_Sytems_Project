package ds.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;

import ds.animalLocator.AnimalLocatorClient;
import ds.animalLocator.HeardMemeberNMessage;
import ds.animalLocator.LocationMessage;
import ds.animalLocator.LocationResponse;
import ds.animalLocator.Point;
import io.grpc.stub.StreamObserver;

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
				try{
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
						
				}catch(NumberFormatException nfe){
					textResponse.setText("Invalid Number: \"" + nTextField.getText() + "\" is not an integer");
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
				ds.animalLocator.EmptyMessage emptyMessage = ds.animalLocator.EmptyMessage.newBuilder().build();
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
							l.getAnimalId() + ": \n   "
									+ "Long: " + l.getPoint().getLongitude()
									+ " Lat: " + l.getPoint().getLatitude()
									+ "\n   " + time + "\n");

				}

			}

		});

		return currentHeardLocPanel;
	}
}