package deludobellico.search.data;

import deludobellico.search.algorithms.SearchAlgorithm;
import deludobellico.task.Task;

/**
 * Created by mario on 31/01/14.
 */
public class SingleSearchTask<T extends State> implements Task {
    private T initialState;
    private T goalState;
    private Node<T> solution;
    private SearchAlgorithm algorithm;

    public SingleSearchTask(T initialState, T goalState, SearchAlgorithm algorithm) {
        this.initialState = initialState;
        this.goalState = goalState;
        this.algorithm = algorithm;
    }

    @Override
    public void run() {
        System.out.println("\nExecuting Single Search Task");
        System.out.println("==============================");
        System.out.println("  Initial state: " + initialState);
        System.out.println("  Goal state: " + goalState);
        System.out.println("  Algorithm: " + algorithm);
        solution = algorithm.searchForSolution(initialState, goalState);
        if (solution != null) {
            System.out.println("  Solution found: " +solution);
        } else {
            System.out.println("  No solution found !");
        }
        System.out.println("  Nodes generated: " + algorithm.getNodesGenerated());
    }

}
