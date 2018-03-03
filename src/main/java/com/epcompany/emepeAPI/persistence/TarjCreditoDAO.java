package com.epcompany.emepeAPI.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.epcompany.emepeAPI.model.TarjCredito;
import com.mysql.jdbc.Statement;

public class TarjCreditoDAO {
private Connection connection;
	
	public TarjCreditoDAO() {
		new ConnectionManager();
		this.connection = ConnectionManager.getConnection();
	}
	
	public ArrayList<TarjCredito> getTarjCreditos(){
		ArrayList<TarjCredito> tarjCreditos = new ArrayList<TarjCredito>();
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM tarjCredito");
			rsObj = pstmtObj.executeQuery();
			while (rsObj.next()) {
				TarjCredito tarjCredito = new TarjCredito(rsObj.getInt(1), rsObj.getInt(2));
				tarjCreditos.add(tarjCredito);
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
		
		
		return tarjCreditos;
	}
	
	public TarjCredito getTarjCreditoById(int id){
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		TarjCredito tarjCredito = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM tarjCredito WHERE idtarj="+id);
			rsObj = pstmtObj.executeQuery();
			rsObj.next();
			tarjCredito = new TarjCredito(rsObj.getInt(1), rsObj.getInt(2));
			
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
		
		
		return tarjCredito;
	}
	
	public TarjCredito getTarjCreditoByNumber(int numero){
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		TarjCredito tarjCredito = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM tarjCredito WHERE numero="+numero);
			rsObj = pstmtObj.executeQuery();
			
			tarjCredito = new TarjCredito(rsObj.getInt(1), rsObj.getInt(2));
			
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
		
		
		return tarjCredito;
	}
	
	public TarjCredito insertarTarjCredito(TarjCredito tarjCredito) {
				
		try {
			String insertTableSQL = "INSERT INTO tarjCredito"
				+ "(numero) VALUES"
				+ "(?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
	     
	        preparedStatement.setInt(1, tarjCredito.getNumero());
			
	        int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	        	throw new SQLException("Creating user failed, no rows affected.");
	            
	        }

	        try {
	        	ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	        	if (generatedKeys.next()) {
	                tarjCredito.setId(generatedKeys.getInt(1));
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
		return tarjCredito;
	}
	
	public void deleteTarjCreditoById(int id) {
		PreparedStatement pstmtObj = null;
		
		try {
			pstmtObj = connection.prepareStatement("DELETE FROM tarjCredito " +
	                "WHERE idtarj = "+id);
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
	
	public void updateTarjeta(TarjCredito tarjCredito) {
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement(
		      "UPDATE tarjCredito SET numero = ? WHERE idtarj = ?");

			pstmtObj.setInt(1, tarjCredito.getNumero());
			pstmtObj.setInt(2, tarjCredito.getId());
						
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
