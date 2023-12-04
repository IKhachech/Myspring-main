package com.imen.tennis.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import com.imen.tennis.entities.Image;
import com.imen.tennis.entities.WTA_Tour;
import com.imen.tennis.repos.ImageRepository;
import com.imen.tennis.repos.TennisRepository;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	ImageRepository imageRepository;

	@Autowired
	TennisRepository tennisRepository;
	
	@Autowired
	TennisServices tennisService;
	
	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
	/*Ce code commenté est équivalent au code utilisant le design pattern Builder
	* Image image = new Image(null, file.getOriginalFilename(),
	file.getContentType(), file.getBytes(), null);
	return imageRepository.save(image);*/
	return imageRepository.save(Image.builder()
	.name(file.getOriginalFilename())
	.type(file.getContentType())
	.image(file.getBytes()).build() );
	}
	@Override
	public Image getImageDetails(Long id) throws IOException{ final Optional<Image> dbImage = imageRepository. findById (id);
	return Image.builder()
	.idImage(dbImage.get().getIdImage())
	.name(dbImage.get().getName())
	.type(dbImage.get().getType())
	.image(dbImage.get().getImage()).build() ;
	}
	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException{ final Optional<Image> dbImage = imageRepository. findById (id);
	return ResponseEntity
	.ok()
	.contentType(MediaType.valueOf(dbImage.get().getType()))
	.body(dbImage.get().getImage());
	}
	@Override
	public void deleteImage(Long id) {
	imageRepository.deleteById(id);
	}
	
	@Override
	public Image uplaodImageTour(MultipartFile file,Long idTour)
	throws IOException {
    WTA_Tour  p = new WTA_Tour ();
	p.setIdTour(idTour);
	return imageRepository.save(Image.builder()
	.name(file.getOriginalFilename())
	.type(file.getContentType())
	.image(file.getBytes())
	.wta_Tour(p).build() );
	}
	@Override
	public List<Image> getImagesParTour(Long tourId) {	
		WTA_Tour p = tennisRepository.findById(tourId).get();
		return p.getImages();
	}
	
	
	
	}
