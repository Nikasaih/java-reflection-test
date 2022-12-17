package pck;

import org.reflections.Reflections;
import pck.myservices.AbsMyService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SnifferAnotation {
    public void sniff() {
        Reflections reflection = new Reflections("pck");
        Set<Class<?>> annotated =
                reflection.getTypesAnnotatedWith(Service.class);

        Class<AbsMyService> ab = AbsMyService.class;
        annotated.forEach(aClass -> {
            try {

                Class<?> c = Class.forName(aClass.getName());
                if (c.getSuperclass() == ab) {
                    Constructor<?> constructor = c.getConstructor(String.class, int.class);
                    constructor.setAccessible(true);
                    Object o = constructor.newInstance("test", 5);
                    System.out.print(o);

                    Service serviceAnno = c.getAnnotation(Service.class);
                    System.out.println(serviceAnno.msgReq() + ":::::" + serviceAnno.msgResp());
                }
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });

    }
}
