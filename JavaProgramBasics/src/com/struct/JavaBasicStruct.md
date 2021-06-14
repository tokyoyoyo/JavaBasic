
### 类

Java是面向对象的语言，一个程序的基本单位就是class(类)，class是关键字.

类名要求：
- 类名必须以英文字母开头，后接字母，数字和下划线的组合
- 习惯以大写字母开头 
  
要注意遵守命名习惯 好的类命名：

  - Hello
  - NoteBook
  - VRPlayer
  
不好的类命名：

  - hello
  - Good123
  - Note_Book
  - _World
  
  public是访问修饰符，表示该class是公开的。
  public，也能正确编译，但是这个类将无法从命令行执行。
  
### 在class内部，可以定义若干方法（method）：

```java
public class HelloJava {
public static void main(String[] args) { // 方法名是main
// 方法代码...
} // 方法定义结束
}
```
方法名也有命名规则，命名和class一样，但是首字母小写：

好的方法命名：

  main
  goodMorning
  playVR
不好的方法命名：

  Main
  good123
  good_morning
  _playVR
  
### 三种注释

```java
// 这是注释...

/*
这是注释
blablabla...
这也是注释
*/

/**
 * 可以用来自动创建文档的注释
 *
 * @auther liaoxuefeng
 */

```