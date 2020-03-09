package personal.game;

import java.util.ArrayDeque;
import java.util.Queue;

public class Logic {
    private final Unit[] map;
    private Queue<Integer> deadQueue;

    public Logic(Unit[] map) {
        this.map = map;
        deadQueue = new ArrayDeque<>(map.length);
    }

    public void act() {
        actAttackStage();
        removeCorpses();
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

    private void fight(int attackerPos, int victimPos) {
        Unit attacker = map[attackerPos];
        Unit victim = map[victimPos];

        victim.setHealth(victim.getHealth() - attacker.getStrength());

        if (victim.isDead()) {
            deadQueue.add(victimPos);
        }
    }
}
