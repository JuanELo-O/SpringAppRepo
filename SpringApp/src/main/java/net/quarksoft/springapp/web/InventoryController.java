package net.quarksoft.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.quarksoft.springapp.service.ProductManager;

/**
 * Created with IntelliJ IDEA.
 * User: Eduardo Mejía
 * Date: 3/01/14
 * Time: 02:07 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class InventoryController {

    protected final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private ProductManager productManager;

    @RequestMapping(value = "/hello.htm")
    public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        String now = (new Date()).toString();
        logger.info("Printing date {}", now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now",now);
        myModel.put("products",this.productManager.getProducts());

        return new ModelAndView("hello","model",myModel);
    }

    public void setProductManager(ProductManager productManager)
    {
        this.productManager = productManager;
    }
}
