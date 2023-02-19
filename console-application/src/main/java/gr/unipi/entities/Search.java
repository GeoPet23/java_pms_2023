package gr.unipi.entities;

import gr.unipi.googlebooks.pojos.Volumes;
import gr.unipi.googlebooks.search.apis.GoogleAPI;
import gr.unipi.googlebooks.search.enums.Download;
import gr.unipi.googlebooks.search.enums.Filter;
import gr.unipi.googlebooks.search.enums.PrintType;

import java.io.IOException;

public class Search {
    private String q;
    private Download download;
    private Filter filter;
    private PrintType printType;
    private Volumes volumes;

    public Search(String q, Download download, Filter filter, PrintType printType) throws IOException {
        this.q = q;
        this.download = download;
        this.filter = filter;
        this.printType = printType;
        this.volumes = GoogleAPI.getInstance().searchVolumes(q, download, filter, printType);
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Download getDownload() {
        return download;
    }

    public void setDownload(Download download) {
        this.download = download;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public PrintType getPrintType() {
        return printType;
    }

    public void setPrintType(PrintType printType) {
        this.printType = printType;
    }

    public Volumes getVolumes() {
        return volumes;
    }

    public void setVolumes(Volumes volumes) {
        this.volumes = volumes;
    }
}
