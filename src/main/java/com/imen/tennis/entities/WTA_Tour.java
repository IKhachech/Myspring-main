package com.imen.tennis.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class WTA_Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTour;
    private String nameTour;
    private Double dotation;
    private Date dateTour;
    private String courtSurface;
    private String winner;

    @ManyToOne
    private Stats stats;
    

	/*@OneToOne
    private Image image;*/
    
	private String imagePath;

	
	
    @OneToMany(mappedBy = "wta_Tour", fetch = FetchType.EAGER)
    private List<Image> images;
    // Getters and setters for the fields
    public WTA_Tour(String nameTour, Double dotation, Date dateTour, String courtSurface, String winner) {
		super();
		this.nameTour = nameTour;
		this.dotation = dotation;
		this.dateTour = dateTour;
		this.courtSurface = courtSurface;
		this.winner = winner;
	}
    
    
    public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public WTA_Tour() {
    	super();
    	}
    public Long getIdTour() {
        return idTour;
    }

    public void setIdTour(Long idTour) {
        this.idTour = idTour;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public Double getDotation() {
        return dotation;
    }

    public void setDotation(Double dotation) {
        this.dotation = dotation;
    }

    public Date getDateTour() {
        return dateTour;
    }

    public void setDateTour(Date dateTour) {
        this.dateTour = dateTour;
    }

    public String getCourtSurface() {
        return courtSurface;
    }

    public void setCourtSurface(String courtSurface) {
        this.courtSurface = courtSurface;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
	@Override
	public String toString() {
		return "WTA_Tour [idTour=" + idTour + ", stats=" + stats + ", nameTour=" + nameTour + ", dotation=" + dotation
				+ ", dateTour=" + dateTour + ", courtSurface=" + courtSurface + ", winner=" + winner + "]";
	}


	public List<Image> getImages() {
		return images;
	}


	public void setImages(List<Image> images) {
		this.images = images;
	}
    
}
