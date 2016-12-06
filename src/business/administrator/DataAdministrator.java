/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.administrator;

import business.utilities.DefaultValues;
import data.dao.GenericDAO;

import java.util.List;

/**
 * @author Luis
 */
public class DataAdministrator< T > {
    protected GenericDAO< T > accessData;

    public T addNew(T t) {
        return this.accessData.create(t);
    }

    public void update(int id, T t){
          accessData.update( id,t );
    }

    public void remove( int id ) {
        this.accessData.delete( id );
    }

    public T searchById( int id ) {
        return accessData.read( id );
    }

    public List<T> searchByAtribute(String value){
        return  accessData.readByAtrr(value);
    }

    public List<T> getAllData( ) {
        return accessData.readAll( );
    }

    protected void setAccessData( GenericDAO Data ) {
        this.accessData = Data;
    }

}
