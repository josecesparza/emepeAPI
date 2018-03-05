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

public class RestauranteDAO {
private Connection connection;
	
	public RestauranteDAO() {
		new ConnectionManager();
		this.connection = ConnectionManager.getConnection();
	}
	
	public ArrayList<Restaurante> getRestaurantes() {
		ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try {
			ps1 = connection.prepareStatement("SELECT * FROM restaurante");
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				Restaurante restaurante = new Restaurante(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5),
						rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getFloat(9), rs1.getFloat(10), rs1.getString(11), rs1.getString(12));
				//Get CliRes
				ps2 = connection.prepareStatement("SELECT * FROM cliRes WHERE idrestaurante="+restaurante.getId());
				rs2 = ps2.executeQuery();
				int idCli = rs2.getInt(1);
				//Get Cli from CliRes
				ps3 = connection.prepareStatement("SELECT * FROM cliente WHERE idcliente="+idCli);
				rs3 = ps3.executeQuery();
				Cliente cliente = new Cliente(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getBoolean(4));
				
				//Create CliRes
				CliRes cliRes = new CliRes(cliente, restaurante, rs2.getBoolean(3), rs2.getFloat(4));
				//Add CliRes
				restaurante.getClientes().add(cliRes);
				//Add client to result
				restaurantes.add(restaurante);
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
		
		
		return restaurantes;
	}
	
	public Restaurante getRestauranteById(int id) {
		Restaurante restaurante = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try {
			ps1 = connection.prepareStatement("SELECT * FROM restaurante WHERE idrestaurante="+id);
			rs1 = ps1.executeQuery();
			restaurante = new Restaurante(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5),
						rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getFloat(9), rs1.getFloat(10), rs1.getString(11), rs1.getString(12));
			//Get CliRes
			ps2 = connection.prepareStatement("SELECT * FROM cliRes WHERE idrestaurante="+restaurante.getId());
			rs2 = ps2.executeQuery();
			int idCli = rs2.getInt(1);
			//Get Cli from CliRes
			ps3 = connection.prepareStatement("SELECT * FROM cliente WHERE idcliente="+idCli);
			rs3 = ps3.executeQuery();
			Cliente cliente = new Cliente(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getBoolean(4));
			
			//Create CliRes
			CliRes cliRes = new CliRes(cliente, restaurante, rs2.getBoolean(3), rs2.getFloat(4));
			//Add CliRes
			restaurante.getClientes().add(cliRes);
			//Add client to result
			return restaurante;
			
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
		
		
		return restaurante;
	}
	
	public Restaurante getRestauranteByCodEmp(String cod) {
		Restaurante restaurante = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try {
			ps1 = connection.prepareStatement("SELECT * FROM restaurante WHERE codEmpresa="+cod);
			rs1 = ps1.executeQuery();
			restaurante = new Restaurante(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5),
						rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getFloat(9), rs1.getFloat(10), rs1.getString(11), rs1.getString(12));
			//Get CliRes
			ps2 = connection.prepareStatement("SELECT * FROM cliRes WHERE idrestaurante="+restaurante.getId());
			rs2 = ps2.executeQuery();
			int idCli = rs2.getInt(1);
			//Get Cli from CliRes
			ps3 = connection.prepareStatement("SELECT * FROM cliente WHERE idcliente="+idCli);
			rs3 = ps3.executeQuery();
			Cliente cliente = new Cliente(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getBoolean(4));
			
			//Create CliRes
			CliRes cliRes = new CliRes(cliente, restaurante, rs2.getBoolean(3), rs2.getFloat(4));
			//Add CliRes
			restaurante.getClientes().add(cliRes);
			//Add client to result
			return restaurante;
			
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
		
		
		return restaurante;
	}
	
