package com.jie.exc;

public class CatchTest02 {
    public static void main(String[] args) {
        int te = -1;

        process02(te);
    }

    static void process02(int val){
        if(val < 0)
            throw new IllegalArgumentException();

        //do something
    }
}
