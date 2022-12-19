package by.a1qa.task2_1.driver.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONCustomParser {
    private static JSONParser parser = new JSONParser();

    public static List<String> parseArrayToListByName(String path, String elementName){
        List<String> values = new ArrayList<>();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            JSONArray elements = (JSONArray)jsonObject.get(elementName);
            for(Object obj : elements){
                values.add(obj.toString());
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return values;
    }

    public static String parseElementByName(String path, String elementName){
        String value = null;
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            value = (String) jsonObject.get(elementName);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return value;
    }
}
