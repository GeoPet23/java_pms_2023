
package gr.unipi.googlebooks.pojos;


public class ReadingModes {

    private boolean text;
    private boolean image;

    public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ReadingModes{" +
                "text=" + text +
                ", image=" + image +
                '}';
    }
}
