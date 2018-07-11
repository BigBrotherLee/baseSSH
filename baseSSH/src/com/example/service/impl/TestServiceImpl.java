package com.example.service.impl;

import java.util.List;

import com.example.dao.TestDAO;
import com.example.pojo.entity.TestUser;
import com.example.service.TestService;

public class TestServiceImpl implements TestService {
	private TestDAO testDAO;

	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}

	@Override
	public List<TestUser> getAll() {
		return testDAO.getAll();
	}

}
