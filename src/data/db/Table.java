package data.db;

import java.lang.reflect.Field;
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
                rows.add(createRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            rows= null;
        }

        return rows;
    }


    public List<Row> getRowsByAttr(String value, List<Field > fields){
        String stmt = "SELECT * FROM "+name+" WHERE";
        for(Field field: fields){
            stmt=stmt.concat(" "+ field.getName()+" LIKE '%"+value+"%' OR");
        }
        stmt=stmt.substring( 0,stmt.length()-2 );

        List<Row> rows = new ArrayList<>();
        ResultSet rs = db.executeQuery(stmt);

        ResultSetMetaData rsmd = null;
        try {
            rsmd = rs.getMetaData();
            while (rs.next()) {
                rows.add(createRow(rs));
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

        return createRow(rs);
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

    public int updateRow(int id, List<Tuple> params){
        String strUpdate = "";
        for(Tuple param: params){
            strUpdate += param.getKey()+"='"+param.getValue()+"',";
        }
        if (strUpdate.charAt(strUpdate.length() - 1)==','){
            strUpdate = strUpdate.substring(0, strUpdate.length()-1);
        }
        return db.executeStatement("UPDATE "+name+" SET "+strUpdate+" WHERE id="+id);
    }

    public int deleteRow(int id){
        return db.executeStatement("DELETE FROM "+name+" WHERE "+name+".id = "+id);
    }

    private Row createRow(ResultSet rs){
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

}