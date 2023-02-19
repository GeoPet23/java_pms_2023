package gr.unipi.googlebooks.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Utilities singleton class in order to create GET requests with parameters
 * */
public class HttpUtils {
    RestTemplate restTemplate;
    private static HttpUtils instance;

    private HttpUtils() {
        this.restTemplate = new RestTemplate();
    }

    public static HttpUtils getInstance() {
        if(instance == null) {
            instance = new HttpUtils();
        }
        return instance;
    }

    public <T> T get(String url, Map<String, String> params, Class<T> tClass) {
        ResponseEntity<T> response = restTemplate.getForEntity(url + createParams(params), tClass);
        return response.getBody();
    }

    private String createParams(Map<String, String> params) {
        StringBuilder ret = new StringBuilder("?");
        int count = 0;
        for (Map.Entry<String, String> param : params.entrySet()) {
            ret.append(param.getKey()).append("=");
            ret.append(param.getValue());
            count++;
            if (count != params.entrySet().size()) {
                ret.append("&");
            }
        }
        return ret.toString();
    }
}
