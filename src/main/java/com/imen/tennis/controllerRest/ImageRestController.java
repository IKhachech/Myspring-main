package com.imen.tennis.controllerRest;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	import org.springframework.web.multipart.MultipartFile;
	import com.imen.tennis.entities.Image;
import com.imen.tennis.entities.WTA_Tour;
import com.imen.tennis.services.ImageService;
import com.imen.tennis.services.TennisServices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
	@RestController
	@RequestMapping("/api/image")
	@CrossOrigin(origins ="http://localhost:4200")
	public class ImageRestController {
		@Autowired
		ImageService imageService ;
		
		@Autowired
		TennisServices tennisService;
		
		@RequestMapping(value = "/upload" , method = RequestMethod.POST)
		public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
		}
		
		@PostMapping(value = "/uplaodImageTour/{idTour}" )
		public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
		@PathVariable("idTour") Long idTour)
		throws IOException {
		return imageService.uplaodImageTour(file,idTour);
		}
		
		@RequestMapping(value = "/getImagesTour/{idTour}" ,method = RequestMethod.GET)
		public List<Image> getImagesTour(@PathVariable("idTour") Long idTour) throws IOException { return imageService.getImagesParTour(idTour);
		}
		
		
		@RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
		public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id) ;
		}
		@RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
		public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException { return imageService.getImage(id);
		}
		@RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
		public void deleteImage(@PathVariable("id") Long id){
		imageService.deleteImage(id);
		}
		@RequestMapping(value="/update",method = RequestMethod.PUT)
		public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
		}
		
		@RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
		public void uploadImageFS(@RequestParam("image") MultipartFile file,@PathVariable("id") Long id) throws IOException {
		WTA_Tour p = tennisService.getWTA_Tour(id);
		p.setImagePath(id+".jpg");
		Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()), file.getBytes());
		tennisService.saveWTA_Tour(p);
		}
		
		@RequestMapping(value = "/loadfromFS/{id}" ,
		method = RequestMethod.GET,
		produces = MediaType.IMAGE_JPEG_VALUE)
		public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
		WTA_Tour p = tennisService.getWTA_Tour(id);
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
		}
		
		
		
		}
