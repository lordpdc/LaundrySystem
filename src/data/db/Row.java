package data.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesar on 20/09/16.
 */
public class Row{
    List<Tuple> tuples;

    public Row(){
        tuples = new ArrayList<>();
    }

    public List<Tuple> getRow() {
        return tuples;
    }

    public void setTuples(List<Tuple> tuples) {
        this.tuples = tuples;
    }

    public void addTuple(Tuple tuple){
        this.tuples.add(tuple);
    }
}
