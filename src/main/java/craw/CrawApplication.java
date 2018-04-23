package craw;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import craw.jdbc.service.JdbcService;
import craw.model.ErrorBean;
import craw.model.ParamsBean;

@SpringBootApplication
public class CrawApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	ErrorBean errorBean;
	
	@Autowired
	JdbcService jdbcService;

	public static void main(String[] args) {
		SpringApplication.run(CrawApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CrawApplication.class);
	}

	@Override
	public void run(String... strings) throws Exception {

		ParamsBean paramsBean = new ParamsBean();

		String dbms = "mysql";
		String serverName = "localhost";
		String portNumber = "3306";

		String url = "jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/";

		paramsBean.setUrl(url);
		
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "newpass");
		info.put("database", "world");
		info.put("useSSL", "false");

		paramsBean.setInfo(info);

		errorBean = jdbcService.comprobarConectividad(paramsBean);
		
		System.out.println("comprobarConectividad: " + errorBean);

		errorBean = jdbcService.mostrarMetadatos(paramsBean);
		
		System.out.println("mostrarMetadatos: " + errorBean);

		errorBean = jdbcService.realizarConsulta(paramsBean);
		
		System.out.println("realizarConsulta: " + errorBean);
	}

}
