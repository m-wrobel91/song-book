package pl.mwrobel91.songbook.enums;

public enum Category {

    PRZERYWNIKI_KRAKOWSKIE("Przerywniki krakowskie"),
    PRZERYWNIKI_SLASKIE("Przerywniki śląskie"),
    SUITA_KRAKOWIAK("Krakowiak");

    private final String category;

    Category(final String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
