package net.ntxt.expressions.contexts;

import net.ntxt.expressions.Context;
import net.ntxt.expressions.ExpLeaf;

import java.util.HashMap;
import java.util.Map;

public class ContextByMap implements Context {


    private final Map<String, ?> map;

    public ContextByMap(HashMap<String, ?> asContext){
        this.map = asContext;
    }

    @Override
    public ExpLeaf lookup(String name) {
        if(!map.containsKey(name)){
            String msg = String.format("Context map %s does not have the key [%s]", map, name);
            throw new ContextLookupException(msg);
        } else {
            Object val = map.get(name);
            if(val == null){
                String msg = String.format("Context %s value for [%s] is null", map, name);
                throw new ContextLookupException(msg);
            }
            return createResultExpression(val, val.getClass());
        }
    }
}
