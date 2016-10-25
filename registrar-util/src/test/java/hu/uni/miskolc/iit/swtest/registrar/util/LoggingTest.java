package hu.uni.miskolc.iit.swtest.registrar.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;

public class LoggingTest {

	private static Logger rootLOG = LogManager.getFormatterLogger(LoggingTest.class);
	private static Logger contrLOG = LogManager.getLogger("hu.uni.miskolc.iit.swtest.registrar.controller");
	private static Logger modLOG = LogManager.getLogger("hu.uni.miskolc.iit.swtest.registrar.model");
	private static Logger persLOG = LogManager.getLogger("hu.uni.miskolc.iit.swtest.registrar.persist");
	private static Logger servLOG = LogManager.getLogger("hu.uni.miskolc.iit.swtest.registrar.service");

	@Test
	public void testRoot() {
		rootLOG.info("root info test");
		rootLOG.warn("root warn test");
		rootLOG.error("root error test");
		rootLOG.fatal("root fatal test");
	}

	@Test
	public void testController() {
		contrLOG.info("controller info test");
		contrLOG.warn("controller warn test");
		contrLOG.error("controller error test");
		contrLOG.fatal("controller fatal test");

	}

	@Test
	public void testModel() {
		modLOG.info("model info test");
		modLOG.warn("model warn test");
		modLOG.error("model error test");
		modLOG.fatal("model fatal test");
	}

	@Test
	public void testPersist() {
		persLOG.info("persist info test");
		persLOG.warn("persist warn test");
		persLOG.error("persist error test");
		persLOG.fatal("persist fatal test");
	}

	@Test
	public void testService() {
		servLOG.info("service info test");
		servLOG.warn("service warn test");
		servLOG.error("service error test");
		servLOG.fatal("service fatal test");
	}
}