	public void insertRestaurante(Restaurante restaurante) {
		try {
			String insertTableSQL = "INSERT INTO restaurante"
					+ "(nombre, tipo, descripcion, horario, codEmpresa, pass, adreza, latitud, longitud, telefono, mail) VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
			
	        if(restaurante.getTipo() == null) {
	        	preparedStatement.setNull(2, java.sql.Types.VARCHAR);
	        	if(restaurante.getDescripcion() == null) {
	        		preparedStatement.setNull(3, java.sql.Types.VARCHAR);
	    			if(restaurante.getHorario() == null) {
	    				preparedStatement.setNull(4, java.sql.Types.VARCHAR);
	    			}
	    			else {
	    				preparedStatement.setString(4, restaurante.getHorario());
	    			}
	        	}
	        	else {
	        		preparedStatement.setString(3, restaurante.getDescripcion());
	        		if(restaurante.getHorario() == null) {
	    				preparedStatement.setNull(4, java.sql.Types.VARCHAR);
	    			}
	    			else {
	    				preparedStatement.setString(4, restaurante.getHorario());
	    			}
	        	}
	        }
	        else {
	        	preparedStatement.setString(2, restaurante.getTipo());
	        	if(restaurante.getDescripcion() == null) {
	        		preparedStatement.setNull(3, java.sql.Types.VARCHAR);
	    			if(restaurante.getHorario() == null) {
	    				preparedStatement.setNull(4, java.sql.Types.VARCHAR);
	    			}
	    			else {
	    				preparedStatement.setString(4, restaurante.getHorario());
	    			}
	        	}
	        	else {
	        		preparedStatement.setString(3, restaurante.getDescripcion());
	        		if(restaurante.getHorario() == null) {
	    				preparedStatement.setNull(4, java.sql.Types.VARCHAR);
	    			}
	    			else {
	    				preparedStatement.setString(4, restaurante.getHorario());
	    			}
	        	}
	        }
	        preparedStatement.setString(1, restaurante.getNombre());
			preparedStatement.setString(5, restaurante.getCodEmpresa());
			preparedStatement.setString(6, restaurante.getPass());
			preparedStatement.setString(7, restaurante.getAdreza());
			preparedStatement.setFloat(8, restaurante.getLatitud());
			preparedStatement.setFloat(9,  restaurante.getLongitud());
			preparedStatement.setString(10, restaurante.getTelefono());
			preparedStatement.setString(11, restaurante.getMail());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch(Exception sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		
	}
	
	public void deleteRestauranteById(int id) {
		PreparedStatement pstmtObj = null;
		
		Restaurante restaurante = getRestauranteById(id);
		
		try {
			pstmtObj = connection.prepareStatement("DELETE FROM clires " +
	                "WHERE idrestaurante = "+id);
		    pstmtObj.executeUpdate();
		    
		    pstmtObj.close();
		    
		    for(int i = 0; i < restaurante.getProductos().size(); i++) {
		    	pstmtObj = connection.prepareStatement("DELETE FROM ingprod " +
		                "WHERE idproducto = "+restaurante.getProductos().get(i).getId());
			    pstmtObj.executeUpdate();
			    
			    pstmtObj.close();
		    	
		    }
		    
		    for(int i = 0; i < restaurante.getProductos().size(); i++) {
		    	pstmtObj = connection.prepareStatement("DELETE FROM producto " +
		                "WHERE idproducto = "+restaurante.getProductos().get(i).getId());
			    pstmtObj.executeUpdate();
			    
			    pstmtObj.close();
		    	
		    }
		    
		    for(int i = 0; i < restaurante.getClientes().size(); i++) {
		    	pstmtObj = connection.prepareStatement("DELETE FROM clires " +
		                "WHERE idrestaurante = "+restaurante.getClientes().get(i).getRestaurante().getId());
			    pstmtObj.executeUpdate();
			    
			    pstmtObj.close();
		    	
		    }
		    
		    
		    pstmtObj = connection.prepareStatement("DELETE FROM restaurante " +
	                "WHERE idrestaurante = "+id);
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
	
	public void updateRestaurante(Restaurante restaurante) {
		PreparedStatement pstmtObj = null;
		ResultSet rs = null;
		try {
			pstmtObj = connection.prepareStatement(
		      "UPDATE restaurante SET nombre = ?, tipo = ?, descripcion = ?, horario = ?, codEmpresa = ?, pass = ?, adreza = ?, latitud = ?, longitud = ?, telefono = ?, mail = ? WHERE idrestaurante = ?");

			pstmtObj.setString(1, restaurante.getNombre());
			pstmtObj.setString(2, restaurante.getTipo());
			pstmtObj.setString(3, restaurante.getDescripcion());
			pstmtObj.setString(4, restaurante.getHorario());
			pstmtObj.setString(5, restaurante.getCodEmpresa());
			pstmtObj.setString(6, restaurante.getPass());
			pstmtObj.setString(7, restaurante.getAdreza());
			pstmtObj.setFloat(8, restaurante.getLatitud());
			pstmtObj.setFloat(9,  restaurante.getLongitud());
			pstmtObj.setString(10, restaurante.getTelefono());
			pstmtObj.setString(11, restaurante.getMail());
						
		    pstmtObj.executeUpdate();
		    		    
		    pstmtObj.close();
		    
		    //Actualizar clientes
		    for(int i = 0; i < restaurante.getClientes().size(); i++) {
		    	pstmtObj = connection.prepareStatement("SELECT * FROM clires WHERE idcliente="+restaurante.getClientes().get(i).getCliente().getId()+" AND idrestaurante="+restaurante.getClientes().get(i).getRestaurante().getId());
		    	rs = pstmtObj.executeQuery();
		    	pstmtObj.close();
		    	if(rs.next()) {
		    		pstmtObj = connection.prepareStatement(
		    			      "UPDATE clires SET favorito = ?, valoracion = ? WHERE idcliente ="+restaurante.getClientes().get(i).getCliente().getId()+" AND idrestaurante="+restaurante.getClientes().get(i).getRestaurante().getId());
		    		pstmtObj.setBoolean(3, restaurante.getClientes().get(i).isFavorito());
					pstmtObj.setFloat(4, restaurante.getClientes().get(i).getValoracion());
					pstmtObj.executeUpdate();
		    	}
		    	else {
		    		pstmtObj = connection.prepareStatement("INSERT INTO clires"
		    				+ "(idcliente, idrestaurante, favorito, valoracion) VALUES"
		    				+ "(?,?,?,?)");
		    		pstmtObj.setInt(1, restaurante.getClientes().get(i).getCliente().getId());
		    		pstmtObj.setInt(2, restaurante.getClientes().get(i).getRestaurante().getId());
		    		pstmtObj.setBoolean(3, restaurante.getClientes().get(i).isFavorito());
					pstmtObj.setFloat(4, restaurante.getClientes().get(i).getValoracion());
		    	}
		    }
		    pstmtObj.close();
		    
		    //Actualizar productos
		    for(int i = 0; i < restaurante.getProductos().size(); i++) {
		    	pstmtObj = connection.prepareStatement("SELECT * FROM producto WHERE idproducto="+restaurante.getProductos().get(i).getId());
		    	rs = pstmtObj.executeQuery();
		    	pstmtObj.close();
		    	if(rs.next()) {
		    		pstmtObj = connection.prepareStatement(
		    			      "UPDATE producto SET nombre = ?, precio = ?, peso = ?, descripcion = ?, fechaElab = ?, fechaCad = ? WHERE idrestaurante="+restaurante.getClientes().get(i).getRestaurante().getId());
		    		pstmtObj.setString(2, restaurante.getProductos().get(i).getNombre());
					pstmtObj.setFloat(3, restaurante.getProductos().get(i).getPrecio());
					pstmtObj.setFloat(4, restaurante.getProductos().get(i).getPeso());
					pstmtObj.setString(5, restaurante.getProductos().get(i).getDescripcion());
					pstmtObj.setDate(6, restaurante.getProductos().get(i).getFechaElab());
					pstmtObj.setDate(7, restaurante.getProductos().get(i).getFechaCad());
					pstmtObj.executeUpdate();
		    	}
		    	else {
		    		pstmtObj = connection.prepareStatement("INSERT INTO producto"
		    				+ "(nombre, precio, peso, descripcion, fechaElab, fechaCad, idrestaurante) VALUES"
		    				+ "(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		    		pstmtObj.setString(1, restaurante.getProductos().get(i).getNombre());
		    		pstmtObj.setFloat(2, restaurante.getProductos().get(i).getPrecio());
		    		pstmtObj.setFloat(3, restaurante.getProductos().get(i).getPeso());
					pstmtObj.setString(4, restaurante.getProductos().get(i).getDescripcion());
					pstmtObj.setDate(5, restaurante.getProductos().get(i).getFechaElab());
		    		pstmtObj.setDate(6, restaurante.getProductos().get(i).getFechaCad());
					pstmtObj.setInt(7, restaurante.getId());
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
