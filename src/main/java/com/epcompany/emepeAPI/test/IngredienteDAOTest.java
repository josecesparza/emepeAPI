package com.epcompany.emepeAPI.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.epcompany.emepeAPI.model.Ingrediente;
import com.epcompany.emepeAPI.persistence.IngredienteDAO;

import com.ibatis.common.jdbc.ScriptRunner;


public class IngredienteDAOTest {
	

	IngredienteDAO ingredienteDAO;
	
	@Before
	public void before() {
		this.ingredienteDAO = new IngredienteDAO();
		
		
	}
	
	
	@Test
	@Transactional
	public void testEscrituaSoloCliente() {
        // Just a write, verify id set
        Ingrediente ingrediente = new Ingrediente("asdf", true, true, true, true);
        assertEquals(0, ingrediente.getId());
        ingredienteDAO.insertarIngrediente(ingrediente);
        assertThat(ingrediente.getId(), not(0));
        
    }
	
	@After
	public void after() {
		try {
			Statement statement = ingredienteDAO.getConnection().createStatement();
			statement.executeUpdate("DROP DATABASE `emepeTest`");
			
			statement.executeUpdate("CREATE DATABASE `emepeTest` /*!40100 DEFAULT CHARACTER SET latin1 */;");
			
			//Ejecutar sql
			String aSQLScriptFilePath = "lib/exported.sql";
			
			try {
				ScriptRunner sr = new ScriptRunner(ingredienteDAO.getConnection(), false, false);

				// Give the input file to Reader
				Reader reader;
				reader = new BufferedReader(
				                   new FileReader(aSQLScriptFilePath));
				// Exctute script
				sr.runScript(reader);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			

						
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
