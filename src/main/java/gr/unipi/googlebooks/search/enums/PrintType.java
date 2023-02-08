package gr.unipi.googlebooks.search.enums;

public enum PrintType {
    ALL("all"),
    BOOKS("books"),
    MAGAZINES("magazines");

    private String value;

    PrintType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static PrintType fromString(String value) {
        for (PrintType b : PrintType.values()) {
            if (b.value.equalsIgnoreCase(value)) {
                return b;
            }
        }
        return null;
    }
}
