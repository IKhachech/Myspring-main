package com.imen.tennis.services;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.imen.tennis.entities.Image;

public interface ImageService {
Image uplaodImage(MultipartFile file) throws IOException;
Image getImageDetails(Long id) throws IOException;
ResponseEntity<byte[]> getImage(Long id) throws IOException;
void deleteImage(Long id);

Image uplaodImageTour(MultipartFile file,Long idTour) throws IOException; 
List<Image> getImagesParTour(Long tourId);
}
