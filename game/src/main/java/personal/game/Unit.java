package personal.game;

import lombok.Getter;
import lombok.Setter;

public abstract class Unit {
    @Getter
    private final int player;
    @Getter
    private final int range;
    @Getter
    private final int strength;
    @Getter
    @Setter
    private int health;

    public Unit(int player, int range, int strength, int health) {
        this.player = player;
        this.range = range;
        this.strength = strength;
        this.health = health;
    }


    public boolean isAlive() {
        return health > 0;
    }

    public boolean isDead() {
        return health <= 0;
    }
}
