package model.locations;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TopCitiesCount {
    FIFTY(50, "(0-50)"), HUNDRED(100,"(0-100)" ), HUNDRED_FIFTY(150, "(0-150)");

    private final int count;
    private final String range;

    public String getRange() {
        return range;
    }

    public int getCount() {
        return count;
    }
}
