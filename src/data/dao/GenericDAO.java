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
public class GenericDAO<T> implements DAO<T> {
    private String className;
    private Table table;

    public GenericDAO( String className, String tableName){
        this.className = className;
        table = new Table(tableName);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <V> T create(T t) {
        List<Tuple> tuples = getTuples( t );
        table.addRow(tuples);

        return instantiateEntity(table.getLastRow());
    }

    @Override
    public T read(int id) {
        Row row = table.getRow(id);
        return instantiateEntity(row);
    }

    public List<T> readByAtrr(String value) {
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

        List<Row> rows = table.getRowsByAttr(value, getAllFields(entity ));
        List<T> entities = new ArrayList<>();
        for (Row row : rows) {
            entity=null;
            try {
                assert clazz != null;
                entity = (T)clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
              for (Tuple tup : row.getRow()) {
                setField(entity,tup.getKey(),tup.getValue());
            }
                entities.add(entity);


        }


        return entities;
    }

    @Override
    public List<T> readAll() {
        List<Row> rows = table.getAllRows();
        List<T> entities = new ArrayList<>();

        for (Row row : rows) {
            T entityInstance = instantiateEntity(row);
            entities.add(entityInstance);
        }

        return entities;
    }

    @Override
    public <V> int  update(int index, T t) {
        List< Tuple > tuples = getTuples( t );
        return table.updateRow(index,tuples);
    }

    private <V> List<Tuple> getTuples( T t ) {
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
        return tuples;
    }

    @Override
    public int delete(int id) {
        return table.deleteRow(id);
    }

    private T instantiateEntity(Row row){
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
            if(!setField(instance,tup.getKey(),tup.getValue())) {
                System.out.println("Failed to load field "+tup.getKey()+": "+tup.getValue());
            }
        }
        return instance;
    }

    // =================================================================================

    private boolean setField(T object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();

        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                if(field.isAnnotationPresent(DataField.class)){
                    field.setAccessible(true);
                    field.set(object, fieldValue);
                    return true;
                }
                return false;
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
                if(field.isAnnotationPresent(DataField.class)){
                    field.setAccessible(true);
                    return (V) field.get(object);
                }
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

        for(int i=0; i<clazz.getDeclaredFields().length; i++){
            if (clazz.getDeclaredFields()[i].isAnnotationPresent(DataField.class)){
                fields.add(clazz.getDeclaredFields()[i]);
            }
        }

        return fields;
    }

}
