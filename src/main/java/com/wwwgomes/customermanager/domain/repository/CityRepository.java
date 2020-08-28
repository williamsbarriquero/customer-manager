package com.wwwgomes.customermanager.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wwwgomes.customermanager.domain.entities.City;
import com.wwwgomes.customermanager.domain.enums.State;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	Optional<List<City>> findByNameOrderByNameDesc(String name);
	
	Optional<List<City>> findByStateOrderByNameDesc(State state);
	
	Optional<Page<City>> findByStateOrderByNameDesc(State state, Pageable page);

}
