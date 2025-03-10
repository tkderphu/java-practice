package framework.transaction;

import java.util.List;

public interface Repository<T, ID> {
    void save(T t);
    void delete(ID id);
    List<T> findAll();
    T findById(ID id);
}
