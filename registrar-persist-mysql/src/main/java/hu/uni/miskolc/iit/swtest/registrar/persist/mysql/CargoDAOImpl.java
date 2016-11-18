package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import hu.uni.miskolc.iit.swtest.registrar.model.Cargo;
import hu.uni.miskolc.iit.swtest.registrar.persist.CargoDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.CargoNotFoundException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingCargoException;

public class CargoDAOImpl implements CargoDAO {

private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
    private SqlSessionFactory sqlSessionFactory;

    public CargoDAOImpl(String mybatisConfigPath, String host, int port, String database, String user, String password)
			throws FileNotFoundException {
		File configFile = new File(mybatisConfigPath);
		InputStream inputStream = new FileInputStream(configFile);
		String url = String.format("jdbc:mysql://%s:%s/%s", host, port, database);
		Properties props = new Properties();
		props.put("driver", JDBC_DRIVER);
		props.put("url", url);
		props.put("username", user);
		props.put("password", password);
		this.sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream, props);
	}
	
	@Override
	public void createCargo(Cargo cargo) throws ExistingCargoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Cargo> readCargos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cargo> readCargosBySource(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cargo> readCargosDestination(String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cargo readCargo(long id) throws CargoNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCargo(Cargo cargo) throws CargoNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCargo(Cargo cargo) throws CargoNotFoundException {
		// TODO Auto-generated method stub

	}

}
