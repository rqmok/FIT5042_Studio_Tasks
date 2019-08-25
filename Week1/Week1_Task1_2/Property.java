/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.text.NumberFormat;

/**
 *
 * @author Jian
 * @author Zeeshan Khan
 *
 */
public class Property {

    private int id;
    private String address;
    private int size;
    private double bedrooms;
    private double price;

    public Property(int id, String address, int size, double bedrooms, double price) {
        this.id = id;
        this.address = address;
        this.size = size;
        this.bedrooms = bedrooms;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return this.getId() + " " + this.getAddress() + " " + this.getBedrooms() + "BR(s) " + this.getSize() + "sqm " + NumberFormat.getCurrencyInstance().format(this.getPrice());
    }
}
