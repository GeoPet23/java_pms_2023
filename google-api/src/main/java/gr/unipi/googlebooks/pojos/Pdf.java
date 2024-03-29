
package gr.unipi.googlebooks.pojos;


public class Pdf {

    private boolean isAvailable;
    private String acsTokenLink;
    private String downloadLink;

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }


    @Override
    public String toString() {
        return "Pdf{" +
                "isAvailable=" + isAvailable +
                ", acsTokenLink='" + acsTokenLink + '\'' +
                ", downloadLink='" + downloadLink + '\'' +
                '}';
    }
}
