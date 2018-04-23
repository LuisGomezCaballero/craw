package craw.jdbc.service;

import craw.model.ErrorBean;
import craw.model.ParamsBean;

public interface JdbcService {

	public ErrorBean comprobarConectividad(ParamsBean paramsBean);

	public ErrorBean mostrarMetadatos(ParamsBean paramsBean);

	public ErrorBean realizarConsulta(ParamsBean paramsBean);
	
}