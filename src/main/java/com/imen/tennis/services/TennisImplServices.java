package com.imen.tennis.services;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imen.tennis.entities.Image;
import com.imen.tennis.entities.Stats;
import com.imen.tennis.entities.WTA_Tour;
import com.imen.tennis.repos.ImageRepository;
import com.imen.tennis.repos.TennisRepository;

@Service
public class TennisImplServices implements TennisServices {

    @Autowired
    TennisRepository tennisRepository;
    
    @Autowired
    ImageRepository imageRepository;
    
	@Override
	public WTA_Tour saveWTA_Tour(WTA_Tour t) {
	return tennisRepository.save(t);
	}
	/*@Override
	public WTA_Tour updateWTA_Tour(WTA_Tour t) { 
		return tennisRepository.save(t);
	}*/
	
	@Override
	public WTA_Tour updateWTA_Tour(WTA_Tour p) {
	//Long oldTourImageId = this.getWTA_Tour(p.getIdTour()).getImage().getIdImage();
	//Long newTourImageId = p.getImage().getIdImage();
	WTA_Tour TourUpdated = tennisRepository.save(p);
	
	//if (oldTourImageId != newTourImageId) //si l'image a été modifiée
	//imageRepository.deleteById(oldTourImageId);
	return TourUpdated;
	}
	
	@Override
	public void deleteWTA_Tour(WTA_Tour t) { tennisRepository.delete(t);
	}
	@Override
	public void deleteWTA_TourById(Long id) {
		WTA_Tour p = getWTA_Tour(id);
		//suuprimer l'image avant de supprimer le produit
		//try {
		//Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
		//} catch (IOException e) {
		//e.printStackTrace();
		//}
		if (p != null) {
	        // Iterate over the list of images and delete each one
	       List<Image> images = p.getImages();
	        if (images != null) {
	            for (Image image : images) {
	                 //delete the image from the database
	                imageRepository.deleteById(image.getIdImage()); // Assuming Image entity has an id field
	           }
	        }
		
		tennisRepository.deleteById(id);
	}}
	
	//@Override
	//public void deletePlatById(long id) {
	  //  Plat plat = platRepository.findById(id).orElse(null);

	   // if (plat != null) {
	        // Iterate over the list of images and delete each one
	      //  List<Image> images = plat.getImages();
	      //  if (images != null) {
	            //for (Image image : images) {
	                // Delete the image from the database
	              //  imageRepository.deleteById(image.getIdImage()); // Assuming Image entity has an id field
	            //}
	       // }

	        // Finally, delete the Plat
	    //    platRepository.deleteById(id);
	  //  }
	//}

	
	@Override
	public WTA_Tour getWTA_Tour(Long id) { return tennisRepository.findById(id).get();
	}
	@Override
	public List<WTA_Tour> getAllWTA_Tour() { return tennisRepository.findAll();
	}
	
	@Override
	public List<WTA_Tour> findByNamedot(String name, Double dot) {
		return tennisRepository.findByNamedot(name, dot);
	}
	@Override
	public List<WTA_Tour> findByStats(Stats stats) {
		return tennisRepository.findByStats(stats);
	}
	@Override
	public List<WTA_Tour> findByNameTour(String name) {
		return tennisRepository.findByNameTour(name);
	}
	
	
	
	
	@Override
	public List<WTA_Tour> findByNameTourContains(String name) {
		return  tennisRepository.findByNameTourContains(name);
	}
	@Override
	public List<WTA_Tour> findByStatsIdStat(Long idStat) {
		return tennisRepository.findByStatsIdStat(idStat);
	}
	@Override
	public List<WTA_Tour> findByOrderByNameTourAsc() {
		return tennisRepository.findByOrderByNameTourAsc();
	}
	@Override
	public List<WTA_Tour> trierWTA_TourNameDot() {
		return tennisRepository.trierWTA_TourNameDot();
	}
	}




