package business.Reports;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 11/11/2016.
 */
public class Report<T> {
    private List<T> data;
    private List<T> result;

    public Report( ) {
        data=new ArrayList<T>(  );
        result=new ArrayList< T >(  );
    }

    public void addData(T t){
        data.add( t );
    }
    public void addResult(T t){
        result.add( t );
    }


}
