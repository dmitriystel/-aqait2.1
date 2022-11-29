package by.a1qa.task2_1.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Writer {


        // String path = "src/test/resources/policyRevision.json";





    public static void writeValueToJson (String path, String policyRevision){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(path), policyRevision);
        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }


}
