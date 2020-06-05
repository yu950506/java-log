package cn.yhs.learn.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

import org.junit.Test;

public class JULTest {
    // todo 1 快速入门
    @Test
    public void test() {
        // 1. 创建日志对象
        Logger logger = Logger.getLogger(this.getClass().getName());
        System.out.println("我是日志信息");
        // 2. 日志记录输出
        logger.info("我是日志信息");// 日志信息是红颜色的
        // 3. 通用方法日志记录输出
        logger.log(Level.INFO, "我是info级别。。。");
        // 4. 还可以通过占位符方式来输出变量
        Object name = "喻汉生";
        Object age = 18;
        logger.log(Level.INFO, "用户信息：{0}，{1}", new Object[]{name, age});

    }

    /**
     * * <ul> JUL提供了 7 个日志级别
     * * <li>OFF(highest value) 关闭日志
     * * <li>SEVERE (highest value)
     * * <li>WARNING
     * * <li>INFO
     * * <li>CONFIG
     * * <li>FINE
     * * <li>FINER
     * * <li>FINEST  (lowest value)
     * * <li>ALL  (lowest value)  开启所有日志
     * * </ul>
     * <p>
     * public boolean isLoggable(Level level) {
     * if (level.intValue() < levelValue || levelValue == offValue) {
     * return false;
     * }
     * return true;
     * }
     */
    // todo 2 日志级别
    @Test
    public void test2() {
        // 1. 获取日志对象
        Logger logger = Logger.getLogger(this.getClass().getName());
        //        logger.setLevel(Level.OFF); // 关闭日志输出
        //        logger.setLevel(Level.ALL); // 开启日志输出

        // 2. 日志级别输出，实际是哪个都是在调用通用log(Level.SEVERE, msg);
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info"); // JUL 默认是info级别,会输出info及以上级别的日志信息
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }


    // todo 3 自定义日志级别并输出到控制台
    @Test
    public void test3() {
        // 1. 创建日志记录对象，构造器私有化，使用提供的静态方法
        Logger logger = Logger.getLogger(this.getClass().getName());
        // 2.0 关闭系统默认设置
        logger.setUseParentHandlers(false);
        // 2.1 创建控制台输出对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 2.2 创建输出格式
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // 2.3 将输出格式和控制台想关联
        consoleHandler.setFormatter(simpleFormatter);
        // 2.4 将控制台和当前日志对象进行想管理
        logger.addHandler(consoleHandler);
        // 2.5 设置日志级别，consoleHandler的默认级别是info
        consoleHandler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
        // 3. 输出日志
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

    }

    // todo 4 输出文件对象
    @Test
    public void test4() {
        // 1. 创建日志对象
        Logger logger = Logger.getLogger(this.getClass().getName());
        // 2.0 关闭系统设置
        logger.setUseParentHandlers(false);
        // 2.1 创建日志文件处理器
        FileHandler fileHandler = null;
        try {
            // 注意：会自动创建文件，但是不会创建目录
            fileHandler = new FileHandler("d:/log/jul.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.2 创建输出格式对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // 2.3 将输出格式对象和输出对象关联
        fileHandler.setFormatter(simpleFormatter);
        // 2.4 将输出对象和日志对象关联
        logger.addHandler(fileHandler);
        // 2.5 设置日志级别
        logger.setLevel(Level.ALL); // 设置根日志的级别
        fileHandler.setLevel(Level.ALL);
        // 3. 日志输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    // todo 5 测试父子关系
    @Test
    public void test5() {
        Logger logger1 = Logger.getLogger("cn.yhs.learn");
        Logger logger2 = Logger.getLogger("cn.yhs");
        Logger logger3 = Logger.getLogger("cn");
        System.out.println("logger1 = " + logger1);//logger1 = java.util.logging.Logger@50134894
        System.out.println("logger2 = " + logger2);//logger2 = java.util.logging.Logger@2957fcb0
        System.out.println("logger3 = " + logger3);//logger3 = java.util.logging.Logger@1376c05c
        Logger logger1Parent = logger1.getParent();
        Logger logger2Parent = logger2.getParent();
        Logger logger3Parent = logger3.getParent();
        System.out.println("logger1Parent = " + logger1Parent);//logger1Parent = java.util.logging.Logger@2957fcb0
        System.out.println("logger2Parent = " + logger2Parent);//logger2Parent = java.util.logging.Logger@1376c05c
        System.out.println("logger3Parent = " + logger3Parent);//logger3Parent = java.util.logging.LogManager$RootLogger@51521cc1
        // 自定义设置logger2的日志级别,测试父子关系
        logger2.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);
        consoleHandler.setLevel(Level.ALL);
        logger2.setLevel(Level.ALL);

        System.out.println("logger1 的日志输出");
        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");

        System.out.println("logger2 的日志输出");
        logger2.severe("severe");
        logger2.warning("warning");
        logger2.info("info");
        logger2.config("config");
        logger2.fine("fine");
        logger2.finer("finer");
        logger2.finest("finest");

        System.out.println("logger3 的日志输出");
        logger3.severe("severe");
        logger3.warning("warning");
        logger3.info("info");// 只会输出INFO及以上级别
        logger3.config("config");
        logger3.fine("fine");
        logger3.finer("finer");
        logger3.finest("finest");
        /**
         * 结论：
         * ① 日子之间是存在父子关系的，按照java中的包级别来进行划分，最顶级包的父类是LogManager$RootLogger
         * ② 由于logger2自定义设置了日志输出级别，所以loggeer2及其子类（logger1）会输出指定级别的日志，而logger3是logger2的父类，由于
         * 没有设置日志级别，默认是INFO。
         */
    }


    // todo 加载自定义日志文件，配置日志级别和输出格式
    @Test
    public void test6() throws IOException {
        // 1.读取配置文件
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("logging.properties");
        // 2. 获取日志管理器对象,单例的
        LogManager logManager = LogManager.getLogManager();
        // 3. 通过日志管理器对象加载配置文件
        logManager.readConfiguration(inputStream);
        // 4. 打印日志
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info"); // JUL 默认是info级别,会输出info及以上级别的日志信息
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void test7() throws IOException {
        /**
         * # 自定义日志格式
         * #cn.yhs.learn.test.handlers = java.util.logging.ConsoleHandler
         * #cn.yhs.learn.test.level = CONFIG
         * #cn.yhs.learn.test.useParentHandlers = false
         */
        // 1.读取配置文件
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("logging.properties");
        // 2. 获取日志管理器对象,单例的
        LogManager logManager = LogManager.getLogManager();
        // 3. 通过日志管理器对象加载配置文件
        logManager.readConfiguration(inputStream);
        // 4. 打印日志
//        Logger logger = Logger.getLogger(this.getClass().getName());
        Logger logger = Logger.getLogger("cn.yhs.learn.test");
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

}
