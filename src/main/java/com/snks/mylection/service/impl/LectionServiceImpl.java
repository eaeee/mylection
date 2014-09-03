package com.snks.mylection.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.LectionDate;
import com.snks.mylection.model.Subject;
import com.snks.mylection.model.User;
import com.snks.mylection.model.json.LectionJSON;
import com.snks.mylection.service.LectionService;
import com.snks.mylection.service.SubjectClassificationService;
import com.snks.mylection.service.SubjectService;

@Service
@Transactional
public class LectionServiceImpl implements LectionService {
	@Autowired
	private LectionDAO lectionDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private SubjectService subjectService;
	


	@Override
	public void save(Lection lection, String name) {
		User user=  userDao.findUserByName(name);
		lection.setAuthor(user);
		lectionDao.save(lection);
	}


	@Override
	public void saveFromJSON(LectionJSON lect) {
		String userName = lect.lectionAuthor;
		User user = userDao.findUserByName(userName);
		Lection lection = new Lection();
		lection.setAuthor(user);
		lection.setLectionBody(lect.lectionBody);
		lection.setLectionName(lect.lectionName);
		Subject subject = subjectService.findByName(lect.subject);
		lection.setSubject(subject);
		LectionDate lectionDate = new LectionDate();
		lectionDate.setCreationDate(new Date(lect.lectionCreationDate));
		lectionDate.setAccessedDate(new Date(lect.lectionCreationDate));
		lectionDate.setModifiedDate(new Date(lect.lectionCreationDate));
		lection.setLectionDate(lectionDate);	
		lectionDao.save(lection);
		
	}


	@Override
	public void delete(int id) {
		lectionDao.delete(id);
		
	}


	@Override
	public List<Lection> findAll() {
		List<Lection> lections = lectionDao.findAll();
		return lections;
	}


	@Override
	public Lection findById(int id) {
		return lectionDao.findByid(id);
	}


	@Override
	public void updateFromJSON(LectionJSON lect,int id) {
		String userName = lect.lectionAuthor;
		User user = userDao.findUserByName(userName);
		Lection lection = new Lection();
		lection.setAuthor(user);
		lection.setLectionBody(lect.lectionBody);
		lection.setLectionName(lect.lectionName);
		LectionDate lectionDate = new LectionDate();
		lectionDate.setCreationDate(new Date(lect.lectionCreationDate));
		lectionDate.setAccessedDate(new Date(lect.lectionCreationDate));
		lectionDate.setModifiedDate(new Date(lect.lectionCreationDate));
		lection.setLectionDate(lectionDate);
		lection.setLectionId(id);
		lectionDao.update(lection);
		
	}

	@PreAuthorize("#lection.getAuthor().getUserName() == authentication.name or hasRole('ROLE_ADMIN')")
	@Override
	public void delete(@P("lection")Lection lection) {
		lectionDao.delete(lection);
		
	}


}
