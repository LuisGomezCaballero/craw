package craw.jdbc.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import craw.jdbc.service.JdbcService;
import craw.model.ErrorBean;
import craw.model.ParamsBean;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {

	private ParamsBean paramsBean;

	@Autowired
	ErrorBean errorBean;

	@Autowired
	private JdbcService jdbcService;

	{
		paramsBean = new ParamsBean();

		String dbms = "mysql";
		String serverName = "localhost";
		String portNumber = "3306";

		String url = "jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/";

		paramsBean.setUrl(url);

		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "newpass");
		info.put("database", "world");

		paramsBean.setInfo(info);
	}

	@RequestMapping("/form")
	public String showUserForm(Model model) {
		System.out.println("Mostrando formulario");
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/comprobar")
	public ModelAndView comprobar() {
		System.out.println("Entrando en el método comprobar....");

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

		// errorBean = jdbcService.comprobarConectividad(paramsBean);

		Boolean hayConexion = null;
		// Boolean hayConexion = Boolean.TRUE;
		ModelAndView model = new ModelAndView();
		model.addObject("hayConexion", hayConexion);
		model.setViewName("index");
		return model;
	}

	@PostMapping(value = "/comprobarConectividadJSON", produces = "application/json")
	public ErrorBean comprobarConectividadJSON() {
		return jdbcService.comprobarConectividad(paramsBean);
	}

	@PostMapping(value = "/comprobarConectividadXML", produces = "application/xml")
	public ErrorBean comprobarConectividadXML() {
		return jdbcService.comprobarConectividad(paramsBean);
	}

	@PostMapping(value = "/mostrarMetadatos")

	public ErrorBean mostrarMetadatos() {
		return jdbcService.mostrarMetadatos(paramsBean);
	}

	@PostMapping(value = "/realizarConsulta")
	public ErrorBean realizarConsulta() {
		return jdbcService.realizarConsulta(paramsBean);
	}
}