package com.jie.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//泛型就是定义一种模板，例如ArrayList<T>，然后在代码中为用到的类创建对应的ArrayList<类型>：

public class GenericTest {

    public static void main(String[] args) {

        ArrayList<String> strList = new ArrayList<String>();

//        由编译器针对类型作检查：
//        既实现了编写一次，万能匹配，又通过编译器保证了类型安全：这就是泛型。

        strList.add("hello"); // OK
        String s = strList.get(0); // OK
        System.out.println(s);
        //  strList.add(new Integer(123)); // compile error!
        //  Integer n = strList.get(0); // compile error!

    //向上转型
//        Java标准库中的ArrayList<T>实现了List<T>接口，它可以向上转型为List<T>

        List<String> list = new ArrayList<String>();
        //实际上是多态

    //不能把ArrayList<Integer>向上转型为ArrayList<Number>或List<Number>
        // 创建ArrayList<Integer>类型：
        ArrayList<Integer> integerList = new ArrayList<Integer>();
// 添加一个Integer：
        integerList.add(new Integer(123));
        integerList.add(new Integer(1));
// “向上转型”为ArrayList<Number>：
//        ArrayList<Number> numberList = integerList;
// 添加一个Float，因为Float也是Number：
//        numberList.add(new Float(12.34));
// 从ArrayList<Integer>获取索引为1的元素（即添加的Float）：
        Integer n = integerList.get(1);
        System.out.println(n);


            //        使用ArrayList时，如果不定义泛型类型时，泛型类型实际上就是Object：
        // 编译器警告:
        List list2 = new ArrayList();
        list2.add("Hello");
        list2.add("World");
        String first = (String) list2.get(0);
        String second = (String) list2.get(1);

            //        此时，只能把<T>当作Object使用，没有发挥泛型的优势。
            //        当我们定义泛型类型<String>后，List<T>的泛型接口变为强类型List<String>：
        // 无编译器警告:
        List<String> list3 = new ArrayList<String>();
        list3.add("Hello");
        list3.add("World");
            // 无强制转型:
        String first1 = list.get(0);
        String second1 = list.get(1);

        // 可以省略后面的Number，编译器可以自动推断泛型类型：
        List<Number> list4 = new ArrayList<>();

        //泛型接口
//        除了ArrayList<T>使用了泛型，还可以在接口中使用泛型。
//        例如，Arrays.sort(Object[])可以对任意数组进行排序，但待排序的元素必须实现Comparable<T>这个泛型接口：

        String[] ss = new String[] { "Orange", "Apple", "Pear" };
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));


//        使用泛型时，把泛型参数<T>替换为需要的class类型，例如：ArrayList<String>，ArrayList<Number>等；
//
//        可以省略编译器能自动推断出的类型，例如：List<String> list = new ArrayList<>();；
//
//        不指定泛型参数类型时，编译器会给出警告，且只能将<T>视为Object类型；
//
//        可以在接口中定义泛型类型，实现此接口的类必须实现正确的泛型类型。





    }
}
