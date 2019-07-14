package com.siquira76.samplecrudapi.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siquira76.samplecrudapi.Services.exceptions.ObjectNotFondException;
import com.siquira76.samplecrudapi.domain.Place;
import com.siquira76.samplecrudapi.repositories.PlaceRepositoty;

@Service
public class PlaceService {
	
	@Autowired
	PlaceRepositoty repository;
	
	public List<Place> findAll(){
		return repository.findAll();
	}
	
	public Place findById(Integer id) {
		Optional<Place> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFondException("Objeto não emcontrado id: " 
		+ id + ", Tipo: " + Place.class.getName()));
	}
	
	public Place insert(Place place) {
		return repository.save(place);
	}
	
	public Place update(Place obj) {
		Place newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
	
	private void updateData(Place newObj, Place obj) {
		newObj.setName(obj.getName());
		newObj.setCity(obj.getCity());
		newObj.setSlug(obj.getSlug());
		newObj.setState(obj.getState());
		newObj.setUpdatedAt(LocalDateTime.now());
	}

}
