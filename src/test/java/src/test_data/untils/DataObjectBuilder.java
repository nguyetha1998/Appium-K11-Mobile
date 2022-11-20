package src.test_data.untils;

import com.google.gson.Gson;
import src.test_data.models.LoginCred;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DataObjectBuilder {
    public static <T> T buildDataObject(String fileLocation, Class<T> dataType) {
        T returnData= null;
        String absoluteFilePath = System.getProperty("user.dir").concat(fileLocation);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath))
        ) {
            Gson gson = new Gson();
            returnData = gson.fromJson(reader, dataType);

        } catch (NoSuchFileException noSuchFiledException) {
            throw new RuntimeException("ERR: Not found location of file:".concat(absoluteFilePath));
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        if(returnData==null){
            throw  new RuntimeException("ERR return data null");
        }
        return returnData;

    }
}
