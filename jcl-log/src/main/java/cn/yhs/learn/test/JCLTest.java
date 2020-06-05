package cn.yhs.learn.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * 日志门面
 */
public class JCLTest {

    // todo 1 jcl入门，默认使用jdk的日志
    // todo 2 jcl入门，使用log4j

    @Test
    public void test1() {
        Log log = LogFactory.getLog(this.getClass());
        log.info("info......");
        // 默认使用的是jdk自带的日志
        
    }
    @Test
    public void test2() {
        //导入log4j的jar包之后就使用log4j的格式
        Log log = LogFactory.getLog(this.getClass());
        log.info("info......");
    }



}
