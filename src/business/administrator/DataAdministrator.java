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
public abstract class DataAdministrator< T > {
    protected GenericDAO< T > accessData;

    public void addNew(T t) {
        this.accessData.create(t);
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

    public List<T> getAllData( ) {
        return accessData.readAll( );
    }

    protected void setAccessData( GenericDAO Data ) {
        this.accessData = Data;
    }

}
