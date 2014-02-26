package deludobellico.search.algorithms;

import deludobellico.search.data.Node;
import deludobellico.search.data.State;

import java.util.Collection;
import java.util.PriorityQueue;

/**
 * Created by mario on 30/01/14.
 General Tree Search Algorithm
 function treeSearch(problem, strategy)
 fringe = { new searchNode(problem.initialState) }
 loop
 if empty(fringe) then return failure
 node = selectFrom(fringe, strategy)
 if problem.goalTest(node.state) then
 return pathTo(node)
 fringe = fringe + expand(problem, node)
 */
public class AStarTreeSearch<T extends State> implements HeuristicSearchAlgorithm<T> {
    protected PriorityQueue<Node<T>> fringe;
    protected Heuristic<T> heuristic;
    protected int nodesGenerated;

    public AStarTreeSearch(Heuristic<T> heuristic) {
        this.heuristic = heuristic;

      }

    @Override
    public Node<T> searchForSolution(T initialState, T goalState) {
        nodesGenerated = 0;
        fringe = new PriorityQueue<>();
        Node<T> initialNode = new Node(initialState, 0, heuristic.getHeuristicValue(initialState, goalState), null);
        fringe.add(initialNode);
        while(!fringe.isEmpty()) {
            Node<T> currentNode = fringe.poll();
            if  (currentNode.getState().equals(goalState)) return currentNode;
            Collection<Node<T>> successors = currentNode.getSuccessors(goalState, heuristic);
            fringe.addAll(successors);
            nodesGenerated += successors.size();
        }
        return null;
    }

    @Override
    public int getNodesGenerated() {
        return nodesGenerated;
    }

    @Override
    public void setHeuristic(Heuristic<T> heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public Heuristic<T> getHeuristic() {
        return heuristic;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " with heuristic " + heuristic;
    }
}
