package craw.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import craw.jdbc.dao.JdbcDao;
import craw.model.ErrorBean;
import craw.model.ParamsBean;

@Service
public class JdbcServiceImpl implements JdbcService {

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public ErrorBean comprobarConectividad(ParamsBean paramsBean) {

		return jdbcDao.comprobarConectividad(paramsBean);
	}

	@Override
	public ErrorBean mostrarMetadatos(ParamsBean paramsBean) {

		return jdbcDao.mostrarMetadatos(paramsBean);
	}

	@Override
	public ErrorBean realizarConsulta(ParamsBean paramsBean) {

		return jdbcDao.realizarConsulta(paramsBean);
	}

}
