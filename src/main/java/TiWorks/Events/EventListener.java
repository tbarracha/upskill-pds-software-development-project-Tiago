package TiWorks.Events;

/**
 * @author Tiago Barracha ti.barracha@gmail.com
 *
 * @Usage EventListeners are used to recieve Event broadcasts
 * @Example TODO: insert example
 */
public interface EventListener {
    void eventFired();
    void eventFiredParams(Object... params);
}

