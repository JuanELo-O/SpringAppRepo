package net.quarksoft.springapp.service;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Lalo
 * Date: 7/01/14
 * Time: 09:26 AM
 * To change this template use File | Settings | File Templates.
 */

public class PriceIncrease {

    //Se crea Log para esta clase y las subclases.
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Min(0)
    @Max(50)
    private int percentage;

    public void setPercentage(int i)
    {
        percentage = i;
        logger.info("Porcentaje colocado a: " + i);
    }

    public int getPercentage()
    {
        return percentage;
    }
}
