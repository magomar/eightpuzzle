package deludobellico.search.data;

/**
 * Created by mario on 30/01/14.
 */
public interface Action<T extends State> {
    T execute(T state);
}
