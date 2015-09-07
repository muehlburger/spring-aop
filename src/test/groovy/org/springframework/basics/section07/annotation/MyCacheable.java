package org.springframework.basics.section07.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyCacheable {

}
