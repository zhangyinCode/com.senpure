package com.senpure.learn.netty.chat;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;



/**
 * 
 * log4j的实现
 * 
 * @author 罗中正
 * @version 1.0
 */
public class GameLoggerUtil {

	public GameLoggerUtil() {
		super();

	}

	static Map<Integer, Logger> loggers = new HashMap<>();

	public static Logger getGameLogger(int roomId) {
		Logger logger = null;
		logger = loggers.get(roomId);
		if (logger == null) {

			logger = Logger.getLogger("123"+roomId);

			logger.removeAllAppenders();


			logger.setLevel(Level.DEBUG);
			FileAppender appender = new DailyRollingFileAppender();
			PatternLayout layout = new PatternLayout();
			appender.setFile(getLogFilePath() + "log_" + roomId + ".log");

			// log的输出形式
			String conversionPattern = "%d{HH:mm:ss} [%p]- %m%n";
			layout.setConversionPattern(conversionPattern);
			appender.setLayout(layout);
			// log输出路径

			// log的文字码

				appender.setEncoding("UTF-8");


			// true:在已存在log文件后面追加 false:新log覆盖以前的log
			appender.setAppend(true);
			// 适用当前配置
			appender.activateOptions();

			// 設定是否繼承父Logger。
			// 默認為true。繼承root輸出。
			// 設定false後將不輸出root。
			logger.setAdditivity(false);
			// 将新的Appender加到Logger中

			logger.addAppender(appender);
			
			
			
			
			
			
			FileAppender warnappender = new DailyRollingFileAppender();
		
			
			
			warnappender.setThreshold(Level.WARN);

			warnappender.setFile(getLogFilePath() + "warnlog_" + roomId + ".log");

			// log的输出形式
	
		
			warnappender.setLayout(layout);
			// log输出路径

			// log的文字码

				warnappender.setEncoding("UTF-8");


			// true:在已存在log文件后面追加 false:新log覆盖以前的log
			warnappender.setAppend(true);
			// 适用当前配置
			warnappender.activateOptions();

		

			logger.addAppender(warnappender);
			


			ConsoleAppenderOutAndErr gameDebug = new ConsoleAppenderOutAndErr();
			layout = new PatternLayout();

			conversionPattern = "%d{HH:mm:ss} [%p]- %m%x%n";
			layout.setConversionPattern(conversionPattern);
			gameDebug.setLayout(layout);
			gameDebug.setTarget("System.out");
			gameDebug.activateOptions();
				logger.addAppender(gameDebug);

			loggers.put(roomId, logger);

		}

		return logger;
	}

	private static String getLogFilePath() {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("linux")) {
			return "../hpplog/";
		}

		return "/D:/logs/senpure/";
	}

	public static void main(String[] args) {

		Logger log = getGameLogger(123);

	
		log.debug("123 年后");

	}

}
