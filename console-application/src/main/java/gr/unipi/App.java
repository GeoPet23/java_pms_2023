package gr.unipi;

import gr.unipi.entities.Search;
import gr.unipi.googlebooks.pojos.Bookshelf;
import gr.unipi.googlebooks.pojos.Bookshelves;
import gr.unipi.googlebooks.pojos.Volumes;
import gr.unipi.googlebooks.search.apis.GoogleAPI;
import gr.unipi.googlebooks.search.enums.Download;
import gr.unipi.googlebooks.search.enums.Filter;
import gr.unipi.googlebooks.search.enums.PrintType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Search> searches = new ArrayList<>();
        /*
         * Exit when user gives any key except of 1-5
         * */
        while (true) {
            System.out.println("------------ Menu ------------");
            System.out.println("Menu");
            System.out.println("1. Perform a Volume Search in Google Book API.");
            System.out.println("2. Display my last 5 searches.");
            System.out.println("3. Display results from your last search.");
            System.out.println("4. Display the bookshelf of user with id 102701940585560677579.");
            System.out.println("5. Display the volumes of each bookshelf of user with id 102701940585560677579.");
            System.out.print("Choose an item below by typing the specific number. Any other key for exit: ");
            int choice = parseAnOption(sc.next());
            /*
             * Perform a search by giving terms, download, filter and Print Type
             * */
            if (choice == 1) {
                System.out.print("Provide terms for your search e.g. blue flowers: ");
                String q = sc.next();
                System.out.print("Do you want to get only epub? Press (y) for yes or any key for no: ");
                String key = sc.next();
                Download download = null;
                if (key.equals("y")) {
                    download = Download.EPUB;
                }
                System.out.println("Filter by type and availability. Choose one of the following:");
                System.out.println("1. Partial");
                System.out.println("2. Full");
                System.out.println("3. Free ebooks");
                System.out.println("4. Paid ebooks");
                System.out.println("5. ebooks");
                System.out.println("Any key for none");
                System.out.print("Type the number of your choice:  ");
                Filter filter = Filter.fromInt(parseAnOption(sc.next()) - 1);
                System.out.println("Choose one of the following print types:");
                System.out.println("1. All");
                System.out.println("2. books");
                System.out.println("3. magazines");
                System.out.println("Any key for none");
                System.out.print("Type the number of your choice:  ");
                PrintType printType = PrintType.fromInt(parseAnOption(sc.next()) - 1);
                searches.add(new Search(q, download, filter, printType));
                if (searches.size() > 5) {
                    searches.remove(0);
                }
                /*
                 * Print last 5 searches metadata
                 * */
            } else if (choice == 2) {
                if (searches.size() == 0) {
                    System.out.println("You have not perform any search yet.");
                } else {
                    int j = 0;
                    for (int i = searches.size() - 1; i >= 0; i--) {
                        j++;
                        Search search = searches.get(i);
                        System.out.print(j + ": Terms: " + search.getQ());
                        if (search.getDownload() != null) {
                            System.out.print(", Download: " + search.getDownload());
                        }
                        if (search.getFilter() != null) {
                            System.out.print(", Filter: " + search.getFilter());
                        }
                        if (search.getPrintType() != null) {
                            System.out.print(", Print Type: " + search.getPrintType());
                        }
                        System.out.println();
                    }
                }
                /*
                 * Print all volumes from the latest search
                 *
                 * */
            } else if (choice == 3) {
                if (searches.size() == 0) {
                    System.out.println("You have not perform any search yet.");
                } else {
                    Volumes volumes = searches.get(searches.size() - 1).getVolumes();
                    volumes.getItems().forEach(System.out::println);
                }
                /*
                * Get bookshelves of user with userId = 102701940585560677579
                * */
            } else if (choice == 4) {
                Bookshelves bookshelves = GoogleAPI.getInstance().getBookshelves("102701940585560677579");
                if(bookshelves.getItems().size() == 0) {
                    System.out.println("User has not any bookshelf.");
                } else {
                    bookshelves.getItems().forEach(System.out::println);
                }
                /*
                 * Get bookshelves of user with userId = 102701940585560677579 and the get all volumes for each bookshelf
                 * */
            } else if (choice == 5) {
                Bookshelves bookshelves = GoogleAPI.getInstance().getBookshelves("102701940585560677579");
                if(bookshelves.getItems().size() == 0) {
                    System.out.println("User has not any bookshelf.");
                } else {
                    bookshelves.getItems().forEach(item -> {
                        try {
                            Volumes volumes = GoogleAPI.getInstance().getVolumesOfBookshelf("102701940585560677579", item.getId());
                            volumes.getItems().forEach(System.out::println);
                        } catch (IOException e) {
                            System.out.println("Something went wrong during this action.");
                        }
                    });
                }
            } else {
                break;
            }
        }

    }

    /**
     * Handle an invalid user input, in order to be sure that the input will be a number.
     * */
    public static int parseAnOption(String value) {
        int option;
        try {
            option = Integer.parseInt(value);
        } catch (Exception e) {
            option = -1;
        }
        return option;
    }
}
