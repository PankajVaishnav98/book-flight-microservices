package com.mindtree.learning.collegemvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.learning.collegemvc.model.BookFlight;

@Repository
public interface BookFlightRepo extends JpaRepository<BookFlight, Integer>{

	@Query(value = "Select f.uId from BookFlight f where f.fId = ?1")
	public List<Integer> getUids(int fId);
}
