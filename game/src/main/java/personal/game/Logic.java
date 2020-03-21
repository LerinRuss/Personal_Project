package personal.game;

import personal.game.exception.GameException;

import java.util.ArrayDeque;
import java.util.Queue;

public class Logic {
    private final Unit[] map;
    private final Base leftBase;
    private final Base rightBase;
    private Queue<Integer> deadQueue;


    public Logic(Base leftBase, Base rightBase, int sizeMap) {
        if (sizeMap % 2 != 0) {
            throw new GameException("Map size should be even.");
        }

        this.map = new Unit[sizeMap];
        deadQueue = new ArrayDeque<>(sizeMap);
        this.leftBase = leftBase;
        this.rightBase = rightBase;
    }


    public void act() {
        actAttackStage();
        removeCorpses();
        actMoveStage();
    }

    private void actAttackStage() {
        for (int i = 0; i < map.length; i++) {
            if (map[i] == null) {
                continue;
            }

            int enemy = findClosestEnemy(i);
            if (enemy == -1) {
                continue;
            }

            if (enemy - i <= map[i].getRange()) {
                fight(i, enemy);
            }
        }
    }

    private void actMoveStage() {
        int leftPos = findLastUnit(leftBase);
        int rightPos = findLastUnit(rightBase);

        if (rightPos - leftPos == 2) {
            if (Math.random() < 0.5) {
                move(leftPos, leftPos + 1);
            } else {
                move(rightPos, rightPos - 1);
            }

            fight(leftPos, rightPos);
            fight(rightPos, leftPos);
            removeCorpses();
        }

        for (int left = leftPos - 1; left >= 0; left--) {
            move(left, left + 1);
        }

        for (int right = rightPos + 1; right < map.length; right++) {
            move(right, right - 1);
        }
    }

    private void move(int oldPos, int newPos) {
        //See 1) rule
        if (map[newPos] != null || newPos == 0 || newPos == map.length - 1){
            return;
        }
        map[newPos] = map[oldPos];
        map[oldPos] = null;
    }

    private void removeCorpses() {
        Integer index;
        while((index = deadQueue.poll()) != null) {
            map[index] = null;
        }
    }

    private int findClosestEnemy(int pos) {
        int player = map[pos].getPlayer();

        for (int left = pos - 1, right = pos + 1;
             left >= 0 || right < map.length;
             left--, right++) {

            if(left >= 0 && map[left] != null && map[left].getPlayer() != player && map[left].isAlive()) {
                return left;
            }

            if(right < map.length && map[right] != null && map[right].getPlayer() != player && map[right].isAlive()) {
                return right;
            }
        }

        return -1;
    }

    private int findLastUnit(Base base) {
        int pos = -1;
        for (int i = 0; base.getSide() == Base.Side.LEFT && i < map.length; i++) {
            if(map[i].getPlayer() == base.getPlayer()) {
                pos = i;
            }
        }

        for (int i = map.length - 1; base.getSide() == Base.Side.RIGHT && i > 0; i--) {
            if(map[i].getPlayer() == base.getPlayer()) {
                pos = i;
            }
        }

        return pos;
    }

    private void fight(int attackerPos, int victimPos) {
        Unit attacker = map[attackerPos];
        Unit victim = map[victimPos];

        victim.setHealth(victim.getHealth() - attacker.getStrength());

        if (victim.isDead()) {
            deadQueue.add(victimPos);
        }
    }
}
