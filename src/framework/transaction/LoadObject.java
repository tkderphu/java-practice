package framework.transaction;

import framework.ContextApp;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LoadObject {
    public static void load(String scanScope) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String path = scanScope.replace(".", "/");
        String src = "src/" + path;
        File directory = new File(src);

        if(directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for(int i = 0; i < files.length; i++) {
                if(files[i].isDirectory()) {
                    load(scanScope + "." + files[i].getName());
                } else {
                    String className = scanScope + "." + files[i].getName().replace(".java", "");
                    Class<?> clazz = Class.forName(className);
                    DAO declaredAnnotation = clazz.getDeclaredAnnotation(DAO.class);
                    if(declaredAnnotation != null) {
                        Constructor<?> constructor = clazz.getConstructor(new Class[]{});
                        ContextApp.putBean(declaredAnnotation.beanName(), constructor.newInstance());
                    }
                }
            }
        }

    }
}
