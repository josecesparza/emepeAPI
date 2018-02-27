package com.epcompany.emepeAPI.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.epcompany.emepeAPI.model.Ingrediente;
import com.mysql.jdbc.Statement;

public class IngredienteDAO {
	
	private Connection connection;
	
	public IngredienteDAO() {
		new ConnectionManager();
		this.connection = ConnectionManager.getConnection();
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM ingrediente");
			rsObj = pstmtObj.executeQuery();
			while (rsObj.next()) {
				Ingrediente ingrediente = new Ingrediente(rsObj.getInt(1), rsObj.getString(2), rsObj.getBoolean(3), rsObj.getBoolean(4), rsObj.getBoolean(5), rsObj.getBoolean(6));
				ingredientes.add(ingrediente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rsObj != null) {
					rsObj.close();
				}
				// Closing PreparedStatement Object
				if(pstmtObj != null) {
					pstmtObj.close();
				}
				// Closing Connection Object
				if(connection != null) {
					connection.close();
				}
			} catch(Exception sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		
		return ingredientes;
	}
	
	public Ingrediente getIngredienteById(int id){
		System.out.println(ConnectionManager.getLastGenerated("ingrediente"));
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		Ingrediente ingrediente = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM ingrediente WHERE idingrediente="+id);
			rsObj = pstmtObj.executeQuery();
			rsObj.next();
			ingrediente = new Ingrediente(rsObj.getInt(1), rsObj.getString(2), rsObj.getBoolean(3), rsObj.getBoolean(4), rsObj.getBoolean(5), rsObj.getBoolean(6));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rsObj != null) {
					rsObj.close();
				}
				// Closing PreparedStatement Object
				if(pstmtObj != null) {
					pstmtObj.close();
				}
				// Closing Connection Object
				if(connection != null) {
					connection.close();
				}
			} catch(Exception sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		
		return ingrediente;
	}
	
	public Ingrediente getIngredienteByName(String nombre){
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		Ingrediente ingrediente = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM ingrediente WHERE nombre="+nombre);
			rsObj = pstmtObj.executeQuery();
			
			ingrediente = new Ingrediente(rsObj.getInt(1), rsObj.getString(2), rsObj.getBoolean(3), rsObj.getBoolean(4), rsObj.getBoolean(5), rsObj.getBoolean(6));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rsObj != null) {
					rsObj.close();
				}
				// Closing PreparedStatement Object
				if(pstmtObj != null) {
					pstmtObj.close();
				}
				// Closing Connection Object
				if(connection != null) {
					connection.close();
				}
			} catch(Exception sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		
		return ingrediente;
	}
	
	public Ingrediente insertarIngrediente(Ingrediente ingrediente) {
				
		try {
			String insertTableSQL = "INSERT INTO ingrediente"
				+ "(nombre, vegano, vegetariano, gluten, lactosa) VALUES"
				+ "(?,?,?,?,?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
	     
	        preparedStatement.setString(1, ingrediente.getNombre());
			preparedStatement.setBoolean(2, ingrediente.isVegano());
			preparedStatement.setBoolean(3, ingrediente.isVegetariano());
			preparedStatement.setBoolean(4, ingrediente.isGluten());
			preparedStatement.setBoolean(5, ingrediente.isLactosa());
        

	        int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	        	throw new SQLException("Creating user failed, no rows affected.");
	            
	        }

	        try {
	        	ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	        	if (generatedKeys.next()) {
	                ingrediente.setId(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }catch(SQLException e) {
	        	e.printStackTrace();
	        	return null;
	            
	        }
	                     
				
		
		}catch(SQLException exception) {
			exception.printStackTrace();
			return null;
            
		}
		return ingrediente;
	}

}
