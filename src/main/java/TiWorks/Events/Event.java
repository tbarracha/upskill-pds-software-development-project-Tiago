package TiWorks.Events;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tiago Barracha ti.barracha@gmail.com
 *
 * @Usage Events are used to broadcast data without direct instance reference. For example:
 * @Example TODO: insert example
 */
public class Event {
    private final Set<EventListener> listeners = new HashSet<>();

    public void invoke() {
        for (EventListener listener : listeners) {
            listener.eventFired();
        }
    }

    public void invokeParams(Object... params) {
        for (EventListener listener : listeners) {
            listener.eventFiredParams(params);
        }
    }

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void clearAllListeners() {
        listeners.clear();
    }

    public static <T> List<T> getObjectTypesFromParams(Object[] paramArray, Class<T> classType) {
        ArrayList<T> result = new ArrayList<>();

        for (Object obj : paramArray) {
            if (classType.isInstance(obj)) {
                result.add(classType.cast(obj));
            }
        }

        return result;
    }
}

