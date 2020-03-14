package personal.game;

public class Preparer {
    private Preparer() {}

    public static Logic prepareGame() {
        int leftPlayer = 1;
        int rightPlayer = 2;
        int health = 100;

        Base leftBase = new Base(Base.Side.LEFT, leftPlayer, health);
        Base rightBase = new Base(Base.Side.RIGHT, rightPlayer, health);
        int sizeMap = 12;

        return new Logic(leftBase, rightBase, sizeMap);
    }
}
