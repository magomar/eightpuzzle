package deludobellico.eightpuzzle;


import deludobellico.search.algorithms.Heuristic;

/**
 * Created by mario on 30/01/14.
 */
public enum EightPuzzleHeuristic implements Heuristic<EightPuzzleState> {
    HAMMINGS_DISTANCE {
        @Override
        public double getHeuristicValue(EightPuzzleState currentState, EightPuzzleState goalState) {
            int[][] puzzle = currentState.getPuzzle();
            int[][] goalPuzzle = goalState.getPuzzle();
            int distance = 0;
            for (int i = 0; i < 3; i++) {
                int[] puzzleRow = puzzle[i];
                int[] goalRow = goalPuzzle[i];
                for (int j = 0; j < 3; j++) {
                    if (puzzleRow[j] != goalRow[j]) distance++;
                }
            }
            return distance;
        }
    },
    MANHATTAN_DISTANCE {
        @Override
        public double getHeuristicValue(EightPuzzleState currentState, EightPuzzleState goalState) {
            int[][] puzzle = currentState.getPuzzle();
            int[][] goalPuzzle = goalState.getPuzzle();
            ManhattanDistanceProvider manhattanDistanceProvider = ManhattanDistanceProvider.getManhattanDistanceProvider(goalState);
            int[] targetX = manhattanDistanceProvider.getX();
            int[] targetY = manhattanDistanceProvider.getY();
            int distance = 0;
            for (int i = 0; i < 3; i++) {
                int[] puzzleRow = puzzle[i];
                for (int j = 0; j < 3; j++) {
                    int value = puzzleRow[j];
                    if (value != 0) {
                    // The commented solution is only useful for the typical goal state: 0 1 2 3 4 5 6 7 8
//                        int targetX = (value - 1) / 3; // expected x-coordinate (row)
//                        int targetY = (value - 1) % 3; // expected y-coordinate (col)
//                        int dx = i - targetX; // x-distance to expected coordinate
//                        int dy = j - targetY; // y-distance to expected coordinate
                        int dx = i - targetX[value];
                        int dy = j - targetY[value];
                        distance += Math.abs(dx) + Math.abs(dy);
                    }
                }
            }
            return distance;
        }
    },
    BREADTH_FIRST {
        @Override
        public double getHeuristicValue(EightPuzzleState currentState, EightPuzzleState goalState) {
            return 0;
        }
    }

}
