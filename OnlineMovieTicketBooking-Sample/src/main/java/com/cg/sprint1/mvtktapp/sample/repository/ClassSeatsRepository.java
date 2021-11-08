package com.cg.sprint1.mvtktapp.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint1.mvtktapp.sample.entity.ClassSeats;

public interface ClassSeatsRepository extends JpaRepository<ClassSeats,Integer>
{
	
}
