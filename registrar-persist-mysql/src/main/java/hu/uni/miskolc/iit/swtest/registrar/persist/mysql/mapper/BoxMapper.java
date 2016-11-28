package hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.iit.swtest.registrar.model.Box;
import hu.uni.miskolc.iit.swtest.registrar.model.Box.BoxSize;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;

public interface BoxMapper {

	public Collection<Box> selectBoxes();

	public Collection<Box> selectBoxesByProduct(@Param("product") Product product);

	public Collection<Box> selectBoxesByBoxSize(@Param("boxSize") BoxSize boxSize);

	public Box selectBoxByID(@Param("id") long id);

	public void recordBox(@Param("product") long product, @Param("count") int count, @Param("boxSize") BoxSize boxSize);

	public void updateBox(@Param("box") Box box);

	public void deleteBox(@Param("box") Box box);

}
