package gr.unipi.googlebooks.search.enums;

public enum Filter {
    PARTIAL("partial"),
    FULL("full"),
    FREE_EBOOKS("free-ebooks"),
    PAID_EBOOKS("paid-ebooks"),
    EBOOKS("ebooks");

    private final String value;

    Filter(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Filter fromString(String value) {
        for (Filter b : Filter.values()) {
            if (b.value.equalsIgnoreCase(value)) {
                return b;
            }
        }
        return null;
    }

    public static Filter fromInt(int value) {
        try {
            return Filter.values()[value];
        } catch (Exception e) {
            return null;
        }
    }
}
