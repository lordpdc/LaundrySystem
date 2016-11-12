package data.dao;

import data.db.Row;
import data.db.Table;
import data.db.Tuple;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesar on 04/10/16.
 */
public class GenericDao<T> implements Dao<T> {
    private String className;
    private Table table;

    public GenericDao(String className, String tableName){
        this.className = className;
        table = new Table(tableName);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <V> int create(T t) {
        List<Tuple> tuples = new ArrayList<>();
        Class<?> clazz = t.getClass();
        for(Field field : getAllFields(t)){
            field.setAccessible(true);
            try {
                tuples.add(new Tuple<V>(field.getName(),(V)field.get(t)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return table.addRow(tuples);
    }

    @Override
    public T read(int id) {
        Class<?> clazz = null;
        try {
            clazz = clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        T entity = null;
        try {
            assert clazz != null;
            entity = (T)clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Row row = table.getRow(id);
        for (Tuple tup : row.getRow()) {
            setField(entity,tup.getKey(),tup.getValue());
        }
        return entity;
    }

    @Override
    public List<T> readAll() {
        List<Row> rows = table.getAllRows();
        List<T> entities = new ArrayList<>();

        for (Row row : rows) {

            Class<?> clazz = null;
            try {
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            T instance = null;
            try {
                assert clazz != null;
                instance = (T)clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

            for (Tuple tup : row.getRow()) {
                setField(instance,tup.getKey(),tup.getValue());
            }

            entities.add(instance);
        }

        return entities;
    }

    @Override
    public int update(int index, T t) {
        return 0;
    }

    @Override
    public int delete(int index) {
        return 0;
    }

    private boolean setField(T object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private static <V> V getField(Object object, String fieldName) {
        Class<?> clazz = object.getClass();

        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return (V) field.get(object);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private List<Field> getAllFields(Object object){
        List<Field> fields = new ArrayList<>();
        Class<?> clazz = object.getClass();

        for(int i=0;i<clazz.getDeclaredFields().length;i++){
            fields.add(clazz.getDeclaredFields()[i]);
        }

        return fields;
    }

}
