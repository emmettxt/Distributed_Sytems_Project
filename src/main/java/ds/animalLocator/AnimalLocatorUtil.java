package ds.animalLocator;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import com.google.protobuf.util.JsonFormat;



public class AnimalLocatorUtil {
    public static URL getDefaultLocationsFile() {
        return AnimalLocatorServer.class.getResource("animal_locator_db.json");
    }
    public static List<LocationMessage> parseLocations(URL file) throws IOException{
        InputStream input = file.openStream();
        try{
            Reader reader = new InputStreamReader(input,Charset.forName("UTF-8"));
            try{
                LocationDatabase.Builder database = LocationDatabase.newBuilder();
                JsonFormat.parser().merge(reader, database);
                return database.getLocationMessageList();
            }finally{
                reader.close();
            }

        }finally{
            input.close();
        }
    }
}   
