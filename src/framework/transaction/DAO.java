package framework.transaction;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DAO {
    String beanName()  default "";
}
