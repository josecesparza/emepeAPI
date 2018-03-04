package com.epcompany.emepeAPI.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.epcompany.emepeAPI.model.CliRes;
import com.epcompany.emepeAPI.model.Cliente;
import com.epcompany.emepeAPI.model.Restaurante;
import com.mysql.jdbc.Statement;

public class ClienteDAO {

	private Connection connection;
	
	public ClienteDAO() {
		new ConnectionManager();
		this.connection = ConnectionManager.getConnection();
	}
	
	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> clients = new ArrayList<Cliente>();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try {
			ps1 = connection.prepareStatement("SELECT * FROM cliente");
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				Cliente cliente = new Cliente(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getBoolean(4));
				//Get CliRes
				ps2 = connection.prepareStatement("SELECT * FROM cliRes WHERE idcliente="+cliente.getId());
				rs2 = ps2.executeQuery();
				int idRes = rs2.getInt(2);
				//Get Res from CliRes
				ps3 = connection.prepareStatement("SELECT * FROM restaurante WHERE idrestaurante="+idRes);
				rs3 = ps3.executeQuery();
				Restaurante restaurante = new Restaurante(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getString(5),
						rs3.getString(6), rs3.getString(7), rs3.getString(8), rs3.getFloat(9), rs3.getFloat(10), rs3.getString(11), rs3.getString(12));
				//Create CliRes
				CliRes cliRes = new CliRes(cliente, restaurante, rs2.getBoolean(3), rs2.getFloat(4));
				//Add CliRes
				cliente.getRestaurantes().add(cliRes);
				//Add client to result
				clients.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rs1 != null || rs2 != null || rs3 != null) {
					rs1.close();
					rs2.close();
					rs3.close();
				}
				// Closing PreparedStatement Object
				if(ps1 != null || ps2 != null || ps3 != null) {
					ps1.close();
					ps2.close();
					ps3.close();
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
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		Cliente cliente = null;
		try {
			ps1 = connection.prepareStatement("SELECT * FROM cliente WHERE idcliente="+id);
			rs1 = ps1.executeQuery();
			cliente = new Cliente(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getBoolean(4));
			//Get CliRes
			ps2 = connection.prepareStatement("SELECT * FROM cliRes WHERE idcliente="+cliente.getId());
			rs2 = ps2.executeQuery();
			int idRes = rs2.getInt(2);
			//Get Res from CliRes
			ps3 = connection.prepareStatement("SELECT * FROM restaurante WHERE idrestaurante="+idRes);
			rs3 = ps3.executeQuery();
			Restaurante restaurante = new Restaurante(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getString(5),
					rs3.getString(6), rs3.getString(7), rs3.getString(8), rs3.getFloat(9), rs3.getFloat(10), rs3.getString(11), rs3.getString(12));
			//Create CliRes
			CliRes cliRes = new CliRes(cliente, restaurante, rs2.getBoolean(3), rs2.getFloat(4));
			//Add CliRes
			cliente.getRestaurantes().add(cliRes);
			restaurante.getClientes().add(cliRes);
			//Add client to result
			return cliente;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rs1 != null || rs2 != null || rs3 != null) {
					rs1.close();
					rs2.close();
					rs3.close();
				}
				// Closing PreparedStatement Object
				if(ps1 != null || ps2 != null || ps3 != null) {
					ps1.close();
					ps2.close();
					ps3.close();
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
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		Cliente cliente = null;
		try {
			ps1 = connection.prepareStatement("SELECT * FROM cliente WHERE usuario="+usuario);
			rs1 = ps1.executeQuery();
			cliente = new Cliente(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getBoolean(4));
			//Get CliRes
			ps2 = connection.prepareStatement("SELECT * FROM cliRes WHERE idcliente="+cliente.getId());
			rs2 = ps2.executeQuery();
			int idRes = rs2.getInt(2);
			//Get Res from CliRes
			ps3 = connection.prepareStatement("SELECT * FROM restaurante WHERE idrestaurante="+idRes);
			rs3 = ps3.executeQuery();
			Restaurante restaurante = new Restaurante(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getString(5),
					rs3.getString(6), rs3.getString(7), rs3.getString(8), rs3.getFloat(9), rs3.getFloat(10), rs3.getString(11), rs3.getString(12));
			//Create CliRes
			CliRes cliRes = new CliRes(cliente, restaurante, rs2.getBoolean(3), rs2.getFloat(4));
			//Add CliRes
			cliente.getRestaurantes().add(cliRes);
			restaurante.getClientes().add(cliRes);
			//Add client to result
			return cliente;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rs1 != null || rs2 != null || rs3 != null) {
					rs1.close();
					rs2.close();
					rs3.close();
				}
				// Closing PreparedStatement Object
				if(ps1 != null || ps2 != null || ps3 != null) {
					ps1.close();
					ps2.close();
					ps3.close();
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
			for(int i = 0; i < cliente.getRestaurantes().size(); i++) {
				pstmtObj = connection.prepareStatement("DELETE FROM clires " +
		                "WHERE idcliente = "+cliente.getRestaurantes().get(i).getCliente().getId());
			    pstmtObj.executeUpdate();
			    
			    pstmtObj.close();
			}
			
			pstmtObj = connection.prepareStatement("DELETE FROM cliente " +
	                "WHERE idcliente = "+id);
		    pstmtObj.executeUpdate();
		    
		    pstmtObj.close();
		    
		    pstmtObj = connection.prepareStatement("DELETE FROM tarjCredito " +
	                "WHERE idtarj = "+idTarj);
		    pstmtObj.executeUpdate();
		    
		    pstmtObj.close();
		    
		    pstmtObj = connection.prepareStatement("DELETE FROM clires " +
	                "WHERE idcliente = "+id);
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
		ResultSet rs = null;
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
		    		    
		    pstmtObj.close();
		    
		    //Actualizar restaurantes
		    for(int i = 0; i < cliente.getRestaurantes().size(); i++) {
		    	pstmtObj = connection.prepareStatement("SELECT * FROM clires WHERE idcliente="+cliente.getId()+" AND idrestaurante="+cliente.getRestaurantes().get(i).getRestaurante().getId());
		    	rs = pstmtObj.executeQuery();
		    	pstmtObj.close();
		    	if(rs.next()) {
		    		pstmtObj = connection.prepareStatement(
		    			      "UPDATE clires SET favorito = ?, valoracion = ? WHERE idcliente ="+cliente.getId()+" AND idrestaurante="+cliente.getRestaurantes().get(i).getRestaurante().getId());
		    		pstmtObj.setBoolean(3, cliente.getRestaurantes().get(i).isFavorito());
					pstmtObj.setFloat(4, cliente.getRestaurantes().get(i).getValoracion());
					pstmtObj.executeUpdate();
		    	}
		    	else {
		    		pstmtObj = connection.prepareStatement("INSERT INTO clires"
		    				+ "(idcliente, idrestaurante, favorito, valoracion) VALUES"
		    				+ "(?,?,?,?)");
		    		pstmtObj.setInt(1, cliente.getRestaurantes().get(i).getCliente().getId());
		    		pstmtObj.setInt(2, cliente.getRestaurantes().get(i).getRestaurante().getId());
		    		pstmtObj.setBoolean(3, cliente.getRestaurantes().get(i).isFavorito());
					pstmtObj.setFloat(4, cliente.getRestaurantes().get(i).getValoracion());
		    	}
		    }
		    pstmtObj.close();
		    
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
