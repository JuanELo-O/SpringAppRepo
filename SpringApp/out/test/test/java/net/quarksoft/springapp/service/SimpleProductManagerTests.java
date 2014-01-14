package net.quarksoft.springapp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.quarksoft.springapp.domain.Product;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

/**
 * Created with IntelliJ IDEA.
 * User: Lalo
 * Date: 6/01/14
 * Time: 01:28 PM
 * To change this template use File | Settings | File Templates.
 */

public class SimpleProductManagerTests {

    private SimpleProductManager productManager;

    private List<Product> products;

    private static int PRODUCT_COUNT = 2;
    private static Double CHAIR_PRICE = new Double(20.50);
    private static String CHAIR_DESCRIPTION = "Char";
    private static Double TABLE_PRICE = new Double(150.10);
    private static String TABLE_DESCRIPTION = "Table";

    private static int POSITIVE_PRICE_INCREASE = 10;

    @Before
    public void setUp() throws Exception
    {
        productManager = new SimpleProductManager();

        //Se inicializa la lista
        products = new ArrayList<Product>();

        //Se arma las lista con sus debidas intanciaciones
        Product product = new Product();
        product.setDescription(CHAIR_DESCRIPTION);
        product.setPrice(CHAIR_PRICE);
        products.add(product);

        product = new Product();
        product.setDescription(TABLE_DESCRIPTION);
        product.setPrice(TABLE_PRICE);
        products.add(product);

        productManager.setProducts(products);
    }

    @Test
    public void testGetProductsWithNoProducts()
    {
        productManager = new SimpleProductManager();
        assertNull(productManager.getProducts());
    }

    @Test
    public void testGetProducts()
    {
        List<Product> products = productManager.getProducts();
        assertNotNull(products);
        assertEquals(PRODUCT_COUNT, productManager.getProducts().size());

        Product product = products.get(0);
        assertEquals(CHAIR_DESCRIPTION, product.getDescription());
        assertEquals((Object) CHAIR_PRICE, product.getPrice());

        product = products.get(1);
        assertEquals(TABLE_DESCRIPTION, product.getDescription());
        assertEquals((Object) TABLE_PRICE, product.getPrice());

    }

    @Test
    public void testIncreasePriceWithNullLisOfProducts()
    {
        try
        {
            productManager = new SimpleProductManager();
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch (Exception ex)
        {
            fail("Products list is null.");
        }
    }

    @Test
    public void testIncreasePriceWithEmptyListOfProducts()
    {
        try
        {
            productManager = new SimpleProductManager();
            productManager.setProducts(new ArrayList<Product>());
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch (Exception ex)
        {
            fail("Products list is empty.");
        }
    }

    @Test
    public void testIncreasePriceWithPositivePercentage()
    {
        productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;

        List<Product> products = productManager.getProducts();
        Product product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 0);

        product = products.get(1);
        assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 0);
    }
}
