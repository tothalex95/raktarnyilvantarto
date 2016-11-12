package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		assertNotNull(System.getProperty("database.host"));
	}

}
