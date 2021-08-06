package ua.com.alevel.level3;

public enum Status {

    NONE,
    LIVE,
    DEAD,
    BORN;

    public Status createLiveOrMakeDead(int around) {
        switch (this) {
            case NONE:
                return (around == 3) ? BORN : NONE;
            case LIVE:
                return (around <= 1 || around >= 4) ? DEAD : LIVE;
            default:
                return this;
        }
    }

    public Status changeBornToLiveAndDeadToNone() {
        switch (this) {
            case BORN:
                return LIVE;
            case DEAD:
                return NONE;
            default:
                return this;
        }
    }

    public boolean isCell() {
        return this == LIVE || this == DEAD;
    }
}
