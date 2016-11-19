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
public class Service {
    protected int id;
    protected String name;
    protected String description;
    protected double unitariPrice;
    
    public Service(){
        this.id = DefaultValues.INTEGER;
        this.name = DefaultValues.STRING;
        this.description = DefaultValues.STRING;
        this.unitariPrice = DefaultValues.DOUBLE;
    }

    public Service(String name, String description, double unitariPrice) {
        this.name = name;
        this.description = description;
        this.unitariPrice = unitariPrice;
    }

    public Service(int id, String name, String description, double unitariPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitariPrice = unitariPrice;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unitariPrice
     */
    public double getUnitariPrice() {
        return unitariPrice;
    }

    /**
     * @param unitariPrice the unitariPrice to set
     */
    public void setUnitariPrice(double unitariPrice) {
        this.unitariPrice = unitariPrice;
    }
    
    
}
