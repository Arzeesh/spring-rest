package org.learn.java;



import java.util.List;

import org.learn.java.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
	
	@Repository
	public interface CityRepository extends JpaRepository<City, Long> {

		@Procedure(name = "GetAllCities")
		List<City> getallcities(); 
}
