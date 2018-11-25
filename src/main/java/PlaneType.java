public enum PlaneType {
    BOEING737(162, "United Kingdom"),
    AIRBUSA320(180, "United Kingdom"),
    BOEING787(242, "Europe"),
    BOEING777(314, "Europe"),
    AIRBUSA340(350, "Europe"),
    BOEING747(416, "USA"),
    AIRBUSA380(853, "South America");

    private final int capacity;
    private final String continent;

    PlaneType(int capacity, String continent) {
        this.capacity = capacity;
        this.continent = continent;

    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getContinent(){
        return this.continent;
    }
}
