package deludobellico.search.algorithms;

import deludobellico.search.data.Node;
import deludobellico.search.data.State;

import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by mario on 1/02/14.
 */
public class AStarGraphSearch<T extends State> extends AStarTreeSearch<T> {
    protected Set<Node<T>> visitedNodes;

    public AStarGraphSearch(Heuristic<T> heuristic) {
        super(heuristic);
    }

    @Override
    public Node<T> searchForSolution(T initialState, T goalState) {
        nodesGenerated = 0;
        fringe = new PriorityQueue<>();
        visitedNodes = new HashSet<>();

        Node<T> initialNode = new Node(initialState, 0, heuristic.getHeuristicValue(initialState, goalState), null);
        fringe.add(initialNode);
        while(!fringe.isEmpty()) {
            Node<T> currentNode = fringe.poll();
            if  (currentNode.getState().equals(goalState)) {
                nodesGenerated = visitedNodes.size();
                return currentNode;
            }
            Collection<Node<T>> successors = currentNode.getSuccessors(goalState, heuristic);
            for (Node<T> successor : successors) {
                if (!visitedNodes.contains(successor)) {
                    fringe.add(successor);
                    visitedNodes.add(successor);
                }
            }
        }
        nodesGenerated = visitedNodes.size();
        return null;
    }
}
