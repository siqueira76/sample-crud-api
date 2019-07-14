package com.siquira76.samplecrudapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siquira76.samplecrudapi.domain.Place;

@Repository
public interface PlaceRepositoty extends JpaRepository<Place, Integer> {

}
