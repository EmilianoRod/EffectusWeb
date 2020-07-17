/*package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private Properties properties;

    public PropertyLoader() {
        properties = new Properties();
        loadProperties();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void loadProperties() {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/data.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/