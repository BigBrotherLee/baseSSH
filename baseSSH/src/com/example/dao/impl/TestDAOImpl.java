package com.example.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.example.dao.TestDAO;
import com.example.pojo.entity.TestUser;

public class TestDAOImpl implements TestDAO {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public List<TestUser> getAll() {
		String hql="from TestUser";
		List<TestUser> users=(List<TestUser>) hibernateTemplate.find(hql);
		return users;
	}

}
