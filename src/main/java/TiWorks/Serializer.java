package TiWorks;

import java.io.*;

/**
 * @author Tiago Barracha ti.barracha@gmail.com
 *
 * @Usage Serialize and Deserialize classes that implement the Serializable interface to and from binary
 * @Example TODO: insert example
 */
public final class Serializer {
    public static <T> void serialize(T object, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(object);
            System.out.println("Objeto serializado com sucesso.");
        } catch (IOException e) {
            System.out.println(String.format("Erro ao serializar o objeto:\n%s", e.getMessage()));
        }
    }

    public static <T>T deserialize(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            T object = (T) inputStream.readObject();
            System.out.println("Objeto desserializado com sucesso.");
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(String.format("Erro ao desserializar o objeto:\n%s", e.getMessage()));
            return null;
        }
    }

    public static <T> T deserialize(String fileName, Class<T> targetClass) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            T object = (T) inputStream.readObject();
            System.out.println("Object deserialized successfully.");
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(String.format("Error deserializing object: \n%s", e.getMessage()));
            try {
                // Attempt to create a new instance using reflection
                return targetClass.getDeclaredConstructor().newInstance();
            } catch (Exception ex) {
                System.out.println(String.format("Error creating a new instance: \n%s", ex.getMessage()));
                return null;
            }
        }
    }
}
