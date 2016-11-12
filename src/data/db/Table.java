package data.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesar on 20/09/16.
 */
public class Table {
    private String name;
    private Connector db;

    public Table(String name){
        System.out.println(this.toString());
        this.name = name;
        db = new Connector();
    }

    public List<Row> getAllRows(){
        String stmt = "SELECT * FROM "+name;
        List<Row> rows = new ArrayList<>();
        ResultSet rs = db.executeQuery(stmt);
        ResultSetMetaData rsmd = null;
        try {
            rsmd = rs.getMetaData();
            while (rs.next()) {
                Row row = new Row();
                for (int i=1;i<=rsmd.getColumnCount();i++){
                    row.addTuple(new Tuple<Object>(rsmd.getColumnName(i),rs.getObject(i)));
                }
                rows.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rows;
    }

    public Row getRow(int id){
        String stmt = "SELECT * FROM "+name+" WHERE id="+id;
        ResultSet rs = db.executeQuery(stmt);
        ResultSetMetaData rsmd = null;
        Row row = new Row();
        try {
            rsmd = rs.getMetaData();
            if (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.addTuple(new Tuple<Object>(rsmd.getColumnName(i), rs.getObject(i)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public int addRow(List<Tuple> params){
        String strKeys = "";
        String strValues = "";
        for(Tuple param: params){
            strKeys += param.getKey()+",";
            strValues +="'"+param.getValue()+"',";
        }
        if (strKeys.charAt(strKeys.length() - 1)==','){
            strKeys = strKeys.substring(0, strKeys.length()-1);
        }
        if (strValues.charAt(strValues.length() - 1)==','){
            strValues = strValues.substring(0, strValues.length()-1);
        }
        System.out.println("INSERT INTO "+name+" ("+strKeys+") VALUES ("+strValues+")");
        return db.executeStatement("INSERT INTO "+name+" ("+strKeys+") VALUES ("+strValues+")");
    }

    public void updateRow(){

    }

    public void deleteRow(){

    }

}