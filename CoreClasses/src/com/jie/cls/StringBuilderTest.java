package com.jie.cls;

public class StringBuilderTest {
//    StringBuilder是一个可变对象，可以预分配缓冲区，往StringBuilder中新增字符时，不会创建新的临时对象：

//    StringBuilder还可以进行链式操作
    /*
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(1024);
        sb.append("Mr.")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(sb.toString());

//        进行链式操作的关键是，定义的append()方法会返回this，这样，就可以不断调用自身的其他方法。
    }*/
    public static void main(String[] args) {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }
    static String buildInsertSql(String table, String[] fields) {
        // TODO:
        StringBuilder sb = new StringBuilder(1024);
        sb.append("INSERT INTO ")
                .append(table)
                .append(" (")
                .append(fields[0]+", ")
                .append(fields[1]+", ")
                .append(fields[2])
                .append(") ")
                .append("VALUES (?, ?, ?)");
        return sb.toString();
    }

}
