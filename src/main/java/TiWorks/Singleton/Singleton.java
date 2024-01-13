package TiWorks.Singleton;

public abstract class Singleton<T> {
    private static Object instance;

    protected Singleton() {
        // Prevent instantiation from outside the class
    }

    public static synchronized <T> T getInstance(Class<T> clazz) {
        if (instance == null) {
            try {
                instance = clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create an instance of " + clazz.getSimpleName(), e);
            }
        }

        return clazz.cast(instance);
    }
}
