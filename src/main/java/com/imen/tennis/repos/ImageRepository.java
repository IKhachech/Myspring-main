package com.imen.tennis.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imen.tennis.entities.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {

}
