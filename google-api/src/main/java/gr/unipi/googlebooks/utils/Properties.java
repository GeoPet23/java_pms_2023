package gr.unipi.googlebooks.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Utilities singleton class that reads the needed properties from a file name google-api.properties.
 * This file needs to be in the resources folder of the main project.
 * */
public class Properties extends java.util.Properties {

    private static Properties instance;

    private Properties() throws IOException {
        super();
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        this.load(new FileInputStream(rootPath + "google-api.properties"));
    }

    private static Properties getInstance() throws IOException {
        if(instance == null) {
            instance = new Properties();
        }
        return instance;
    }

    public static String getApiKey() throws IOException {
        return getInstance().getProperty("api.key");
    }

    public static String getApiURL() throws IOException {
        return getInstance().getProperty("api.url");
    }
}
