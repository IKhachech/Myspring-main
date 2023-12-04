package com.imen.tennis;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.imen.tennis.entities.Stats;
import com.imen.tennis.entities.WTA_Tour;
import com.imen.tennis.repos.TennisRepository;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class Spring01ApplicationTests {
	@Autowired
	private TennisRepository tennisRepository;
	@Test
	public void testCreateWTA_Tour() {
		WTA_Tour tour = new WTA_Tour("Hard", 110.1, new Date(), "Australian Open", "Aryana Sabalenka");	
		tennisRepository.save(tour);
		}
	@Test
	public void testFindWTA_Tour()
	{ WTA_Tour t = tennisRepository.findById(2L).get(); System.out.println(t);
	}
	@Test
	public void testUpdateWTA_Tour()
	{ WTA_Tour t = tennisRepository.findById(1L).get();
	t.setDotation(60.0); tennisRepository.save(t);
	}
	@Test
	public void testDeleteWTA_Tour()
	{ tennisRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousWTA_Tours()
	{
	List<WTA_Tour> tours = tennisRepository.findAll();
	for (WTA_Tour t : tours)
	{
	System.out.println(t);
	}
	}
	
	@Test
	public void testFindByNameTour()
	{
	List<WTA_Tour> tours = tennisRepository.findByNameTour("Australian Open");
	for (WTA_Tour t : tours)
	{
	System.out.println(t);
	}
	}
	@Test
	public void testFindByNameWTA_TourContains()
	{
	List<WTA_Tour> tours= tennisRepository.findByNameTourContains("US Open");
	for (WTA_Tour t : tours)
	{
	System.out.println(t);
	} }
	
	@Test
	public void testfindByNamedot()
	{
	List<WTA_Tour> tours = tennisRepository.findByNamedot("Australian Open",55000000.0);
	for (WTA_Tour t : tours)
	{
	System.out.println(t);
	}
	}
	
	
	@Test
	public void testfindByStats()
	{
	Stats stats = new Stats();
	stats.setIdStat(1L);
	List<WTA_Tour> tours = tennisRepository.findByStats(stats);
	for (WTA_Tour t : tours)
	{
	System.out.println(t);
	}
	}
	
	
	
	@Test
	public void findByStatsIdStats()
	{
	List<WTA_Tour> tours = tennisRepository.findByStatsIdStat(1L);
	for (WTA_Tour t : tours)
	{
	System.out.println(t);
	}
	}

	
	@Test
	public void testfindByOrderByNameTourAsc()
	{
	List<WTA_Tour> tours = tennisRepository.findByOrderByNameTourAsc();
	for (WTA_Tour t : tours)
	{
	System.out.println(t);
	}
	}
	
	
	@Test public void testTrierWTA_TourNameDot()
	{
	List<WTA_Tour> tours = tennisRepository.trierWTA_TourNameDot();
	for (WTA_Tour t : tours)
	{
	System.out.println(t);
	}
	}

}


