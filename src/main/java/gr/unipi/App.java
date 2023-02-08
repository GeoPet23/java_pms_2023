package gr.unipi;

import gr.unipi.googlebooks.search.apis.PerformingSearch;
import gr.unipi.googlebooks.search.enums.Filter;

import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    PerformingSearch performingSearch = new PerformingSearch();
    System.out.println(performingSearch.search("flowers", null, Filter.fromString("free-ebooks"), null).getTotalItems());
  }
}
