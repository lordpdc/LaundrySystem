package data.db;

/**
 * Created by cesar on 20/09/16.
 */
public class Tuple<V> {
    private String key;
    private V value;

    public Tuple(String key, V value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}