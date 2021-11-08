package com.cg.sprint1.mvtktapp.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.sprint1.mvtktapp.sample.entity.Theatre;
import com.cg.sprint1.mvtktapp.sample.repository.TheatreRepository;
@Service
public class TheatreService 
{
	@Autowired
	TheatreRepository theatreRepository;
	
	@Transactional(readOnly=true)
	public Theatre getByTheatre(String theatreId)
	{
		Optional<Theatre> th = theatreRepository.findById(theatreId);
		if(th!=null)
			return th.get();
		throw new RuntimeException("No theatre found by that name found");
	}
	
	@Transactional(readOnly=true)
	public List<Theatre> getAllTheatre()
	{
		List<Theatre> tlist= theatreRepository.findAll();
		if(tlist.size()>0)
			return tlist;
		throw new RuntimeException("No Theatres Available") ;
	}
	
}
