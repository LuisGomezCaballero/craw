package craw.jdbc.dao;

import craw.model.ErrorBean;
import craw.model.ParamsBean;

public interface JdbcDao {

	public ErrorBean comprobarConectividad(ParamsBean paramsBean);

	public ErrorBean mostrarMetadatos(ParamsBean paramsBean);

	public ErrorBean realizarConsulta(ParamsBean paramsBean);

}
