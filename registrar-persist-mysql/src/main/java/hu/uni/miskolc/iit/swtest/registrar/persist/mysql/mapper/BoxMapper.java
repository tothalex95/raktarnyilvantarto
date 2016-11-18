package hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.iit.swtest.registrar.model.Box;

public interface BoxMapper {

	public Collection<Box> selectBoxes();
	
	public Box selectBoxByID(@Param("id") long id);
	
	public void updateBox(@Param("box") Box box);
	
	public void deleteBox(@Param("box") Box box);
	
}
