package gr.unipi.googlebooks.search.apis;

import gr.unipi.googlebooks.pojos.Volume;
import gr.unipi.googlebooks.search.enums.Download;
import gr.unipi.googlebooks.search.enums.Filter;
import gr.unipi.googlebooks.search.enums.PrintType;
import gr.unipi.googlebooks.utils.HttpUtils;
import gr.unipi.googlebooks.utils.Properties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PerformingSearch {

    private String apiKey;
    private String apiURL;
    private HttpUtils httpUtils;

    public PerformingSearch() throws IOException {
        this.apiKey = Properties.getApiKey();
        this.apiURL = Properties.getApiURL();
        this.httpUtils = HttpUtils.getInstance();
    }

    public Volume search(String q, Download download, Filter filter, PrintType printType) {
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
        return this.httpUtils.get(this.apiURL + "volumes", params, Volume.class);
    }
}
