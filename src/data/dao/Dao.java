package data.dao;

import java.util.List;

/**
 * Created by cesar on 20/09/16.
 */
public interface Dao<T> {
    <V> int create(T t);
    T read(int id);
    List<T> readAll();
    int update(int index, T t);
    int delete(int index);
}
