package net.quarksoft.springapp.service;

import net.quarksoft.springapp.domain.Product;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lalo
 * Date: 6/01/14
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductManager extends Serializable{

    public void increasePrice(int percentage);
    public List<Product> getProducts();
}
