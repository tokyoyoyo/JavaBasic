package com.jie.anno;

import java.lang.reflect.Field;

public class AnnotationUseTest {

    public static void main(String[] args) throws ReflectiveOperationException {
        check(new Person("ff"));

        // 判断@Report是否存在于Person类:
        System.out.println(Person.class.isAnnotationPresent(Report.class));
        //打上可复写注解的话就失败

        // 获取Person定义的@Report注解:
        Report report = Person.class.getAnnotation(Report.class);
        int type = report.type();
        System.out.println(report.level());

    }

    static void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String) {
                    String s = (String) value;
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }


}


/*
        判断某个注解是否存在于Class、Field、Method或Constructor：

            Class.isAnnotationPresent(Class)
            Field.isAnnotationPresent(Class)
            Method.isAnnotationPresent(Class)
            Constructor.isAnnotationPresent(Class)

        使用反射API读取Annotation：

            Class.getAnnotation(Class)
            Field.getAnnotation(Class)
            Method.getAnnotation(Class)
            Constructor.getAnnotation(Class)

        方法一是先判断Annotation是否存在，如果存在，就直接读取
            Class cls = Person.class;
            if (cls.isAnnotationPresent(Report.class)) {
                Report report = cls.getAnnotation(Report.class);
                ...
            }

        第二种方法是直接读取Annotation，如果Annotation不存在，将返回null：

            Class cls = Person.class;
            Report report = cls.getAnnotation(Report.class);
            if (report != null) {
               ...
            }

        读取方法参数的Annotation就比较麻烦一点，因为方法参数本身可以看成一个数组，而每个参数又可以定义多个注解，
        所以，一次获取方法参数的所有注解就必须用一个二维数组来表示
            public void hello(@NotNull @Range(max=5) String name, @NotNull String prefix) {
            }

            // 获取Method实例:
            Method m = ...
            // 获取所有参数的Annotation:
            Annotation[][] annos = m.getParameterAnnotations();
            // 第一个参数（索引为0）的所有Annotation:
            Annotation[] annosOfName = annos[0];
            for (Annotation anno : annosOfName) {
                if (anno instanceof Range) { // @Range注解
                    Range r = (Range) anno;
                }
                if (anno instanceof NotNull) { // @NotNull注解
                    NotNull n = (NotNull) anno;
                }
            }


*/