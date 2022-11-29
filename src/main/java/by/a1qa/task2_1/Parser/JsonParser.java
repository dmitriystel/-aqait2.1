package by.a1qa.task2_1.Parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParser {

//    public static List<User> jsonParse(String path) throws IOException {
//        File file = new File(path);
//        ObjectMapper om = new ObjectMapper();
//        List<User> users = Arrays.asList(om.readValue(Paths.get(String.valueOf(file)).toFile(), User[].class));
//        return users;
//    }



    public static String jsonParse(String path) throws IOException {
        File file = new File(path);
        ObjectMapper om = new ObjectMapper();
        String result = String.valueOf(file);
        return result;
    }
}
