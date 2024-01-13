package TiWorks.Singleton;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Constructor;

/**
 * The {@code Singletons<T>} class is a utility for managing singleton instances of various types.
 * It uses a map to store instances and reflection to instantiate objects. Additionally, it allows
 * for the registration of externally created instances. This class facilitates the singleton
 * management of any class, including those with parameterized constructors and pre-instantiated objects.
 *
 * Usage example:
 * <pre>{@code
 * // For a class with a parameterized constructor
 * MyClass myClassSingleton = Singletons.getInstance(MyClass.class, arg1, arg2, ...);
 *
 * // For a class with a no-argument constructor
 * MyClass myClassSingletonNoArgs = Singletons.getInstance(MyClass.class);
 *
 * // Registering and retrieving an externally created instance
 * MyClass myClassInstance = new MyClass(arg1, arg2, ...);
 * Singletons.registerInstance(MyClass.class, myClassInstance);
 * MyClass retrievedInstance = Singletons.getInstance(MyClass.class);
 * }</pre>
 *
 * Note: This implementation uses reflection and should be used with caution.
 * It assumes that each class type provided has a matching constructor for the given arguments.
 * Private constructors are made accessible, which can break encapsulation principles.
 *
 * @author Tiago Barracha (with some ChatGPT help) ti.barracha@gmail.com
 */
public class Singletons {
    private static final Map<Class<?>, Object> instances = new HashMap<>();

    public static synchronized <T> T getInstance(Class<T> clazz, Object... args) {
        try {
            if (!instances.containsKey(clazz)) {
                Constructor<T> constructor = clazz.getDeclaredConstructor(getClasses(args));
                constructor.setAccessible(true);

                T instance = constructor.newInstance(args);
                instances.put(clazz, instance);
            }

            return clazz.cast(instances.get(clazz));
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while creating a singleton instance", e);
        }
    }

    public static synchronized <T> T getInstance(Class<T> clazz) {
        return getInstance(clazz, new Object[0]);
    }

    public static synchronized <T> void registerInstance(Class<T> clazz, T instance) {
        if (!instances.containsKey(clazz)) {
            instances.put(clazz, instance);
        }
    }

    private static Class<?>[] getClasses(Object... args) {
        return java.util.Arrays.stream(args)
                .map(Object::getClass)
                .toArray(Class<?>[]::new);
    }
}
