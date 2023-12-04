package com.imen.tennis.controllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imen.tennis.entities.Stats;
import com.imen.tennis.repos.StatRepository;
@RestController
@RequestMapping("/api/st")
@CrossOrigin("*")
public class statControllerRest {
	
	@Autowired
	StatRepository statRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Stats> getAllCategories()
	{
	return statRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Stats getStatById(@PathVariable("id") Long id) {
	return statRepository.findById(id).get();
	}
	
	}

