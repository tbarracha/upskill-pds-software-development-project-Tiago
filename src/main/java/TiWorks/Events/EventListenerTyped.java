package TiWorks.Events;

/**
 * @author Tiago Barracha ti.barracha@gmail.com
 *
 * @Usage Similar to EventListeners, EventListenerTyped are used to recieve Event broadcasts with a typed parameter.
 * @Example TODO: insert example
 */
public interface EventListenerTyped<T> extends EventListener {
    void eventFired(T obj);
}
