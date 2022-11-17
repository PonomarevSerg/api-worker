package model.locations;

public enum TopCitiesCount {
    FIFTY(50), HUNDRED(100), HUNDRED_FIFTY(150);

    private final int count;

    TopCitiesCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
