package net.quarksoft.springapp.web;

import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import net.quarksoft.springapp.service.SimpleProductManager;

/**
 * Created with IntelliJ IDEA.
 * User: Lalo
 * Date: 3/01/14
 * Time: 04:54 PM
 * To change this template use File | Settings | File Templates.
 */

public class InventoryControllerTests {

    @Test
    public void testHandleRequestView() throws Exception
    {
        InventoryController controller = new InventoryController();
        controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null,null);
        assertEquals("hello",modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}
