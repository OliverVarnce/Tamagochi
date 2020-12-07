package world.ucode.Hero;

public enum HeroAction {
    PLAY("Play"),
    FEED("Eat"),
    GIVE_WATER("Drink"),
    GIVE_MEDICINE("Medicine"),
    CLEAN_UP("Shower");

    private final String name;
    HeroAction(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}