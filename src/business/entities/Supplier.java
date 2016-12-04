/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.entities;

import business.utilities.DefaultValues;

/**
 *
 * @author Luis
 */
public class Supplier {
    protected int id;
    protected String name;
    protected String address;
    protected String telephone;
    protected String mail;
    
    public Supplier(){
        this.id= DefaultValues.INTEGER;
        this.name= DefaultValues.STRING;
        this.address = DefaultValues.STRING;
        this.telephone = DefaultValues.STRING;
        this.mail = DefaultValues.STRING;
    }

    public Supplier(String name, String address, String phone, String email){
        this.name = name;
        this.address = address;
        this.telephone = phone;
        this.mail = email;
    }
    
    public Supplier(int id, String name, String address, String phone, String email){
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = phone;
        this.mail = email;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the phone to set
     */
    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
