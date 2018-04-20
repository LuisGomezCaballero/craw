package craw.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDaoImpl implements JdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Boolean comprobarTabla() {

		Boolean exito = null;
		try {
			String string = jdbcTemplate.queryForObject("SELECT 1 FROM DUAL", String.class);
			exito = Boolean.TRUE;
			System.out.println("He encontrado el siguiente valor: " + string);
		} catch (Exception e) {
			exito = Boolean.FALSE;
			System.out.println("La excepción es: " + e);
		}

		return exito;
	}

}
