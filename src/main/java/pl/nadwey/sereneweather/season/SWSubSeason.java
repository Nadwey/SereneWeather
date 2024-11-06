package pl.nadwey.sereneweather.season;

import pl.nadwey.sereneweather.util.Color;
import sereneseasons.api.season.Season.SubSeason;

import java.util.Arrays;

public enum SWSubSeason {
    EARLY_SPRING(SubSeason.EARLY_SPRING, new Color(255, 255, 255), new Color(255, 255, 255)),
    MID_SPRING(SubSeason.MID_SPRING),
    LATE_SPRING(SubSeason.LATE_SPRING),
    EARLY_SUMMER(SubSeason.EARLY_SUMMER),
    MID_SUMMER(SubSeason.MID_SUMMER),
    LATE_SUMMER(SubSeason.LATE_SUMMER),
    EARLY_AUTUMN(SubSeason.EARLY_AUTUMN),
    MID_AUTUMN(SubSeason.MID_AUTUMN),
    LATE_AUTUMN(SubSeason.LATE_AUTUMN),
    EARLY_WINTER(SubSeason.EARLY_WINTER),
    MID_WINTER(SubSeason.MID_WINTER),
    LATE_WINTER(SubSeason.LATE_WINTER);

    private final SubSeason originalSubSeason;
    private final Color foliageColor;
    private final Color grassColor;

    SWSubSeason(SubSeason originalSubSeason, Color foliageColor, Color grassColor) {
        this.originalSubSeason = originalSubSeason;
        this.foliageColor = foliageColor;
        this.grassColor = grassColor;
    }

    SWSubSeason(SubSeason originalSubSeason) {
        this.originalSubSeason = originalSubSeason;
        this.foliageColor = new Color(0, 0, 0);
        this.grassColor = new Color(0, 0, 0);
    }

    public SubSeason getOriginalSubSeason() {
        return originalSubSeason;
    }

    public Color getFoliageColor() {
        return foliageColor;
    }

    public Color getGrassColor() {
        return grassColor;
    }

    public static SWSubSeason getByOriginalSubSeason(SubSeason originalSubSeason) {
        for (SWSubSeason subSeason : SWSubSeason.values()) {
            if (subSeason.getOriginalSubSeason().equals(originalSubSeason)) {
                return subSeason;
            }
        }

        throw new IllegalArgumentException("No such subseason: " + originalSubSeason);
    }
}
