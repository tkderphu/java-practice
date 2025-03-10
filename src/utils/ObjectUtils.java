package utils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ObjectUtils {

    public static boolean isNull(Object object) {
        if(object == null) {
            return true;
        }
        return false;
    }

    public static <T> T init(Class<T> clazzInit, Object...prams) {
        try {
            List<Class<?>> classes = new ArrayList<>();
            for(var field : clazzInit.getDeclaredFields()) {
                classes.add(field.getType());
            }
            Constructor<T> constructor = clazzInit.getConstructor(
                    ArrayUtils.convertToArray(classes, Class.class)
            );
            return constructor.newInstance(prams);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
