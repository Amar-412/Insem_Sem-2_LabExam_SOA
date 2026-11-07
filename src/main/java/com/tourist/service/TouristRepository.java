package com.tourist.service;

	import org.springframework.data.jpa.repository.JpaRepository;
	import com.tourist.service.Tourist;

	public interface TouristRepository extends JpaRepository<Tourist, Integer> {

	}

