package pck;

import org.reflections.Reflections;
import pck.myservices.ServiceAbs;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SnifferAnnotation {
    public void sniff() {
        Reflections reflection = new Reflections("pck");
        Set<Class<?>> classeAnnotatedList =
                reflection.getTypesAnnotatedWith(ServiceAnno.class);

        Class<ServiceAbs> serviceAbsClass = ServiceAbs.class;
        classeAnnotatedList.forEach(classeAnnotated -> {
            try {
                if (classeAnnotated.getSuperclass() == serviceAbsClass) {
                    Constructor<?> constructor = classeAnnotated.getConstructor(String.class, int.class);
                    constructor.setAccessible(true);
                    ServiceAbs o = (ServiceAbs) constructor.newInstance("test", 5);
                    o.process();

                    //anotation gettings
                    ServiceAnno serviceAnno = classeAnnotated.getAnnotation(ServiceAnno.class);
                    System.out.printf("reqMsg : %s <====> respMsg %s\n\n", serviceAnno.msgReq(), serviceAnno.msgResp());
                }
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }
}
