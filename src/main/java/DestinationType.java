public enum DestinationType {
    FRANCE("Europe"),
    ITALY("Europe"),
    LONDON("United Kingdom"),
    NEWYORK("USA"),
    TORONTO("Canada"),
    PERU("South America");

    private final String continent;

    DestinationType(String continent) {
        this.continent = continent;

    }

    public String getContinent() {
        return this.continent;
    }
}
