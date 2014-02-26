package deludobellico.search.algorithms;

import deludobellico.search.data.State;

/**
 * Created by mario on 31/01/14.
 */
public interface HeuristicSearchAlgorithm<T extends State> extends SearchAlgorithm<T> {
    void setHeuristic(Heuristic<T> heuristic);
    Heuristic<T> getHeuristic();
}
