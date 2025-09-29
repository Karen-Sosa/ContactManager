package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import utilities.Constants;

public class ConfigManager {

    public void writerConfig(String key, String value) {
        try (FileInputStream input = new FileInputStream(Constants.CONFIG_PATH)) {
            Properties prop = new Properties();
            prop.load(input);

            prop.setProperty(key, value);

            try (FileOutputStream output = new FileOutputStream(Constants.CONFIG_PATH)) {
                prop.store(output, "Update config");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   

    public String readerCofig(String key) {
        try (FileInputStream input = new FileInputStream(Constants.CONFIG_PATH)) {
            Properties prop = new Properties();
            prop.load(input);

            return prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}