package com.jie.ioTest;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {
    public static void main(String[] args) throws IOException {
        System.out.println(File.separator); // 根据当前平台打印"\"或"/"

//        构造一个File对象，即使传入的文件或目录不存在，代码也不会出错，因为构造一个File对象，并不会导致任何磁盘操作。
//        只有当我们调用File对象的某些方法的时候，才真正进行磁盘操作。/
        File file = new File("..");     //相对路径以项目所在文件夹为参照

        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());

        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println();
        System.out.println("ioTest==================");
        File file1 = new File("io.txt");
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.canExecute());
        System.out.println(file1.length());
        /*
                    boolean canRead()：是否可读；
                    boolean canWrite()：是否可写；
                    boolean canExecute()：是否可执行；
                    long length()：文件字节大小
         */
        System.out.println("creatTeat====================");




        File f = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
        f.deleteOnExit(); // JVM退出时自动删除
        System.out.println(f.isFile());
        System.out.println(f.getAbsolutePath());

//        遍历文件和目录
        File f2 = new File("..\\JavaBasic");
        File[] fs1 = f2.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        File[] fs2 = f.listFiles(new FilenameFilter() { // 仅列出.exe文件
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe"); // 返回true表示接受该文件
            }
        });
        printFiles(fs2);

        /*
        和文件操作类似，File对象如果表示一个目录，可以通过以下方法创建和删除目录：

        boolean mkdir()：创建当前File对象表示的目录；
        boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
        boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。

         */





        System.out.println("PathTest==================");
        Path path = Paths.get("Tes", "project", "study");
        System.out.println(path);

        System.out.println("=================");

        System.out.println("path.toAbsolutePath()  :  "+path.toAbsolutePath());


        System.out.println("path.normalize()  : "+path.normalize());

        System.out.println("path.toFile()  :  "+path.toFile());
        System.out.println("=======================");
        for (Path p : Paths.get("..").toAbsolutePath()) {
            System.out.println(" " + p);
        }

        System.out.println("遍历一下===============");

        File currentDir = new File(".\\CollectionTest");
        listDir(currentDir.getCanonicalFile());


    }

    static void listDir(File dir) {
        printName(dir, 1);
    }

    static void printName(File dir, int level) {
        //获取文件级别，生成空格
        StringBuilder sp = new StringBuilder("");
        for(int i=1; i<level; i++) {
            sp.append("|====|");
        }

        //打印空格及文件名，若为目录加入"\"
        System.out.print(sp.toString()+dir.getName());
        if (dir.isDirectory()) {
            System.out.println("\\");
        }else {
            System.out.println();
        }

        //获取子目录及子文件，有子目录则进行递归
        File[] fs = dir.listFiles();
        if (fs != null) {
            for(File f:fs) {
                printName(f, level+1);
            }
        }
    }

    static void printFiles(File[] files) throws IOException {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getCanonicalPath());
            }
        }
        System.out.println("==========");
    }

}
