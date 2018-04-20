package craw.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import craw.jdbc.dao.JdbcDao;

@Service
public class JdbcServiceImpl implements JdbcService {

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public Boolean comprobarTabla() {

		return jdbcDao.comprobarTabla();
	}

}
