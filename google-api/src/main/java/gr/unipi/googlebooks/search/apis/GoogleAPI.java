package gr.unipi.googlebooks.search.apis;

import gr.unipi.googlebooks.pojos.Bookshelf;
import gr.unipi.googlebooks.pojos.Bookshelves;
import gr.unipi.googlebooks.pojos.Volumes;
import gr.unipi.googlebooks.pojos.Volume;
import gr.unipi.googlebooks.search.enums.Download;
import gr.unipi.googlebooks.search.enums.Filter;
import gr.unipi.googlebooks.search.enums.PrintType;
import gr.unipi.googlebooks.utils.HttpUtils;
import gr.unipi.googlebooks.utils.Properties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Service singleton class that communicates with Google Books API in order to retrieve the corresponded
 * information.
 * */
public class GoogleAPI {

    private String apiKey;
    private String apiURL;
    private HttpUtils httpUtils;

    private static GoogleAPI instance;

    private GoogleAPI() throws IOException {
        this.apiKey = Properties.getApiKey();
        this.apiURL = Properties.getApiURL();
        this.httpUtils = HttpUtils.getInstance();
    }

    public static GoogleAPI getInstance() throws IOException {
        if(instance == null) {
            instance = new GoogleAPI();
        }
        return instance;
    }

    public Volumes searchVolumes(String q, Download download, Filter filter, PrintType printType) {
        Map<String, String> params = new HashMap<>();
        params.put("q", q);
        if(download != null) {
            params.put("download", download.getValue());
        }
        if(filter != null) {
            params.put("filter", filter.getValue());
        }
        if(printType != null) {
            params.put("printType", printType.getValue());
        }
        params.put("key", apiKey);
        return this.httpUtils.get(this.apiURL + "volumes", params, Volumes.class);
    }

    public Volume getVolume(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey);
        return this.httpUtils.get(this.apiURL + "volumes/" + id, params, Volume.class);
    }

    public Bookshelves getBookshelves(String userId) {
        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey);
        return this.httpUtils.get(this.apiURL + "users/" + userId + "/bookshelves", params, Bookshelves.class);
    }

    public Bookshelf getBookshelf(String userId, int id) {
        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey);
        return this.httpUtils.get(this.apiURL + "users/" + userId + "/bookshelves/" + id, params, Bookshelf.class);
    }

    public Volumes getVolumesOfBookshelf(String userId, int id) {
        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey);
        return this.httpUtils.get(this.apiURL + "users/" + userId + "/bookshelves/" + id + "/volumes", params, Volumes.class);
    }
}
