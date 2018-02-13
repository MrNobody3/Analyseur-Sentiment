package com.service;

import java.util.List;

import com.bo.Commentaire;
import com.bo.Destination;

public interface TouristService {

	public List<Destination> getAllDestinations();

	public Destination getDestinationById(Long id);
	
	public void updateDestination(Destination pDestination);
	
	public void addCommentaire(Commentaire pCommentaire);
	
	public void updateCommentaire(Commentaire pCommentaire);
	
	public List<Commentaire> getAllCommentaire();
}
