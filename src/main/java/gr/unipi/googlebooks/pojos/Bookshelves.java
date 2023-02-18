package gr.unipi.googlebooks.pojos;

import java.util.List;

public class Bookshelves {
    private String kind;
    private List<Bookshelf> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Bookshelf> getItems() {
        return items;
    }

    public void setItems(List<Bookshelf> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SearchBookshelves{" +
                "kind='" + kind + '\'' +
                ", items=" + items +
                '}';
    }
}
