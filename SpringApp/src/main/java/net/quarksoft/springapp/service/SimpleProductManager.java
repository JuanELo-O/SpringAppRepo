package net.quarksoft.springapp.service;

import java.util.List;

import net.quarksoft.springapp.domain.Product;

/**
 * Created with IntelliJ IDEA.
 * User: Lalo
 * Date: 6/01/14
 * Time: 01:04 PM
 * To change this template use File | Settings | File Templates.
 */

public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    private List<Product> products;

    public List<Product> getProducts()
    {
        return products;
    }

    public void increasePrice(int percentage)
    {
        if(products != null)
        {
            for(Product product : products)
            {
                double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
                product.setPrice(newPrice);
            }
        }
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }
}
