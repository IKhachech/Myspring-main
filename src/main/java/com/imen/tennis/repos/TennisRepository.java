package com.imen.tennis.repos;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.imen.tennis.entities.Stats;
import com.imen.tennis.entities.WTA_Tour;
@RepositoryRestResource(path = "rest")
public interface TennisRepository extends JpaRepository<WTA_Tour, Long> {
    List<WTA_Tour> findByNameTourContains(String name);
    List<WTA_Tour> findByNameTour(String name);
    @Query("select t from WTA_Tour t where t.nameTour like %?1 and t.dotation >= ?2") 
    List<WTA_Tour> findByNamedot(String name, Double dot);
    @Query("select t from WTA_Tour t where t.stats = ?1")
    List<WTA_Tour> findByStats (Stats stats);
    List<WTA_Tour> findByOrderByNameTourAsc();
    List<WTA_Tour> findByStatsIdStat(Long idStat);
    @Query("select t from WTA_Tour t order by t.nameTour ASC, t.dotation DESC")
    List<WTA_Tour> trierWTA_TourNameDot();
    
    
}


