package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonConverter {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveToJson(Object classObject, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(classObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T readFromJson(String filePath, Class<T> classObject) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, classObject);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}