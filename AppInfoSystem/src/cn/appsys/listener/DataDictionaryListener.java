package cn.appsys.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class DataDictionaryListener implements ServletContextListener{
	private static Logger log = Logger.getLogger("DataDictionary");
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		log.info("¼ÓÔØÊý¾Ý×Öµä");
		
		
	}



}
