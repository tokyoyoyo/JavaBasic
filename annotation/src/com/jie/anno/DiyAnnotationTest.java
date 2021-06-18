package com.jie.anno;

public class DiyAnnotationTest {


    @Report(type=2, level="warning")
    public class Hello {
    }

    public class HelloMoring extends Hello{

    }
}






/*

一些注解可以修饰其他注解，这些注解就称为元注解（meta annotation）。Java标准库已经定义了一些元注解，
我们只需要使用元注解，通常不需要自己去编写元注解。


        @Target
            最常用的元注解是@Target。使用@Target可以定义Annotation能够被应用于源码的哪些位置：

            @Target注解参可以变为数组{ ElementType.METHOD, ElementType.FIELD }
            @Target定义的value是ElementType[]数组，只有一个元素时，可以省略数组的写法。

            类或接口：ElementType.TYPE；
            字段：ElementType.FIELD；
            方法：ElementType.METHOD；
            构造方法：ElementType.CONSTRUCTOR；
            方法参数：ElementType.PARAMETER。


        @Retention
            另一个重要的元注解@Retention定义了Annotation的生命周期：

            仅编译期：RetentionPolicy.SOURCE；
            仅class文件：RetentionPolicy.CLASS；
            运行期：RetentionPolicy.RUNTIME。
            如果@Retention不存在，则该Annotation默认为CLASS。因为通常我们自定义的Annotation都是RUNTIME，
            所以，务必要加上@Retention(RetentionPolicy.RUNTIME)这个元注解


        @Inherited
            使用@Inherited定义子类是否可继承父类定义的Annotation。
            @Inherited仅针对@Target(ElementType.TYPE)类型的annotation有效，
            并且仅针对class的继承，对interface的继承无效

        定义Annotation的步骤
            第一步，用@interface定义注解

                    public @interface Report {
                    }

            第二步，添加参数、默认值：
                把最常用的参数定义为value()，推荐所有参数都尽量设置默认值。

                public @interface Report {
                    int type() default 0;
                    String level() default "info";
                    String value() default "";
                }

            第三步，用元注解配置注解：
                其中，必须设置@Target和@Retention，@Retention一般设置为RUNTIME，
                因为我们自定义的注解通常要求在运行期读取。一般情况下，不必写@Inherited和@Repeatable。
                        @Target(ElementType.TYPE)
                        @Retention(RetentionPolicy.RUNTIME)
                        public @interface Report {
                            int type() default 0;
                            String level() default "info";
                            String value() default "";
                        }

*/
