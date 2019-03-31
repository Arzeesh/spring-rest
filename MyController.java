package org.learn.java;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.learn.java.GeneratePdfReport;
import org.learn.java.City;


@RestController

public class MyController {

	
	 @Autowired
	    ICityService cityService;

	    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> citiesreport() throws IOException {

	        List<City> cities = (List<City>) cityService.findAll();
	       // List<City> cities2 =  cityService.sortcitiesbyName();

	        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	    
	    
	    @RequestMapping(value = "/sortedcities", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> sortedcitiesReport() throws IOException {

	       // List<City> cities = (List<City>) cityService.findAll();
	        List<City> cities2 =  cityService.sortcitiesbyName();

	        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities2);	

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=sortedcitiesreport.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	    
	    @RequestMapping(value = "/sortedpopulation", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> sortedpopulationReport() throws IOException {

	       // List<City> cities = (List<City>) cityService.findAll();
	        List<City> cities3 =  cityService.sortcitiesbyPopulation();

	        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities3);	

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=sortedpopulationreport.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	    
	    @RequestMapping(value = "/deletecity/{id}", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> deletecityReport(@PathVariable("id") Long id ) throws IOException {

	       // List<City> cities = (List<City>) cityService.findAll();
	        List<City> cities4 =  cityService.deleteOneCity(id);

	        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities4);	

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=deletedcityreport.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
}
