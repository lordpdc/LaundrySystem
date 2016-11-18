package business.entities;

import business.utilities.DefaultValues;

/**
 * Created by raoman on 21/09/2016.
 */
public class Customer {
    private int id;
    private String name;
    private String phone;
    private String mail;

    public Customer() {
        this.id = DefaultValues.INTEGER;
        this.name = DefaultValues.STRING;
        this.phone = DefaultValues.STRING;
        this.mail = DefaultValues.STRING;
    }

    public Customer(String name, String phone, String mail) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    public Customer(int id, String name, String phone, String mail) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
