package hu.uni.miskolc.iit.swtest.registrar.persist;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.registrar.model.Cargo;

public interface CargoDAO {
	public void createCargo(Cargo cargo) throws ExistingCargoException;

	public Collection<Cargo> readCargos();
	public Collection<Cargo> readCargosBySource(String source);
	public Collection<Cargo> readCargosDestination(String destination);

	public Cargo readCargo(long id) throws CargoNotFoundException;

	public void updateCargo(Cargo cargo) throws CargoNotFoundException;

	public void deleteCargo(Cargo cargo) throws CargoNotFoundException;
}
