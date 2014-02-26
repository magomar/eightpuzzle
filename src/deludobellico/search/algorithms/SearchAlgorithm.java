package deludobellico.search.algorithms;

import deludobellico.search.data.Node;
import deludobellico.search.data.State;

/**
 * Created by mario on 30/01/14.
 */
public interface SearchAlgorithm<T extends State> {
    Node<T> searchForSolution(T initialState, T goalState);
    int getNodesGenerated();
}
