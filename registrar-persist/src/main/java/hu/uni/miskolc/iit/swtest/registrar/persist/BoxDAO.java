package hu.uni.miskolc.iit.swtest.registrar.persist;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.registrar.model.Box;
import hu.uni.miskolc.iit.swtest.registrar.model.Box.BoxSize;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;

public interface BoxDAO {
	
	public void createBox(Box box) throws ExistingBoxException;
	
	public Collection<Box> readBoxes();
	public Collection<Box> readBoxesByWeight(float weight);
	public Collection<Box> readBoxesByProduct(Product product);
	public Collection<Box> readBoxesByBoxSize(BoxSize boxsize);
	
	public Box readBox(Box box) throws BoxNotFoundException;
	
	public void updateBox(Box box) throws BoxNotFoundException;
	
	public void deleteBox(Box box) throws BoxNotFoundException;
	
}
