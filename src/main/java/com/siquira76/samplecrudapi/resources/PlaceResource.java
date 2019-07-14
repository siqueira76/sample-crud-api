package com.siquira76.samplecrudapi.resources;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.siquira76.samplecrudapi.Services.PlaceService;
import com.siquira76.samplecrudapi.domain.Place;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/places")
public class PlaceResource {
	
	@Autowired
	PlaceService service;
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="List all places")
	public ResponseEntity<List<Place>> findAll() {
		List<Place> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value="Find a place by Id")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Place obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ApiOperation(value="Inser a new place")
	public ResponseEntity<Void> insert(@RequestBody Place placeObj) {
		placeObj.setCreatedAt(LocalDateTime.now());
		Place obj = service.insert(placeObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation(value="Update a place")
	public ResponseEntity<Void> update(@RequestBody Place placeObj, @PathVariable Integer id) {
		Place obj = placeObj;
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build(); // retorna o codigo 204
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value="Delete a place")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); // retorna o codigo 204
	}

}
