package net.quarksoft.springapp.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Lalo
 * Date: 6/01/14
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */

public class Product implements Serializable{

    private static final long serialVersionUID = 1L;

    private String description;
    private Double price;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("description: " + description + ";");
        buffer.append("price: " + price);
        return buffer.toString();
    }
}
