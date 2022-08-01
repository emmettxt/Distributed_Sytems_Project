package ds.gui;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ds.alerter.AlerterServer;
import ds.animalLocator.AnimalLocatorServer;
import ds.stockManager.StockManagerServer;

public class StartServers {
  public static void main(String[] args) throws IOException {

    ExecutorService executor = Executors.newFixedThreadPool(3);


    executor.execute(new AnimalLocatorServerRunnable());
    executor.execute(new AlerterServerRunnable());
    executor.execute(new StockManagerServerRunnable());
    executor.shutdown();
  }

  public static class AnimalLocatorServerRunnable implements Runnable {
    @Override
    public void run() {
      String[] args = {};
      try {
        AnimalLocatorServer.main(args);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public static class AlerterServerRunnable implements Runnable {
    @Override
    public void run() {
      String[] args = {};
      AlerterServer.main(args);
    }
  }

  public static class StockManagerServerRunnable implements Runnable {
    @Override
    public void run() {
      String[] args = {};
      StockManagerServer.main(args);

    }
  }
}
