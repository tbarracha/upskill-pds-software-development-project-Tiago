package pt.org.upskill.repository;

public interface Persistable<T> {
    boolean save(T object);
    boolean delete(T object);
    //void load(String filePath);
}
