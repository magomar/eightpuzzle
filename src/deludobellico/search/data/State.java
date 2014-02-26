package deludobellico.search.data;

import java.util.Collection;

/**
 * Created by mario on 30/01/14.
 */
public interface State<T extends Action> {
    Collection<T> getApplicableActions();

    Collection<? extends State> getSuccessors();

}
