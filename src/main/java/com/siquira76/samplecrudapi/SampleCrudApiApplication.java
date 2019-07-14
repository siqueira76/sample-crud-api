package com.siquira76.samplecrudapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.siquira76.samplecrudapi.domain.Place;
import com.siquira76.samplecrudapi.repositories.PlaceRepositoty;

@SpringBootApplication
public class SampleCrudApiApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(SampleCrudApiApplication.class, args);
	}
	
	@Autowired
	PlaceRepositoty placeRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		placeRepository.deleteAll();
		
		Place p1 =  new Place(null, "casa1", 22, "Monte gordo", "Bahia");
		Place p2 =  new Place(null, "casa2", 23, "Monte gordo", "Bahia");
		Place p3 =  new Place(null, "casa3", 24, "Monte gordo", "Bahia");
		Place p4 =  new Place(null, "casa4", 25, "Monte gordo", "Bahia");
		
		placeRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		
		
	}

}
