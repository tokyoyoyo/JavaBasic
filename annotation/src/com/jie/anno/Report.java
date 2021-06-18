package com.jie.anno;

import java.lang.annotation.*;


//@Repeatable(Reports.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
public @interface Report {
    int type() default 0;
    String level() default "info";
}

//@Inherited  //该元注解定义的注解可被子类继承
//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//@interface Reports {
//    Report[] value();
//}


