package personal.game;

import lombok.Getter;

public class Base {
    public enum Side {
        LEFT, RIGHT
    }


    @Getter
    private final Side side;
    @Getter
    private final int player;
    @Getter
    private final int health;


    public Base(Side side, int player, int health) {
        this.side = side;
        this.player = player;
        this.health = health;
    }
}
