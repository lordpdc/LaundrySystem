/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Administrator;

import data.dao.GenericDao;
import java.util.List;

/**
 *
 * @author Luis
 */
public abstract class Administrator {
    private GenericDao accessData;

    public void addNew(Object entiti){
        accessData.create(entiti);
    }

    public void remove(int id){
        this.accessData.delete(id);
    }

    public void update(int id, Object entiti){
        this.accessData.update(id, entiti);
    }

    public Object search(int id){
        return accessData.read(id);
    }

    public List readAll(){
        return accessData.readAll();
    }

    protected void setAccessData(GenericDao Data){
        this.accessData = Data;
    }
    
}
