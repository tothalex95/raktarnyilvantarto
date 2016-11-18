package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.mysql.jdbc.Driver;

public class SetupDBTests {

	public static final String MYBATIS_CONFIG_FILE = "src/main/resources/mybatis-configuration.xml";
	public static final String TEST_CREATE_TABLES = "src/main/resources/createTables.sql";
	public static final String TEST_DROP_TABLES = "src/main/resources/dropTables.sql";
	public static final String TEST_SETUP_SQL = "src/main/resources/populateDB.sql";
	public static final String TEST_TEAR_DOWN_SQL = "src/main/resources/clearDB.sql";

	protected static String HOST;
	protected static int PORT;
	protected static String DATABASE;
	protected static String USER;
	protected static String PASSWORD;
	
	/**
	 * It checks the existence of the required script files and properties. The
	 * tests are ignored, if anything is missing.
	 * 
	 * It also set up the database and create tables.
	 */
	@BeforeClass
	public static void beforeClass() {
		/* Check SQL Scripts */
		File mybatisConfig = new File(MYBATIS_CONFIG_FILE);
		File createTablesSQL = new File(TEST_CREATE_TABLES);
		File dropTablesSQL = new File(TEST_DROP_TABLES);
		File setupTestSQL = new File(TEST_SETUP_SQL);
		File teardownSQL = new File(TEST_TEAR_DOWN_SQL);

		// System.out.println(mybatisConfig.exists());
		// System.out.println(createTablesSQL.exists());
		// System.out.println(dropTablesSQL.exists());
		// System.out.println(setupTestSQL.exists());
		// System.out.println(teardownSQL.exists());

		Assume.assumeTrue(mybatisConfig.exists());
		Assume.assumeTrue(createTablesSQL.exists());
		Assume.assumeTrue(dropTablesSQL.exists());
		Assume.assumeTrue(setupTestSQL.exists());
		Assume.assumeTrue(teardownSQL.exists());

		/* Check System Properties */
		String host = System.getProperty("database.host");

		int port = -1;
		try {
			port = Integer.parseInt(System.getProperty("database.port"));
		} catch (NumberFormatException ex) {
			port = -1;
			Assume.assumeNoException(ex);
		}
		String database = System.getProperty("database.db");
		String user = System.getProperty("database.user");
		String password = System.getProperty("database.password");
		Assume.assumeNotNull(host, port, database, user, password);
		HOST = host;
		PORT = port;
		DATABASE = database;
		USER = user;
		PASSWORD = password;

		try {
			runSQLScript(TEST_CREATE_TABLES);
		} catch (Exception e) {
			Assume.assumeNoException(e);
		}

	}

	/**
	 * It drops the created tables.
	 */
	@AfterClass
	public static void afterClass() {
		try {
			runSQLScript(TEST_DROP_TABLES);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assume.assumeNoException(e);
		}
//		System.out.println("bye bye");
	}

	private static void runSQLScript(String scriptFile)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		Class.forName(Driver.class.getName());
		final String connectionURL = String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DATABASE);
		Connection connection = DriverManager.getConnection(connectionURL, USER, PASSWORD);
		connection.setAutoCommit(false);
		ScriptRunner runner = new ScriptRunner(connection);
		runner.setStopOnError(true);
		Reader reader = new FileReader(scriptFile);
		if (!connection.getAutoCommit()) {
			connection.commit();
		}
		runner.runScript(reader);
		runner.closeConnection();
		connection.close();
		reader.close();
	}

	/**
	 * It instantiate the DAO object and insert the test data into the test
	 * database.
	 */
	@Before
	public void setUp() {
		/* INSERT TEST RECORDS */
		try {
			runSQLScript(TEST_SETUP_SQL);
		} catch (Exception e) {
			Assume.assumeNoException(e);
		}
	}

	/**
	 * It deletes the records from the test database.
	 */
	@After
	public void tearDown() {
		try {
			runSQLScript(TEST_TEAR_DOWN_SQL);
		} catch (Exception e) {
			Assume.assumeNoException(e);
		}
	}
}
