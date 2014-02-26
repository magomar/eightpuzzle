package deludobellico.search.algorithms;

import deludobellico.search.data.Node;
import deludobellico.search.data.State;

import java.util.*;

/**
 * Created by mario on 2/02/14.
 */
public class ExpandStateSpace<T extends State>  {
    private Queue<Node<T>> fringe;
    private int nodesGenerated;
    private Set<Node<T>> visitedNodes;
    private int maxDepthReached;
    private int[] nodesGeneratedPerDepth;

    public int expandSearchSpace(T initialState, int maxDepth) {
        nodesGenerated = 0;
        fringe = new LinkedList<>();
        visitedNodes = new HashSet<>();
        maxDepthReached = 0;
        nodesGeneratedPerDepth = new int[maxDepth+1];
        for (int i = 0; i < nodesGeneratedPerDepth.length; i++) {
            nodesGeneratedPerDepth[i] = 0;
        }
        Node<T> initialNode = new Node(initialState, 0, 0, null);
        fringe.add(initialNode);
        while (!fringe.isEmpty()) {
            Node<T> currentNode = fringe.poll();
            int currentDepth = currentNode.getDepth();
            nodesGeneratedPerDepth[currentDepth]++;
            if (currentDepth < maxDepth) {
                Collection<Node<T>> successors = currentNode.getSuccessors();
                for (Node<T> successor : successors) {
                    if (!visitedNodes.contains(successor)) {
                        fringe.add(successor);
                        visitedNodes.add(successor);
                    }
                }
            }
        }
        nodesGenerated = visitedNodes.size();
        maxDepthReached = 0;
        for (int i = 1; i < nodesGeneratedPerDepth.length; i++) {
            if (nodesGeneratedPerDepth[i] != 0)  maxDepthReached =i;
        }
        return nodesGenerated;
    }

    public int getMaxDepthReached() {
        return maxDepthReached;
    }

    public int[] getNodesGeneratedPerDepth() {
        return nodesGeneratedPerDepth;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
