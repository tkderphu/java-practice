package framework.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation can't use for collection, map ...
 * Only single object
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelProperties {
    String name();
    Class<?> isDefined() default Object.class;
    PropertiesType type() default PropertiesType.NORMAL;

}
