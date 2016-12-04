package business.Reports;

import java.util.*;

/**
 * Created by raoman on 11/11/2016.
 */
public class Report<T> {
    private List<T> data;
    private HashMap<String,Double> result;

    public Report( ) {
        data=new ArrayList<T>(  );
        result=new HashMap< String, Double>(  );
    }

    public void addData(T t){
        data.add( t );
    }
    public void addResult(String key, Double value){
        result.put( key,value );
    }


}
