package net.ntxt.expressions.contexts;

import net.ntxt.expressions.ExpLeaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ContextByMapTest {

    @Test
    public void lookup(){
        HashMap<String, Object> bean = new HashMap<>();
        bean.put("name", "BlueBird");
        bean.put("size", 10);
        ContextByMap context = new ContextByMap(bean);

        Assert.assertTrue(context.lookup("name") instanceof ExpLeaf);
        Assert.assertEquals("BlueBird", context.lookup("name").valueOf(null));

        Assert.assertTrue(context.lookup("size") instanceof ExpLeaf);
        Assert.assertEquals(10, context.lookup("size").valueOf(null));

        try {
            context.lookup("value");
        } catch(ContextLookupException e) {
            Assert.assertTrue( e.getMessage().startsWith("Field [value] not found in the context:"));
        }
        Assert.assertEquals(10, context.lookup("size").valueOf(null));
    }

}