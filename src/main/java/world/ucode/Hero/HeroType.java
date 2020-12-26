package world.ucode.Hero;

public enum HeroType {
    DOG("Dog"),
    MONKEY("Monkey");

    private final String name;
    HeroType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}