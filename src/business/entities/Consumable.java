package business.entities;

import business.utilities.DefaultValues;
import data.dao.DataField;

/**
 * Created by cesar on 03/09/16.
 */
public class Consumable {
    @DataField private int id;
    @DataField private String name;
    @DataField private String description;

    public Consumable(){
        this.id = DefaultValues.INTEGER;
        this.name = DefaultValues.STRING;
        this.description = DefaultValues.STRING;
    }

    public Consumable(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Consumable(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
