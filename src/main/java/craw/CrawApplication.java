package craw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import craw.jdbc.service.JdbcService;
import craw.model.ErrorBean;

@SpringBootApplication
public class CrawApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	ErrorBean errorBean;
	
	@Autowired
	JdbcService jdbcService;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CrawApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CrawApplication.class);
	}

	@Override
	public void run(String... strings) throws Exception {
		
//		String dbms = "mysql";
//		String serverName = "localhost";
//		String portNumber = "3306";
//
//		String url = "jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/";
//		
//		Properties info = new Properties();
//		info.put("user", "root");
//		info.put("password", "newpass");
//		info.put("database", "world");
//		info.put("useSSL", "false");
	}

}
