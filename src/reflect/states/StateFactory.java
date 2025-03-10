package reflect.states;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class StateFactory {
    private static Map<String, OrderState> statesCache = findAllDerivedStates();


    public static OrderState getInstance(String orderStateType) {
        return statesCache.get(orderStateType);
    }

    private static Map<String, OrderState> findAllDerivedStates() {
        try {
            HashMap<String, OrderState> hashMap = new HashMap<>();
            Class<?>[] classes = OrderState.class
                    .getPackage()
                    .getAnnotation(MyPackageAnnotation.class)
                    .implementationsOfPet();
            for(Class clazz : classes) {
                Constructor constructor = clazz.getConstructor(new Class[]{});
                hashMap.putIfAbsent(clazz.getSimpleName(), (OrderState) constructor.newInstance());
            }
            return  hashMap;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
