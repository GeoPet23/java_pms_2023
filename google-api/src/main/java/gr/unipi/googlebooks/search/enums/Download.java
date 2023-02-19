package gr.unipi.googlebooks.search.enums;

public enum Download {
    EPUB("epub");

    private final String value;

    Download(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Download fromString(String value) {
        for (Download b : Download.values()) {
            if (b.value.equalsIgnoreCase(value)) {
                return b;
            }
        }
        return null;
    }
}
