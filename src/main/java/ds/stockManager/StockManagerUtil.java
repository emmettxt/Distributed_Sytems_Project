package ds.stockManager;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.Charset;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

public class StockManagerUtil {
  static String defaultPath = "animal_locator_db.json";

  public static StockDatabase parseDatabase() throws IOException {
    return StockDatabase(defaultPath);
  }

  private static StockDatabase StockDatabase(String path) throws IOException {
    InputStream input = new FileInputStream(path);
    try {
      Reader reader = new InputStreamReader(input, Charset.forName("UTF-8"));
      try {
        StockDatabase.Builder database = StockDatabase.newBuilder();

        JsonFormat.parser().merge(reader, database);
        return database.build();
      } finally {
        reader.close();
      }

    } finally {
      input.close();
    }
  }

  // wrties to default DB
  public static void writeToDB(StockDatabase database) throws InvalidProtocolBufferException {

    writeToDB(database, defaultPath);

  }

  public static void writeToDB(StockDatabase database, String path) throws InvalidProtocolBufferException {
    System.out.println("Writing to Database...");
    String json = JsonFormat.printer().print(database);
    try {
      PrintWriter printWriter = new PrintWriter(new FileWriter(path));
      printWriter.write(json);
      printWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}