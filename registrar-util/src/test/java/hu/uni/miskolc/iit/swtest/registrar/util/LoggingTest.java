package hu.uni.miskolc.iit.swtest.registrar.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;

public class LoggingTest {

	private static Logger LOG = LogManager.getFormatterLogger(LoggingTest.class);
	
	@Test
	public void test() {
		LOG.info("info test");
		LOG.warn("warn test");
		LOG.error("error test");
	}
}
