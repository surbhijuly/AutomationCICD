package E2ETesting.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference; // ✅ Correct

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;


public class DataReader {


    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        // read json to string
       String jsonContent =  FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//java//E2ETesting//data"), StandardCharsets.UTF_8);

       //String to Hashmap - use Jackson Databind dependency- add it in POM.xml
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data=  mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
return data;
    }
}
