package gr.unipi.googlebooks.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Properties extends java.util.Properties {

    private static Properties instance;

    private Properties() throws IOException {
        super();
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        this.load(new FileInputStream(rootPath + "app.properties"));
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
