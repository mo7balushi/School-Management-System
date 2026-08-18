package interfaces;

import java.util.List;

public interface Manageable<T> {

    void add(T entity);

    boolean remove(String id);

    List<T> getAll();
}