package craw.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import craw.jdbc.service.JdbcService;


@Controller
@RequestMapping("/jdbc")
public class JdbcController {

	@Autowired
	private JdbcService jdbcService;
	
    
	    @RequestMapping("/form")
	    public String showUserForm(Model model){
	    	System.out.println("Mostrando formulario");
	        return "index";
	    }
	    
		@RequestMapping(method = RequestMethod.POST, value = "/comprobar")
	    public ModelAndView comprobar() {
			System.out.println("Entrando en el método comprobar....");
			//Boolean hayConexion = jdbcService.comprobarTabla();
			Boolean hayConexion = Boolean.TRUE;
	        ModelAndView model = new ModelAndView();
	        model.addObject("hayConexion", hayConexion);
	        model.setViewName("index");
	        return model;
	    }
}