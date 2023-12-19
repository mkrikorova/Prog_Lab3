package shorty;

public enum Characteristic {
    SHAPELESS ("бесформенный"),
    TORN ("изорванный"),
    SOMEONE("чей-то");

    private final String title;

    Characteristic(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
