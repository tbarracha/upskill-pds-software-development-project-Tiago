package TiWorks.Singleton;

/**
 * @author Tiago Barracha ti.barracha@gmail.com
 *
 * @Usage Interface for Singleton instances that forces the getInstance() method, so that they can be fetched from the static Singletons
 * @Example TODO: insert example
 */
public interface ISingleton<T> {
    /**
     * Apply: return Singletons.getInstance(T.class);
     * @return
     */
    T getInstance();
}
