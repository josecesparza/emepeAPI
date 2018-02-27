package com.epcompany.emepeAPI.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.epcompany.emepeAPI.model.Cliente;
import com.epcompany.emepeAPI.persistence.ClienteDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ClienteController {
		
	/*
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Cliente> getClientes(@RequestParam(value="nombre", required=true) String nombre) {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		ArrayList<Cliente> clientes = clienteDAO.getClientes();
		
		return clientes;
	}*/
	
	@RequestMapping(value = "/cliente/getClientes", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Cliente> getClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		ArrayList<Cliente> clientes = clienteDAO.getClientes();
		
		return clientes;
	}
	
}