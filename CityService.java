package org.learn.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.learn.java.City;
import org.learn.java.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityService implements ICityService{
	@Autowired
    private CityRepository repository;
	
	
	
	
	@Override
	public List<City> findAll() {
		List<City> cities = repository.getallcities();
        
        return cities;
	}

	//added by me
	@Override
	public List<City> deleteOneCity(Long id) {
		
		List<City> cities = repository.getallcities();
	       repository.deleteById(id);
		/*
		 * for(City c : cities) System.out.println("After Deleting " +c);
		 */
	       return cities;
	}

	@Override
	public List<City> sortcitiesbyName() {
		
		//List<City> cities = (List<City>) repository.findAll();
		List<City> cities = repository.getallcities();
		Collections.sort(cities, new Comparator <City>() {
			
			@Override
			public int compare(City o1, City o2) {
							return o1.getName().compareTo(o2.getName() );}
		   });		
		       return cities;
		/*
		 * for(City c : cities) System.out.println("After sorting by Name " +c); return
		 * cities;
		 */
	}

	@Override
	public List<City> sortcitiesbyPopulation() {
		//List<City> cities = (List<City>) repository.findAll();
		List<City> cities = repository.getallcities();
		Collections.sort(cities, new Comparator <City>() {
		@Override
			public int compare(City o1, City o2) {
		return o1.getPopulation().compareTo(o2.getPopulation() );}
		   });				   
		/*
		 * for(City c : cities) System.out.println("After sorting by population " +c);
		 */
			  return cities;
	}

	

	
	
}
