/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Administrator;

import data.dao.Dao;

/**
 *
 * @author Luis
 */
public abstract class Administrator {
    protected Dao element;

    public abstract void create(Object entiti);
    
    public abstract void delete(Object entiti);
    
    public abstract void update(Object entiti);
    
    public abstract void read(int id);
    
    public abstract void readAll();
    
}
