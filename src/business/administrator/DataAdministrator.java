/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.administrator;

import data.dao.GenericDao;

import java.util.List;

/**
 * @author Luis
 */
public abstract class DataAdministrator< T > {
    protected GenericDao< T > accessData;

    public  void addNew( T t ){
        this.accessData.create(t);
    }

    public abstract void update( int id, T t );

    public void remove( int id ) {
        this.accessData.delete( id );
    }

    abstract public T search(String name);

    public T search( int id ) {
        return accessData.read( id );
    }

    public List<T> readAll( ) {
        return accessData.readAll( );
    }

    protected void setAccessData( GenericDao Data ) {
        this.accessData = Data;
    }

}
