package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
    static Properties prop;
    public static String getProperty(String key) {
        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream("config.properties");
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
