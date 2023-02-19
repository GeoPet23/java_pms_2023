package gr.unipi.googlebooks.search.enums;

import gr.unipi.googlebooks.utils.HttpUtils;

public enum PrintType {
    ALL("all"),
    BOOKS("books"),
    MAGAZINES("magazines");

    private final String value;

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

    public static PrintType fromInt(int value) {
        try {
            return PrintType.values()[value];
        } catch (Exception e) {
            return null;
        }
    }
}
