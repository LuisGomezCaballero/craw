package craw.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import craw.model.ErrorBean;
import craw.model.ParamsBean;

@Repository
public class JdbcDaoImpl implements JdbcDao {

	private static final String NO_HAY_DATOS = "No hay datos.";

	private static final String OPERACIÓN_REALIZADA_CON_ÉXITO = "Operación realizada con éxito.";

	@Autowired
	ErrorBean errorBean;

	private Connection connection;

	@Override
	public ErrorBean comprobarConectividad(ParamsBean paramsBean) {

		conectar(paramsBean);
		desconectar();

		return errorBean;
	}

	private void conectar(ParamsBean paramsBean) {
		try {
			connection = DriverManager.getConnection(paramsBean.getUrl(), paramsBean.getInfo());
			errorBean.setExito(Boolean.TRUE);
			errorBean.setDescripcion(OPERACIÓN_REALIZADA_CON_ÉXITO);
		} catch (SQLException e) {
			errorBean.setExito(Boolean.FALSE);
			errorBean.setDescripcion(e.getMessage());
		}
	}

	private void desconectar() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public ErrorBean mostrarMetadatos(ParamsBean paramsBean) {

		conectar(paramsBean);
		try {
			System.out.println(connection.getMetaData());
			errorBean.setExito(Boolean.TRUE);
			errorBean.setDescripcion(OPERACIÓN_REALIZADA_CON_ÉXITO);
		} catch (SQLException e) {
			errorBean.setExito(Boolean.FALSE);
			errorBean.setDescripcion(e.getMessage());
		}

		desconectar();

		return errorBean;
	}

	@Override
	public ErrorBean realizarConsulta(ParamsBean paramsBean) {

		Statement stmt = null;
		String query = "select NAME " + "from " + "world" + ".COUNTRY " + "where " + "Code = " + "'ESP'";

		conectar(paramsBean);

		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (!rs.next()) {
				errorBean.setExito(Boolean.FALSE);
				errorBean.setDescripcion(NO_HAY_DATOS);
			} else {
				while (rs.next()) {
					rs.getString("Name");
				}
				errorBean.setExito(Boolean.TRUE);
				errorBean.setDescripcion(OPERACIÓN_REALIZADA_CON_ÉXITO);
			}
		} catch (SQLException e) {
			errorBean.setExito(Boolean.FALSE);
			errorBean.setDescripcion(e.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}

		desconectar();

		return errorBean;
	}
}
