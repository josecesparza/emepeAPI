package com.epcompany.emepeAPI.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.epcompany.emepeAPI.model.Cliente;
import com.mysql.jdbc.Statement;

public class ClienteDAO {

	private Connection connection;
	
	public ClienteDAO() {
		new ConnectionManager();
		this.connection = ConnectionManager.getConnection();
	}
	
	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> clients = new ArrayList<Cliente>();
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM cliente");
			rsObj = pstmtObj.executeQuery();
			while (rsObj.next()) {
				Cliente cliente = new Cliente(rsObj.getInt(1), rsObj.getString(2), rsObj.getString(3), rsObj.getBoolean(4));
				clients.add(cliente);
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
		
		
		return clients;
	}
	
	public Cliente getClienteById(int id) {
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		Cliente cliente = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM cliente WHERE idcliente="+id);
			rsObj = pstmtObj.executeQuery();
			rsObj.next();
			cliente = new Cliente(rsObj.getInt(1), rsObj.getString(2), rsObj.getString(3), rsObj.getBoolean(4), rsObj.getString(5), rsObj.getString(6),
					rsObj.getDate(7), rsObj.getBoolean(8), rsObj.getString(9), rsObj.getString(10));
			
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
						
		return cliente;
	}
	
	public Cliente getClienteByUserName(String usuario){
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		Cliente cliente = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM cliente WHERE usuario="+usuario);
			rsObj = pstmtObj.executeQuery();
			
			cliente = new Cliente(rsObj.getInt(1), rsObj.getString(2), rsObj.getString(3), rsObj.getBoolean(4), rsObj.getString(5), rsObj.getString(6),
					rsObj.getDate(7), rsObj.getBoolean(8), rsObj.getString(9), rsObj.getString(10));
			
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
		
		
		return cliente;
	}
	
	public Cliente getClienteByName(String nombre, String apellidos){
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		Cliente cliente = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM cliente WHERE nombre="+nombre+"AND apellidos="+apellidos);
			rsObj = pstmtObj.executeQuery();
			
			cliente = new Cliente(rsObj.getInt(1), rsObj.getString(2), rsObj.getString(3), rsObj.getBoolean(4), rsObj.getString(5), rsObj.getString(6),
					rsObj.getDate(7), rsObj.getBoolean(8), rsObj.getString(9), rsObj.getString(10));
			
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
		
		
		return cliente;
	}
	
	public Cliente insertarCliente(Cliente cliente) {
		try {
			String insertTableSQL = "INSERT INTO cliente"
				+ "(usuario, pass, registrado, nombre, apellidos, fechaNac, genero, localidad, correo, idtarj) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
	        if(cliente.getTarjCredito() == null) {
	        	preparedStatement.setNull(10, java.sql.Types.INTEGER);
	        	if(cliente.isRegistrado()) {
	        		preparedStatement.setString(1, cliente.getUsuario());
	    			preparedStatement.setString(2, cliente.getPass());
	        	}
	        	else {
	        		preparedStatement.setNull(1, java.sql.Types.VARCHAR);
	        		preparedStatement.setNull(2, java.sql.Types.VARCHAR);
	        	}
	        }
	        else {
	        	preparedStatement.setInt(10, cliente.getTarjCredito().getId());
	        	if(cliente.isRegistrado()) {
	        		preparedStatement.setString(1, cliente.getUsuario());
	    			preparedStatement.setString(2, cliente.getPass());
	        	}else {
	        		preparedStatement.setNull(1, java.sql.Types.VARCHAR);
	        		preparedStatement.setNull(2, java.sql.Types.VARCHAR);
	        	}
	        }
	        preparedStatement.setBoolean(3, cliente.isRegistrado());
			preparedStatement.setString(4, cliente.getNombre());
			preparedStatement.setString(5, cliente.getApellidos());
			preparedStatement.setDate(6, cliente.getFechaNac());
			preparedStatement.setBoolean(7, cliente.isGenero());
			preparedStatement.setString(8,  cliente.getLocalidad());
			preparedStatement.setString(9, cliente.getCorreo());
			
        

	        int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	        	throw new SQLException("Creating user failed, no rows affected.");
	            
	        }

	        try {
	        	ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	        	if (generatedKeys.next()) {
	                cliente.setId(generatedKeys.getInt(1));
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
		return cliente;
		
		
	}
	
	public void deleteClientById(int id) {
		PreparedStatement pstmtObj = null;
		
		Cliente cliente = getClienteById(id);
		int idTarj = cliente.getTarjCredito().getId();
		try {
			pstmtObj = connection.prepareStatement("DELETE FROM cliente " +
	                "WHERE idcliente = "+id);
		    pstmtObj.executeUpdate();
		    
		    pstmtObj.close();
		    
		    pstmtObj = connection.prepareStatement("DELETE FROM tarjCredito " +
	                "WHERE idtarj = "+idTarj);
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
	
	public void updateCliente(Cliente cliente) {
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement(
		      "UPDATE cliente SET usuario = ?, pass = ?, registrado = ?, nombre = ?, apellidos = ?, fechaNac = ?, genero = ?, localidad = ?, correo = ? WHERE idcliente = ?");

			pstmtObj.setString(1, cliente.getUsuario());
			pstmtObj.setString(2, cliente.getPass());
			pstmtObj.setBoolean(3, cliente.isRegistrado());
			pstmtObj.setString(4, cliente.getNombre());
			pstmtObj.setString(5, cliente.getApellidos());
			pstmtObj.setDate(6,  cliente.getFechaNac());
			pstmtObj.setBoolean(7, cliente.isGenero());
			pstmtObj.setString(8, cliente.getLocalidad());
			pstmtObj.setString(9, cliente.getCorreo());
			pstmtObj.setInt(10, cliente.getId());
			
			
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
