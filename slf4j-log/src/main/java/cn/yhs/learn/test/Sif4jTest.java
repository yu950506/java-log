package cn.yhs.learn.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sif4jTest {

 // 1. 定义日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger(Sif4jTest.class);

    // todo 5 绑定log4j，打印级别跟随配置文件来定
    @Test
    public void test5() {
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info"); //jcl默认打印info及以上级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }

    // todo 4 绑定jul，默认打印info级别
    @Test
    public void test4() {
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info"); //jcl默认打印info及以上级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }

    // todo 1 入门案例，使用内置的实现
    @Test
    public void test1() {
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info"); // 简单实现默认打印info及以上级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }

    // todo 2 入门案例，使用logback的实现
    @Test
    public void test2() {
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info"); // slf4j-simple默认打印info及以上级别
        LOGGER.debug("debug");// logback默认打印debug及以上级别
        LOGGER.trace("trace");
    }

    // todo 3 使用内置的简单实现，默认打印info级别
    @Test
    public void test3() {
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info"); // 简单实现默认打印info及以上级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
