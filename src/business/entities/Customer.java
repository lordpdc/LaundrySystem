package business.entities;

import business.utilities.DefaultValues;

/**
 * Created by raoman on 21/09/2016.
 */
public class Customer {
    private int id;
    private String name;
    private String telephone;
    private String email;

    public Customer() {
        this.id = DefaultValues.INTEGER;
        this.name = DefaultValues.STRING;
        this.telephone = DefaultValues.STRING;
        this.email = DefaultValues.STRING;
    }

    public Customer(String name, String phone, String mail) {
        this.name = name;
        this.telephone = phone;
        this.email = mail;
    }

    public Customer(int id, String name, String phone, String mail) {
        this.id = id;
        this.name = name;
        this.telephone = phone;
        this.email = mail;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
