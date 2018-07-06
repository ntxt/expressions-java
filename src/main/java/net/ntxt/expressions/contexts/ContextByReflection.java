package net.ntxt.expressions.contexts;


import net.ntxt.expressions.Context;
import net.ntxt.expressions.ExpLeaf;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ContextByReflection implements Context {

    private final Object asContext;
    private final List<Field> fields;
    private final List<Method> methods;

    public ContextByReflection(Object asContext){
        this.asContext = asContext;
        this.fields = Arrays.asList(asContext.getClass().getFields());
        this.methods = Arrays.asList(asContext.getClass().getMethods());
    }

    @Override
    public ExpLeaf lookup(String name)
    {
        Optional<Field> field = fields.stream().filter(f -> f.getName().equals(name)).findAny();
        Optional<Method> getter = methods.stream().filter(f -> f.getName().equalsIgnoreCase("get" + name)).findAny();
        if(getter.isPresent()) {
            Object val = getGetterValue(getter.get());
            Type type = field.getClass().getComponentType();
            return createResultExpression(val, type);
        } else if(field.isPresent()) {
            Object val = getFieldValue(field.get());
            Type type = field.getClass().getComponentType();
            return createResultExpression(val, type);
        } else {
            String msg = String.format("Field [%s] not found in the context %s.", name, fields);
            throw new ContextLookupException("Field [" + name + "] not found in the context: " + fields.toString());
        }
    }

    private Object getGetterValue(Method m){
        try{
            return m.invoke(asContext);
        } catch (Exception e) {
            String msg = String.format("Error looking up [%s] in the context of %s.", m.getName(), asContext);
            throw new ContextLookupException(msg, e);
        }
    }

    private Object getFieldValue(Field f){
        try{
            return f.get(asContext);
        } catch (IllegalAccessException e) {
            String msg = String.format("Error looking up [%s] in the context of %s.", f.getName(), asContext);
            throw new ContextLookupException(msg, e);
        }
    }


}
