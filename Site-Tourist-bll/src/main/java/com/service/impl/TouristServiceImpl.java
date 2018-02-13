package com.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Commentaire;
import com.bo.Destination;
import com.dao.CommentaireDao;
import com.dao.DestinationDao;
import com.service.TouristService;;
@Service
@Transactional
public class TouristServiceImpl implements TouristService{
	@Autowired
	private DestinationDao destinationDao;
	
	@Autowired
	private CommentaireDao commentaireDao;
	@Override
	public List<Destination> getAllDestinations() {
		return destinationDao.getAll();
	}

	@Override
	public Destination getDestinationById(Long id) {
		return destinationDao.findById(id);
	}

	@Override
	public void addCommentaire(Commentaire pCommentaire) {
		commentaireDao.create(pCommentaire);
		
	}

	@Override
	public void updateCommentaire(Commentaire pCommentaire) {
		commentaireDao.update(pCommentaire);		
	}

	@Override
	public List<Commentaire> getAllCommentaire() {
		return commentaireDao.getAll();
	}

	public DestinationDao getDestinationDao() {
		return destinationDao;
	}

	public void setDestinationDao(DestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}

	public CommentaireDao getCommentaireDao() {
		return commentaireDao;
	}

	public void setCommentaireDao(CommentaireDao commentaireDao) {
		this.commentaireDao = commentaireDao;
	}

	@Override
	public void updateDestination(Destination pDestination) {
		destinationDao.update(pDestination);
		
	}
	
}
