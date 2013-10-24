package com.test.methods;



import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.test.internal.Auto;
import com.test.methods.APITools;

	public class toLog4j {

		/**
		 * STAR
		 */
		private final Logger log = Logger.getLogger(toLog4j.class);

		public void log() throws Exception {
			Auto.Auto_HuDun();
			Properties props = new Properties();        
			props.setProperty("log4j.rootLogger","INFO,CONSOLE");
			props.setProperty("log4j.appender.CONSOLE","org.apache.log4j.RollingFileAppender");
			props.setProperty("log4j.appender.Threshold","WARN");
			props.setProperty("log4j.appender.CONSOLE.layout","org.apache.log4j.PatternLayout");
			props.setProperty("log4j.appender.CONSOLE.encoding", "UTF-8");
			props.setProperty("log4j.appender.CONSOLE.layout.ConversionPattern","[%-5p]%d{yyyy-MM-dd HH:mm:ssS} %c %m%n");
			props.setProperty("log4j.appender.CONSOLE.File",System.getenv("LOG_FILE"));   
			PropertyConfigurator.configure(props);
			log.info(APITools.logInfo);
			log.error(APITools.errorInfo);
	
		}
	

	public static void main(String[] args) {


	}

}
