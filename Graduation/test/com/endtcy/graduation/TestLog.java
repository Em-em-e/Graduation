package com.endtcy.graduation;

import org.apache.commons.logging.Log; //commons.logging日志接口
import org.apache.commons.logging.LogFactory;

import org.junit.Test;
//import org.slf4j.Logger;  //slf4j日志接口
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLog {
	private static Log log=LogFactory.getLog(TestLog.class);
//	private static Logger logger=LoggerFactory.getLogger(TestLog.class);
	
	@Test
	public void test(){
		log.debug("调试");
		log.info("信息");
		log.warn("警告");
		log.error("错误");
		log.fatal("严重错误");
//		
//		logger.debug("logger调试");
//		logger.info("logger信息");
//		logger.warn("logger警告");
//		logger.error("logger错误");
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
