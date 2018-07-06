package net.ntxt.expressions.contexts;

import net.ntxt.expressions.ExpLeaf;
import org.junit.Assert;
import org.junit.Test;

public class ContextByReflectionTest {

    @Test
    public void lookup() {
        TestBean bean = new TestBean("BlueBird", 10, Long.valueOf(0));
        ContextByReflection context = new ContextByReflection(bean);

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

    class TestBean {
        public String name;
        private int size;
        private long value;

        public TestBean(String name, int size, long value){
            this.name = name;
            this.size = size;
            this.value = value;
        }

        public int getSize(){
            return this.size;
        }


    }
}