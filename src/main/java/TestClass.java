import Test.AfterSuite;
import Test.BeforeSuite;
import Test.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestClass {
    public static void start(Class c) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Method[] methods = c.getDeclaredMethods();
        List<Method> before = findAnno(methods, BeforeSuite.class);
        if(before.size()>1){
            throw new RuntimeException("Нельзя использовать две аннотации BeforeSuite");
        }
        List<Method>  after = findAnno(methods, AfterSuite.class);
        if(after.size()>1){
            throw new RuntimeException("Нельзя использовать две аннотации AfterSuite");
        }

        Object o = c.getDeclaredConstructor().newInstance();

        if(before.size() > 0){
            before.get(0).invoke(o);
        }
        List<Method>  test = findAnno(methods, Test.class);

        Collections.sort(test, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });

        test.forEach((method) -> {
            try {
                method.invoke(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });


        if(after.size() > 0){
            after.get(0).invoke(o);
        }
    }

    private static List<Method> findAnno(Method[] methods, Class anno){
        List<Method> list = new ArrayList<>();
        for(int i =0; i < methods.length; i++){
            if(methods[i].getAnnotation(anno) != null){
               list.add(methods[i]);
            }
        }
        return list;
    }
}
