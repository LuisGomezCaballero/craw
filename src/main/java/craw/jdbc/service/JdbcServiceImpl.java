package craw.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import craw.jdbc.dao.JdbcDao;
import craw.model.ErrorBean;
import craw.model.ParamsBean;

@Service
public class JdbcServiceImpl implements JdbcService {

	@Autowired
	JdbcDao jdbcDao;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ErrorBean comprobarConectividad(ParamsBean paramsBean) {

		String url = "http://localhost:8081/operaciones/registraroperacion";
		String param = "Mensaje para enviar a la otra aplicación.";

		Object response = restTemplate.postForObject(url, param, String.class);
		
		System.out.println("comprobarConectividad: " + response);

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
