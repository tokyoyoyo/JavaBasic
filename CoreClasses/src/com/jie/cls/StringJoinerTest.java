package com.jie.cls;

import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }
    static String buildSelectSql(String table, String[] fields) {
        // TODO:
        StringJoiner sj = new StringJoiner(", ", "SELECT ", " FROM ");
        for (String name : fields) {
            sj.add(name);
        }

        return sj+table;
    }
//    String还提供了一个静态方法join()，这个方法在内部使用了StringJoiner来拼接字符串，
//    在不需要指定“开头”和“结尾”的时候，用String.join()更方便


//    public static void main(String[] args) {
//        String[] names = {"Bob", "Alice", "Grace"};
//        String s = String.join(", ", names);
//
//        System.out.println(s.toString());
//    }

}
