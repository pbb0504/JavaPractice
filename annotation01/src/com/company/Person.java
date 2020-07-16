package com.company;

import java.lang.annotation.Repeatable;

/**
 * @author: pbb
 * @date: 2020/7/16 16:47
 */
@Repeatable(Persons.class)
public @interface Person {
    String role() default "";
}
