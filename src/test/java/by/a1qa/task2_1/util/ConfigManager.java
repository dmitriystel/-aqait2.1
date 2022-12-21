package by.a1qa.task2_1.util;

public class ConfigManager {
    private static final String CONFIG_FILE_PATH = "src/test/resources/configData/config.json";

    public static String getURL(){
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "url");
    }

    public static int getWaitDurationInSeconds(){
        return Integer.parseInt(JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "waitDuration"));
    }

    public static String getBrowserMode(){
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "browserMode");
    }
}
