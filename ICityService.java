package org.learn.java;

import java.util.List;
import org.learn.java.City;



public interface ICityService {

	
	public List <City> findAll();
	
	
	// the rest added by me 
	
	public List<City> deleteOneCity(Long id);
	
	public List<City> sortcitiesbyName();
	
	public List<City>  sortcitiesbyPopulation();
	
}
