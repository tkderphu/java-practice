package framework;

import java.util.HashMap;
import java.util.Map;

public class ContextApp {

    private static final Map<String, Object> context = new HashMap<>();
    public static <T> T getBean(String beanName) {
        return (T) context.get(beanName);
    }


    public static void putBean(String bean, Object object) {
        context.put(bean, object);
    }
}
