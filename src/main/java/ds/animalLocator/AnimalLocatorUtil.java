package ds.animalLocator;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

public class AnimalLocatorUtil {

    //default path of DB file
    public static String getDefaultLocationsPath() {
        return "animal_locator_db.json";
    }


    //reads the database
    public static LocationDatabase parseLocations(String path) throws IOException {
        InputStream input = new FileInputStream(path);
        try {
            Reader reader = new InputStreamReader(input, Charset.forName("UTF-8"));
            try {
                LocationDatabase.Builder database = LocationDatabase.newBuilder();
                
                JsonFormat.parser().merge(reader, database);
                return database.build();
            } finally {
                reader.close();
            }

        } finally {
            input.close();
        }
    }

    //wrties to default DB
    public static void writeLocationToDB(LocationDatabase locationDatabase) throws InvalidProtocolBufferException {
        // writeLocationToDB(locationMessage, getDefaultLocationsPath().toString());
        writeLocationToDB(locationDatabase, getDefaultLocationsPath());

    }

    public static void writeLocationToDB(LocationDatabase locationDatabase, String path) throws InvalidProtocolBufferException {
        System.out.println("Writing locations to Database...");
        String json = JsonFormat.printer().print(locationDatabase);
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(path));
            printWriter.write(json);
            printWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
