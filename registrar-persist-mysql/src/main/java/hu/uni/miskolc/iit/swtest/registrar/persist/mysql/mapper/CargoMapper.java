package hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;
import hu.uni.miskolc.iit.swtest.registrar.model.Box;
import hu.uni.miskolc.iit.swtest.registrar.model.Cargo;

public interface CargoMapper {

	public Collection<Cargo> selectCargos();
	
	public Collection<Cargo> selectCargosBySource(@Param("source") Address source);
	
	public Collection<Cargo> selectCargosByDestination(@Param("destination") Address destination);
	
	public Cargo selectCargoById(@Param("id") long id);
	
	public void recordCargo(@Param("boxes") Collection<Box> boxes, @Param("source") Address source, @Param("destination") Address destination);
	
	public void deleteCargo(@Param("cargo") Cargo cargo);
	
	public void updateCargo(@Param("cargo") Cargo cargo);
	
}
