package com.jie.exc;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class LogTest {

    public static void main(String[] args) {

//        使用日志最大的好处是，它自动打印了时间、调用类、调用方法等很多有用的信息
//        Logging定义了7个日志级别，从严重到普通：
//
//        SEVERE
//        WARNING
//        INFO         默认级别是INFO，因此，INFO级别以下的日志，不会被打印出来
//        CONFIG
//        FINE
//        FINER
//        FINEST

        /*
        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");


         */

        Logger logger = Logger.getLogger(LogTest.class.getName());
        logger.info("Start process...");
        try {
//            "".getBytes("invalidCharsetName");
            "test".getBytes("utf-8");   //压制报错
        } catch (UnsupportedEncodingException e) {
            // TODO: 使用logger.severe()打印异常
            logger.severe("\"\".getBytes(\"invalidCharsetName\");");
        }
        logger.info("Process end.");
    }
}
