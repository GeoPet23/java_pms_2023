
package gr.unipi.googlebooks.pojos;


public class SearchInfo {

    private String textSnippet;

    public String getTextSnippet() {
        return textSnippet;
    }

    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "textSnippet='" + textSnippet + '\'' +
                '}';
    }
}
