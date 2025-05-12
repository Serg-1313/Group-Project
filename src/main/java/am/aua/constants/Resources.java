package am.aua.constants;

public enum Resources {
    LUMBER,
    GRAIN,
    BRICK,
    WOOL,
    ORE;

    @Override
    public String toString() {
        String name = name().toLowerCase();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
