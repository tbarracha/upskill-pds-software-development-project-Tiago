package TiWorks.Events;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tiago Barracha ti.barracha@gmail.com
 *
 * @Usage Similar to Events, EventTyped are used to broadcast typed data without direct instance reference.
 * @Example TODO: insert example
 */
public class EventTyped<T> extends Event {
    private final Set<EventListenerTyped<T>> listenersTyped = new HashSet<>();

    public void addListener(EventListenerTyped<T> listener) {
        listenersTyped.add(listener);
    }

    public void removeListener(EventListenerTyped<T> listener) {
        listenersTyped.remove(listener);
    }

    @Override
    public void clearAllListeners() {
        listenersTyped.clear();
    }

    public void invoke(T typedParam) {
        for (EventListenerTyped<T> listener : listenersTyped) {
            listener.eventFired(typedParam);
        }
    }
}
