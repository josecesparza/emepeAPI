package com.epcompany.emepeAPI.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.epcompany.emepeAPI.model.Opinion;
import com.mysql.jdbc.Statement;

public class OpinionDAO {

private Connection connection;
	
	public OpinionDAO() {
		new ConnectionManager();
		this.connection = ConnectionManager.getConnection();
	}
	
	public ArrayList<Opinion> getOpiniones(){
		ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM opinion");
			rsObj = pstmtObj.executeQuery();
			while (rsObj.next()) {
				Opinion opinion = new Opinion(rsObj.getInt(1), rsObj.getString(2), rsObj.getFloat(3));
				opiniones.add(opinion);
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
		
		
		return opiniones;
	}
	
	public Opinion getIngredienteById(int id){
		Opinion opinion = null;
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM opinion WHERE idopinion="+id);
			rsObj = pstmtObj.executeQuery();
			opinion = new Opinion(rsObj.getInt(1), rsObj.getString(2), rsObj.getFloat(3));
						
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
		
		
		return opinion;
	}
	
	public Opinion insertarOpinion(Opinion opinion) {
				
		try {
			String insertTableSQL = "INSERT INTO opinion"
				+ "(opinion, valoracion, idcliente, idproducto) VALUES"
				+ "(?,?,?,?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
	     
	        preparedStatement.setString(1, opinion.getOpinion());
			preparedStatement.setFloat(2, opinion.getValoracion());
			preparedStatement.setInt(3, opinion.getCliente().getId());
			preparedStatement.setInt(4, opinion.getProducto().getId());
			
	        int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	        	throw new SQLException("Creating opinion failed, no rows affected.");
	            
	        }

	        try {
	        	ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	        	if (generatedKeys.next()) {
	                opinion.setId(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating opinion failed, no ID obtained.");
	            }
	        }catch(SQLException e) {
	        	e.printStackTrace();
	        	return null;
	            
	        }
	                     
				
		
		}catch(SQLException exception) {
			exception.printStackTrace();
			return null;
            
		}
		return opinion;
	}
	
	public void deleteOpinionById(int id) {
		PreparedStatement pstmtObj = null;
		
		try {
			pstmtObj = connection.prepareStatement("DELETE FROM opinion " +
	                "WHERE idopinion = "+id);
		    pstmtObj.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
		
	}
	
	public void updateOpinion(Opinion opinion) {
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement(
		      "UPDATE opinion SET opinion = ?, valoracion = ? WHERE idopinion = ?");

			pstmtObj.setString(1,opinion.getOpinion());
			pstmtObj.setFloat(2, opinion.getValoracion());
			pstmtObj.setInt(3, opinion.getId());
			
			
		    pstmtObj.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
	}
}
