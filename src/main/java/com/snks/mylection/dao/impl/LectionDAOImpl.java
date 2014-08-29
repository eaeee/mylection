package com.snks.mylection.dao.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.LectionDate;

@Repository
public class LectionDAOImpl implements LectionDAO{
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void addDefaultLection() {
		
		//создание дефолтной лекции
		Lection lection = new Lection();
		Date date = new Date();
		LectionDate lDate= new LectionDate();
		lDate.setAccessedDate(date);
		lDate.setCreationDate(date);
		lDate.setModifiedDate(date);
		lection.setLastModifiedUserId(1);
		lection.setLectionDate(lDate);
		lection.setLectionBody("Какой-то невероятно большой текст!!! Это тело лекции короче. Дефолтная лекция");
		
		//запись ее в базу
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(lection);
		session.getTransaction().commit();
		session.close();

		
		
	}
	

}
