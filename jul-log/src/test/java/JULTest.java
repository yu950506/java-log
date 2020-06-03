import org.junit.Test;


import java.io.IOException;
import java.util.logging.*;

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
     * * <ul>
     * * <li>SEVERE (highest value)
     * * <li>WARNING
     * * <li>INFO
     * * <li>CONFIG
     * * <li>FINE
     * * <li>FINER
     * * <li>FINEST  (lowest value)
     * * </ul>
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
        logger.setLevel(Level.ALL);
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

    }


}
