package testframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private static Properties configProperties;

    // Load the configuration properties from a file
    public static Properties getConfigProperties() {
        if (configProperties == null) {
            configProperties = new Properties();
            try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
                configProperties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not load configuration properties.");
            }
        }
        return configProperties;
    }
}
