package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import hu.uni.miskolc.iit.swtest.registrar.model.Box;
import hu.uni.miskolc.iit.swtest.registrar.model.Customer;
import hu.uni.miskolc.iit.swtest.registrar.model.Box.BoxSize;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;
import hu.uni.miskolc.iit.swtest.registrar.persist.BoxDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.BoxNotFoundException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingBoxException;
import hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper.BoxMapper;

public class BoxDAOImpl implements BoxDAO {

private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
    private SqlSessionFactory sqlSessionFactory;

    public BoxDAOImpl(String mybatisConfigPath, String host, int port, String database, String user, String password)
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
	public void createBox(Box box) throws ExistingBoxException {
		/*Collection<Box> similairBoxes = readBoxesByProduct(box.getProduct());
		if (!similairBoxes.isEmpty()) {
			throw new ExistingBoxException();
		}*/
		SqlSession session = sqlSessionFactory.openSession();
		BoxMapper mapper = session.getMapper(BoxMapper.class);
		mapper.recordBox(box.getProduct().getProductNumber(), box.getCount(), box.getBoxSize());
		session.commit();
		session.close();
	}

	@Override
	public Collection<Box> readBoxes() {
		Collection<Box> result = new ArrayList<Box>();
		SqlSession session = sqlSessionFactory.openSession();
		BoxMapper mapper = session.getMapper(BoxMapper.class);
		result = mapper.selectBoxes();
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Box> readBoxesByWeight(float weight) {
		Collection<Box> tmp = new ArrayList<Box>();
		SqlSession session = sqlSessionFactory.openSession();
		BoxMapper mapper = session.getMapper(BoxMapper.class);
		tmp = mapper.selectBoxes();
		Collection<Box> result = new ArrayList<>();
		for (Box box : tmp) {
			if (box.getWeight()==weight) {
				result.add(box);
			}
		}
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Box> readBoxesByProduct(Product product) {
		Collection<Box> result = new ArrayList<Box>();
		SqlSession session = sqlSessionFactory.openSession();
		BoxMapper mapper = session.getMapper(BoxMapper.class);
		result = mapper.selectBoxesByProduct(product);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Box> readBoxesByBoxSize(BoxSize boxsize) {
		Collection<Box> result = new ArrayList<Box>();
		SqlSession session = sqlSessionFactory.openSession();
		BoxMapper mapper = session.getMapper(BoxMapper.class);
		result = mapper.selectBoxesByBoxSize(boxsize);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Box readBox(long id) throws BoxNotFoundException {
		Box result = null;
		SqlSession session = sqlSessionFactory.openSession();
		BoxMapper mapper = session.getMapper(BoxMapper.class);
		result = mapper.selectBoxByID(id);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public void updateBox(Box box) throws BoxNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BoxMapper mapper = session.getMapper(BoxMapper.class);
			mapper.updateBox(box);
		} catch (Exception e) {
			throw new BoxNotFoundException(e);
		}
		session.commit();
		session.close();
	}

	@Override
	public void deleteBox(Box box) throws BoxNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BoxMapper mapper = session.getMapper(BoxMapper.class);
			mapper.deleteBox(box);
		} catch (Exception e) {
			throw new BoxNotFoundException(e);
		}
		session.commit();
		session.close();
	}

}
