package cn.yhs.learn.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class Log4JTest {

    // todo log4j 入门案例,使用初始化配置信息
    @Test
    public void test() {
        /**
         * log4j:WARN No appenders could be found for logger (cn.yhs.learn.test.Log4JTest).
         * log4j:WARN Please initialize the log4j system properly.
         * log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
         */
        // 0. 初始化配置信息,(没有使用配置文件)，不然不会打印信息，会提示进行配置
        // BasicConfigurator.configure();
        /**
         * log4j: Trying to find [log4j.xml] using context classloader sun.misc.Launcher$AppClassLoader@18b4aac2.
         * log4j: Trying to find [log4j.xml] using sun.misc.Launcher$AppClassLoader@18b4aac2 class loader.
         * log4j: Trying to find [log4j.xml] using ClassLoader.getSystemResource().
         * log4j: Trying to find [log4j.properties] using context classloader sun.misc.Launcher$AppClassLoader@18b4aac2.
         * log4j: Trying to find [log4j.properties] using sun.misc.Launcher$AppClassLoader@18b4aac2 class loader.
         * log4j: Trying to find [log4j.properties] using ClassLoader.getSystemResource().
         * log4j: Could not find resource: [null].
         */
        // 开启 log4j 内置的日志记录
        LogLog.setInternalDebugging(true);

        // 1. 获取日志对象
        Logger logger = Logger.getLogger(this.getClass());
        // 2. 日志记录输出
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");// 默认的debug级别
        logger.trace("trace");
    }
    // todo log4j 入门案例,开启内置的日志记录

    /**
     * 每个Logger都被了一个日志级别（log level），用来控制日志信息的输出。日志级别从高到低分为：
     * fatal 指出每个严重的错误事件将会导致应用程序的退出。
     * error 指出虽然发生错误事件，但仍然不影响系统的继续运行。
     * warn 表明会出现潜在的错误情形。
     * info 一般和在粗粒度级别上，强调应用程序的运行全程。
     * debug 一般用于细粒度级别上，对调试应用程序非常有帮助。
     * trace 是程序追踪，可以用于输出程序运行中的变量，显示执行的流程。
     * * 还有两个特殊的级别：
     * OFF，可用来关闭日志记录。
     * ALL，启用所有消息的日志记录。
     */
    @Test // 使用配置文件控制台输出
    public void test2() {
        // 0. 开启 log4j 内置的日志记录
        // LogLog.setInternalDebugging(true);
        // 1. 获取日志对象
        Logger logger = Logger.getLogger(this.getClass());
        // 2. 日志记录输出
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");// 默认的debug级别
        logger.trace("trace");
    }

    @Test // 使用配置文件输出到数据库
    public void test3() {
        // 0. 开启 log4j 内置的日志记录
         LogLog.setInternalDebugging(true);
        // 1. 获取日志对象
        Logger logger = Logger.getLogger(this.getClass());

        // 2. 日志记录输出
        for (int i = 0; i < 100; i++) {
            logger.fatal("fatal" + i);
            logger.error("error" + i);
            logger.warn("warn" + i);
            logger.info("info" + i);
            logger.debug("debug" + i);// 默认的debug级别
            logger.trace("trace" + i);
        }
    }


}
