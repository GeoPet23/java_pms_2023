package gr.unipi;

import gr.unipi.googlebooks.search.apis.GoogleAPI;
import gr.unipi.googlebooks.search.enums.Filter;

import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    GoogleAPI googleAPI = new GoogleAPI();
    System.out.println(googleAPI.searchVolumes("flowers", null, Filter.fromString("free-ebooks"), null).getItems());
    System.out.println(googleAPI.getVolume("mVMDAAAAQAAJ"));
    System.out.println(googleAPI.getBookshelves("102701940585560677579"));
    System.out.println(googleAPI.getBookshelf("102701940585560677579", 1001));
    System.out.println(googleAPI.getVolumesOfBookshelf("102701940585560677579", 1001));
  }
}
