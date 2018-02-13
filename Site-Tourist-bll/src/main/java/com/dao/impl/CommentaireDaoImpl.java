package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.bo.Commentaire;
import com.dao.CommentaireDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;
@Repository
public class CommentaireDaoImpl extends HibernateSpringGenericDaoImpl<Commentaire, Long> implements CommentaireDao{

	public CommentaireDaoImpl() {
		super(Commentaire.class);
		
	}

}
