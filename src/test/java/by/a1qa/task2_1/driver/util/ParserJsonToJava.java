package by.a1qa.task2_1.driver.util;

import by.a1qa.task2_1.driver.bean.GameInformation;
import by.a1qa.task2_1.driver.bean.PrivacyPolicyRevision;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class ParserJsonToJava {
    public static List<GameInformation> jsonParse(String path) throws IOException {
        File file = new File(path);
        ObjectMapper om = new ObjectMapper();
        List<GameInformation> result = om.readValue(file, new TypeReference<List<GameInformation>>(){});
        return result;
    }

    public static PrivacyPolicyRevision jsonParseObject(String path) throws IOException {
        ObjectMapper om = new ObjectMapper();
        PrivacyPolicyRevision result = om.readValue(Paths.get(path).toFile(), PrivacyPolicyRevision.class);
        return result;
    }
}
