package ds.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.midi.SysexMessage;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ds.stockManager.EmptyStockMessage;
import ds.stockManager.StockDatabase;
import ds.stockManager.StockManagerClient;
import ds.stockManager.StockMessage;
import io.grpc.stub.StreamObserver;

class StockManagerPanel {
  public JPanel servicePanel;
  public String Label = "Stock Manager";
  // TODO Enable AnimalLocatorClient
  private StockManagerClient client = new StockManagerClient();

  StockManagerPanel() {
    servicePanel = new JPanel();
    servicePanel.setVisible(false);
    servicePanel.setLayout(new BoxLayout(servicePanel, BoxLayout.Y_AXIS));
    refreshCurrentStockTypes();
    servicePanel.add(addStockPanel());
    servicePanel.add(stockSummaryPanel());
  }

  private ArrayList<String> currentStockTypes;
  private ArrayList<StockMessage> currentStock;

  private void refreshCurrentStockTypes() {
    EmptyStockMessage emptyStockMessage = EmptyStockMessage.newBuilder().build();
    Iterator<StockMessage> stocksummary = client.getBlockingStub().stockSummary(emptyStockMessage);
    currentStockTypes = new ArrayList<String>();
    currentStock = new ArrayList<StockMessage>();
    while (stocksummary.hasNext()) {
      StockMessage s = stocksummary.next();
      currentStockTypes.add(s.getStockType());
      currentStock.add(s);
    }

  }

  StreamObserver<StockMessage> addStockStreamObserver;

  private JPanel addStockPanel() {
    JPanel addStockPanel = new JPanel();

    String[] arr = new String[currentStockTypes.size()];
    arr = currentStockTypes.toArray(arr);
    JComboBox<String> stockCJComboBox = new JComboBox<String>(arr);
    stockCJComboBox.setEditable(true);

    JButton newStreamButton = new JButton("New Add Stock Stream");

    JTextField stockVolumeTextField = new JTextField(2);

    JButton addButton = new JButton("Add Stock");

    // add action listener to new stream button which is also close stream button
    newStreamButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // toggle buttons
        stockCJComboBox.setEnabled(!stockCJComboBox.isEnabled());
        stockVolumeTextField.setEnabled(!stockVolumeTextField.isEnabled());
        addButton.setEnabled(!addButton.isEnabled());

        // if the button is in new stream mode
        if (newStreamButton.getText().equals("New Add Stock Stream")) {
          newStreamButton.setEnabled(!newStreamButton.isEnabled());
          newStreamButton.setText("Close Stream");
          System.out.println("New add stock stream...");
          ;
          addStockStreamObserver = client.getAsyncStub().addStock(new StreamObserver<StockMessage>() {

            @Override
            public void onNext(StockMessage value) {
              // TODO Auto-generated method stub
              System.out.println("Returned Value - " + value.getStockType() + " : " + value.getStockVolume());

            }

            @Override
            public void onError(Throwable t) {
              // TODO Auto-generated method stub

            }

            @Override
            public void onCompleted() {
              // TODO Auto-generated method stub
              System.out.println("Stream Ended");

            }

          });
          newStreamButton.setEnabled(!newStreamButton.isEnabled());
        }
        // if the button is in close stream mode
        else {
          newStreamButton.setEnabled(!newStreamButton.isEnabled());
          newStreamButton.setText("New Add Stock Stream");
          addStockStreamObserver.onCompleted();
          newStreamButton.setEnabled(!newStreamButton.isEnabled());

        }

      }

    });

    // add stock button listener
    addButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        double stockVolume = Double.parseDouble(stockVolumeTextField.getText());
        StockMessage stockMessage = StockMessage.newBuilder().setStockType((String) stockCJComboBox.getSelectedItem())
            .setStockVolume(stockVolume).build();
        addStockStreamObserver.onNext(stockMessage);

      }

    });

    addStockPanel.add(newStreamButton);
    addStockPanel.add(stockCJComboBox);
    stockCJComboBox.setEnabled(false);
    addStockPanel.add(stockVolumeTextField);
    stockVolumeTextField.setEnabled(false);
    addStockPanel.add(addButton);
    addButton.setEnabled(false);

    return addStockPanel;
  }
  private JPanel stockSummaryPanel(){
    JPanel stockSummaryPanel = new JPanel();
    JTextArea stockSummaryTextArea = new JTextArea(5, 20);
    stockSummaryTextArea.setEditable(false);
    JScrollPane stockSummaryScrolPane = new JScrollPane(stockSummaryTextArea);
    JButton stockSummaryButton = new JButton("Get Stock Summary");

    stockSummaryButton.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        refreshCurrentStockTypes();
        stockSummaryTextArea.setText("");
        for(StockMessage s:currentStock){
          stockSummaryTextArea.append(s.getStockType() + " : " + s.getStockVolume() + "\n");
        }
        
      }

    });
    stockSummaryPanel.add(stockSummaryButton);
    stockSummaryPanel.add(stockSummaryScrolPane);
    return stockSummaryPanel;
  }

}