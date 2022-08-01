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

import ds.alerter.AlertDetails;
import ds.alerter.AlertIdMessage;
import ds.alerter.AlertMessage;
import ds.alerter.AlerterClient;
import ds.alerter.AlertMessage.PriorityLevel;

public class AlerterPanel {
	public JPanel servicePanel;
	public String Label = "Alerter";
	// TODO Enable AnimalLocatorClient
	private AlerterClient client = new AlerterClient();
	private JPanel currentAlertPanel = currentAlertPanel();

	AlerterPanel() {
		// intialise panel and set visibilty
		servicePanel = new JPanel();
		servicePanel.setVisible(false);
		servicePanel.setLayout(new BoxLayout(servicePanel, BoxLayout.Y_AXIS));
		servicePanel.add(newAlertPanel());
		servicePanel.add(currentAlertPanel);
		// servicePanel.add(LastNLocationsPanel());
		// servicePanel.add(CurrentHeardLocationPanel());
	}

	private JPanel newAlertPanel() {
		JPanel newAlertPanel = new JPanel();
		JComboBox<PriorityLevel> priorityComboBox = new JComboBox<PriorityLevel>();
		priorityComboBox.setModel(new DefaultComboBoxModel<PriorityLevel>(new PriorityLevel[]{PriorityLevel.HIGH,PriorityLevel.LOW,PriorityLevel.MEDIUM}));
		newAlertPanel.add(priorityComboBox);

		JTextArea alertDescTextArea = new JTextArea(3, 20);
		alertDescTextArea.setLineWrap(true);
		alertDescTextArea.setWrapStyleWord(true);
		JScrollPane alertDescScrollPane = new JScrollPane(alertDescTextArea);
		newAlertPanel.add(alertDescScrollPane);

		JButton addAlertButton = new JButton("Add Alert");
		newAlertPanel.add(addAlertButton);
		addAlertButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String alertDescription = alertDescTextArea.getText();
    		System.out.println("Registering new Alert");
				PriorityLevel priorityLevel= (PriorityLevel) priorityComboBox.getSelectedItem();

				AlertMessage alertMessage = AlertMessage.newBuilder().setDescription(alertDescription).setPriorityLevel(priorityLevel).build();
				alertDescTextArea.setText("");
			System.out.println("Priority: " + alertMessage.getPriorityLevel());
			System.out.println("Description: " + alertMessage.getDescription() + "\n");

				AlertDetails alertDetails =  client.getBlockingStub().newAlert(alertMessage);

				System.out.println("New Alert Registered, id: " + alertDetails.getAlertId());	
				refreshCurrentAlertPanel();
			}
		});
		return newAlertPanel;
	}
	
	private JPanel currentAlertPanel(){
		JPanel currentAlertPanel = new JPanel();
		JPanel currentAlertsContainer = new JPanel();
		currentAlertsContainer.setLayout(new BoxLayout(currentAlertsContainer, BoxLayout.Y_AXIS));
		currentAlertsContainer.setSize(40, 10);
		//TODO fix this scrollpane
		JScrollPane scrollPane = new JScrollPane(currentAlertsContainer);
		
		ds.alerter.EmptyMessage emptyMessage = ds.alerter.EmptyMessage.newBuilder().build();
		Iterator<AlertDetails> currentAlerts;
		currentAlerts = client.getBlockingStub().getCurrentAlerts(emptyMessage);
		while(currentAlerts.hasNext()){
			AlertDetails alertDetails = currentAlerts.next();
			JPanel alertPanel = new JPanel();

			alertPanel.add(new JLabel(alertDetails.getAlertMessage().getPriorityLevel().toString()));
			alertPanel.add(new JLabel(alertDetails.getAlertMessage().getDescription()));
			JButton clearButton = new JButton("Clear Alert");
			alertPanel.add(clearButton);
			clearButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					AlertIdMessage alertIdMessage = AlertIdMessage.newBuilder().setAlertId(alertDetails.getAlertId()).build();
					client.getBlockingStub().clearAlert(alertIdMessage);
					refreshCurrentAlertPanel();
				}

			});
			currentAlertsContainer.add(alertPanel);

		}
		currentAlertPanel.add(scrollPane);
		return currentAlertPanel;


	}
	private void refreshCurrentAlertPanel(){
		servicePanel.remove(currentAlertPanel);
		this.currentAlertPanel = currentAlertPanel();
		servicePanel.add(currentAlertPanel);
		servicePanel.revalidate();
		servicePanel.repaint();
		currentAlertPanel.revalidate();
		currentAlertPanel.repaint();
	}
}