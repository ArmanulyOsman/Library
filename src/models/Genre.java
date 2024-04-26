package models;

public enum Genre {
    FANTASY("Фантастика"),
    DETECTIVE("Детектив"),
    BIOGRAPHY("Биография"),
    LITERATURE("Литература"),
    HORROR("Хоррор");
    private String description;

    public String getDescription() {
        return description;
    }

    Genre(String description) {
        this.description = description;
    }
}
