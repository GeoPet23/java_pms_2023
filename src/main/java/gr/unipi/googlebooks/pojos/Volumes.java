
package gr.unipi.googlebooks.pojos;

import java.util.List;

public class Volumes {

    private String kind;
    private long totalItems;
    private List<Volume> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public List<Volume> getItems() {
        return items;
    }

    public void setItems(List<Volume> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SearchVolumes{" +
                "kind='" + kind + '\'' +
                ", totalItems=" + totalItems +
                ", items=" + items +
                '}';
    }
}
