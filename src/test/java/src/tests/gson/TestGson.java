package src.tests.gson;

import com.google.gson.Gson;
import src.test_data.models.LoginCred;
import src.test_data.untils.DataObjectBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGson {
    public static void main(String[] args) {
        Gson gson= new Gson();
        //From json to object
//        String jsonStr= "{\n" +
//                "  \"userName\": \"teo\",\n" +
//                "  \"password\" : \"12345678\"\n" +
//                "}";
//        LoginCred loginCred= gson.fromJson(jsonStr,LoginCred.class);
        // Mot object
        System.out.println("Get a object:");
        String fileLocation="/src/test/java/src/tests/gson/loginData.json";
        LoginCred loginCred= DataObjectBuilder.buildDataObject(fileLocation, LoginCred.class);
        System.out.println(loginCred);
       // nhieu object
        System.out.println("nhieu object:");
        String fileLocationList = "/src/test/java/src/tests/gson/loginDataList.json";
        LoginCred[] loginCredList = DataObjectBuilder.buildDataObject(fileLocationList, LoginCred[].class);
        for (LoginCred cred : loginCredList) {
            System.out.println(cred);
        }
        //Get all list object
        System.out.println("Get all list object:");
        String fileLocationList2 = "/src/test/java/src/tests/gson/loginDataList.json";
        List<LoginCred> loginCredList2 = Arrays.asList(DataObjectBuilder.buildDataObject(fileLocationList2, LoginCred[].class));
        for (LoginCred cred2 : loginCredList) {
            System.out.println(cred2);
        }

        //from object to json
//        LoginCred loginCred1= new LoginCred("Ha", "12345678");
//        String jsonStr2= gson.toJson(loginCred1);
//        System.out.println(jsonStr2);
    }
}
