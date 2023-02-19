package gr.unipi.googlebooks.search.enums;

public enum Access {
    PUBLIC("PUBLIC"),
    PRIVATE("PRIVATE");

    private final String value;

    Access(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Access fromString(String value) {
        for (Access b : Access.values()) {
            if (b.value.equalsIgnoreCase(value)) {
                return b;
            }
        }
        return null;
    }
}
