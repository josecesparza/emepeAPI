package com.epcompany.emepeAPI.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.epcompany.emepeAPI.model.Ingrediente;
import com.epcompany.emepeAPI.persistence.IngredienteDAO;

@Controller
public class IngredienteController {
	
	@RequestMapping(value = "/ingrediente/getAll", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Ingrediente> getAll() {
		IngredienteDAO ingredienteDAO = new IngredienteDAO();
		
		ArrayList<Ingrediente> ingredientes = ingredienteDAO.getIngredientes();
		
		return ingredientes;
	}
	
	@RequestMapping(value = "/ingrediente/getById", method = RequestMethod.GET)
	public @ResponseBody Ingrediente getById(@RequestParam(value="id", required=true) int id) {
		IngredienteDAO ingredienteDAO = new IngredienteDAO();
		
		Ingrediente ingrediente = ingredienteDAO.getIngredienteById(id);
		
		return ingrediente;
	}
	
	@RequestMapping(value = "/ingrediente/getByName", method = RequestMethod.GET)
	public @ResponseBody Ingrediente getByName(@RequestParam(value="nombre", required=true) String nombre) {
		IngredienteDAO ingredienteDAO = new IngredienteDAO();
		
		Ingrediente ingrediente = ingredienteDAO.getIngredienteByName(nombre);
		
		return ingrediente;
	}
	
	@RequestMapping(value = "/ingrediente/insert", method = RequestMethod.GET)
	public @ResponseBody Ingrediente insert(@RequestParam Map<String,String> requestParams) {
		Ingrediente ingrediente = new Ingrediente(requestParams.get("nombre"), Boolean.valueOf(requestParams.get("vegano")), Boolean.valueOf(requestParams.get("vegetariano")), Boolean.valueOf(requestParams.get("gluten")), Boolean.valueOf(requestParams.get("lactosa")));
				
		IngredienteDAO ingredienteDAO = new IngredienteDAO();
		
		ingrediente = ingredienteDAO.insertarIngrediente(ingrediente);
		
		System.out.println(ingrediente.toString());
		return ingrediente;
	}
	
	

}
