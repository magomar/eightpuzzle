package deludobellico.eightpuzzle;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mario on 1/02/14.
 */
public class ManhattanDistanceProvider {
    private int[] x = new int[9];
    private int[] y = new int[9];
    private static Map<EightPuzzleState, ManhattanDistanceProvider> cache = new HashMap<>();

    public static ManhattanDistanceProvider getManhattanDistanceProvider(EightPuzzleState goalState) {
        if (cache.containsKey(goalState)) return cache.get(goalState);
        else {
            ManhattanDistanceProvider manhattanDistanceProvider = new ManhattanDistanceProvider(goalState);
            cache.put(goalState, manhattanDistanceProvider);
            return manhattanDistanceProvider;
        }
    }


    private ManhattanDistanceProvider(EightPuzzleState goalState) {
        int[][] puzzle = goalState.getPuzzle();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = puzzle[i][j];
                x[value] = i;
                y[value] = j;
            }
        }
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }
}
