package com.imen.tennis.services;
import java.util.List;

import com.imen.tennis.entities.Stats;
import com.imen.tennis.entities.WTA_Tour ;
public interface TennisServices {
	WTA_Tour saveWTA_Tour(WTA_Tour t);
	WTA_Tour updateWTA_Tour(WTA_Tour t);
	void deleteWTA_Tour(WTA_Tour t);
	void deleteWTA_TourById(Long id);
	WTA_Tour getWTA_Tour(Long id);
	List<WTA_Tour> getAllWTA_Tour();
	List<WTA_Tour> findByNameTour(String name);
	List<WTA_Tour> findByNameTourContains(String name);
	List<WTA_Tour> findByNamedot (String name, Double dot);
	List<WTA_Tour> findByStats(Stats stats);
	List<WTA_Tour> findByStatsIdStat(Long idStat);
	List<WTA_Tour> findByOrderByNameTourAsc();
	List<WTA_Tour> trierWTA_TourNameDot();
	}




