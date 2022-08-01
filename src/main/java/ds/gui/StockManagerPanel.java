package ds.gui;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import ds.stockManager.EmptyStockMessage;
import ds.stockManager.StockDatabase;
import ds.stockManager.StockManagerClient;
import ds.stockManager.StockMessage;

class StockManagerPanel{
	public JPanel servicePanel;
	public String Label = "Stock Manager";
	// TODO Enable AnimalLocatorClient
	private StockManagerClient client = new StockManagerClient();

	StockManagerPanel(){
    servicePanel = new JPanel();
		servicePanel.setVisible(false);
		servicePanel.setLayout(new BoxLayout(servicePanel, BoxLayout.Y_AXIS));
    refreshCurrentStockTypes();
    servicePanel.add(addStockPanel());
	}
  private ArrayList<String> currentStockTypes;
  private ArrayList<StockMessage> currentStock;

  private void refreshCurrentStockTypes(){
    EmptyStockMessage emptyStockMessage  = EmptyStockMessage.newBuilder().build();
    Iterator<StockMessage> stocksummary = client.getBlockingStub().stockSummary(emptyStockMessage);
    currentStockTypes = new ArrayList<String>();
    currentStock = new ArrayList<StockMessage>();
    while(stocksummary.hasNext()){
      StockMessage s = stocksummary.next();
      currentStockTypes.add(s.getStockType());
      currentStock.add(s);
    }
    
  }
  private JPanel addStockPanel(){
    JPanel addStockPanel = new JPanel();
    String[] arr = new String[currentStockTypes.size()];
    arr = currentStockTypes.toArray(arr);
    JComboBox<String> stockCJComboBox = new JComboBox<String>(arr);

    stockCJComboBox.setEditable(true);

    addStockPanel.add(stockCJComboBox);

    return addStockPanel;
  }
	
}