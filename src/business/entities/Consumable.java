package business.entities;

import business.utilities.DefaultValues;

/**
 * Created by cesar on 03/09/16.
 */
public class Consumable {
    private int id;
    private String name;
    private String description;

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
