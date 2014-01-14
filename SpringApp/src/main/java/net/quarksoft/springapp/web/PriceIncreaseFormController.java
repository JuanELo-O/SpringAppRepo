package net.quarksoft.springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import net.quarksoft.springapp.service.PriceIncrease;
import net.quarksoft.springapp.service.ProductManager;

/**
 * Created with IntelliJ IDEA.
 * User: Lalo
 * Date: 7/01/14
 * Time: 09:39 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/priceincrease.htm")
public class PriceIncreaseFormController {

    //Logger
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductManager productManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid PriceIncrease priceIncrease, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "priceincrease";
        }

        int increase = priceIncrease.getPercentage();
        return "redirect:/hello.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected PriceIncrease formBackingObject(HttpServletRequest request) throws ServletException
    {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(15);
        return priceIncrease;
    }

    public void setProductManager(ProductManager productManager)
    {
        this.productManager = productManager;
    }

    public ProductManager getProductManager()
    {
        return productManager;
    }
}
