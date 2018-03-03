package com.epcompany.emepeAPI.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.epcompany.emepeAPI.model.Producto;
import com.mysql.jdbc.Statement;

public class ProductoDAO {
private Connection connection;
	
	public ProductoDAO() {
		new ConnectionManager();
		this.connection = ConnectionManager.getConnection();
	}
	
	public ArrayList<Producto> getProductos(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM producto");
			rsObj = pstmtObj.executeQuery();
			while (rsObj.next()) {
				Producto producto = new Producto(rsObj.getInt(1), rsObj.getString(2), rsObj.getFloat(3), rsObj.getFloat(4), rsObj.getString(5), rsObj.getDate(6), rsObj.getDate(6));
				productos.add(producto);
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
		
		
		return productos;
	}
	
	public Producto getProductoById(int id){
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		Producto producto = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM producto WHERE idproducto="+id);
			rsObj = pstmtObj.executeQuery();
			rsObj.next();
			producto = new Producto(rsObj.getInt(1), rsObj.getString(2), rsObj.getFloat(3), rsObj.getFloat(4), rsObj.getString(5), rsObj.getDate(6), rsObj.getDate(6));
			
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
		
		
		return producto;
	}
	
	public Producto getProductoByNameAndRestaurant(String nombre, int idRestaurante){
		ResultSet rsObj = null;
		PreparedStatement pstmtObj = null;
		Producto producto = null;
		try {
			pstmtObj = connection.prepareStatement("SELECT * FROM producto WHERE nombre="+nombre+"AND idrestaurante="+idRestaurante);
			rsObj = pstmtObj.executeQuery();
			
			producto = new Producto(rsObj.getInt(1), rsObj.getString(2), rsObj.getFloat(3), rsObj.getFloat(4), rsObj.getString(5), rsObj.getDate(6), rsObj.getDate(6));
			
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
		
		
		return producto;
	}
	
	public Producto insertarProducto(Producto producto, int idRestaurante) {
				
		try {
			String insertTableSQL = "INSERT INTO producto"
				+ "(nombre, precio, peso, descripcion, fechaElab, fechaCad, idRestaurante) VALUES"
				+ "(?,?,?,?,?,?,?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
	     
	        preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setFloat(2, producto.getPrecio());
			preparedStatement.setFloat(3, producto.getPeso());
			preparedStatement.setString(4, producto.getDescripcion());
			preparedStatement.setDate(5, producto.getFechaElab());
			preparedStatement.setDate(6, producto.getFechaCad());
			preparedStatement.setInt(7, idRestaurante);
			
        

	        int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	        	throw new SQLException("Creating user failed, no rows affected.");
	            
	        }

	        try {
	        	ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	        	if (generatedKeys.next()) {
	                producto.setId(generatedKeys.getInt(1));
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
		return producto;
	}
	
	public void deleteProductoById(int id) {
		PreparedStatement pstmtObj = null;
		
		try {
			pstmtObj = connection.prepareStatement("DELETE FROM producto " +
	                "WHERE idproducto = "+id);
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
	
	public void updateProducto(Producto producto) {
		PreparedStatement pstmtObj = null;
		try {
			pstmtObj = connection.prepareStatement(
		      "UPDATE producto SET nombre = ?, precio = ?, peso = ?, descripcion = ?, fechaElab = ?, fechaCad = ? WHERE idproducto = ?");

			pstmtObj.setString(1, producto.getNombre());
			pstmtObj.setFloat(2, producto.getPrecio());
			pstmtObj.setFloat(3, producto.getPeso());
			pstmtObj.setString(4, producto.getDescripcion());
			pstmtObj.setDate(5, producto.getFechaElab());
			pstmtObj.setDate(6,  producto.getFechaCad());
			pstmtObj.setInt(7,  producto.getId());
			
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
