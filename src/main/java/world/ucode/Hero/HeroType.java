package world.ucode.Hero;

public enum HeroType {
    STUART("Stuart"),
    KEVIN("Kevin"),
    BOB("Bob");

    private final String name;
    HeroType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}