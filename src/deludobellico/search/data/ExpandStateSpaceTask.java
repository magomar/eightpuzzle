package deludobellico.search.data;

import deludobellico.search.algorithms.ExpandStateSpace;
import deludobellico.task.Task;

/**
 * Created by mario on 3/02/14.
 */
public class ExpandStateSpaceTask<T extends State> implements Task {
    private ExpandStateSpace<T> algorithm;
    private T initialState;
    private int maxDepth;

    public ExpandStateSpaceTask(T initialState, int maxDepth, ExpandStateSpace<T> algorithm) {
        this.initialState = initialState;
        this.maxDepth = maxDepth;
        this.algorithm = algorithm;
    }

    @Override
    public void run() {
        System.out.println("\nExecuting Single Search Task");
        System.out.println("==============================");
        System.out.println("  Initial state: " + initialState);
        System.out.println("  Max depth: " + maxDepth);
        System.out.println("  Algorithm: " + algorithm);
        int nodesGenerate = algorithm.expandSearchSpace(initialState, maxDepth);
        int depthReached = algorithm.getMaxDepthReached();
        int[] nodesGeneratedPerDepth = algorithm.getNodesGeneratedPerDepth();
        System.out.println("  Total Nodes generated: " + nodesGenerate);
        System.out.println("  Depth reached: " + depthReached);
        System.out.println("  Nodes at depth " + depthReached + ": " + nodesGeneratedPerDepth[maxDepth]);
    }
}