package com.epcompany.emepeAPI.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.epcompany.emepeAPI.model.Ingrediente;
import com.epcompany.emepeAPI.model.Opinion;
import com.epcompany.emepeAPI.model.Producto;
import com.epcompany.emepeAPI.model.Restaurante;
import com.mysql.jdbc.Statement;

public class ProductoDAO {
private Connection connection;
	
	public ProductoDAO() {
		new ConnectionManager();
		this.connection = ConnectionManager.getConnection();
	}
	
	public ArrayList<Producto> getProductos(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ResultSet rs1 = null;
		PreparedStatement ps1 = null;
		ResultSet rs2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs3 = null;
		PreparedStatement ps3 = null;
		ResultSet rs4 = null;
		PreparedStatement ps4 = null;
		try {
			ps1 = connection.prepareStatement("SELECT * FROM producto");
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				Producto producto = new Producto(rs1.getInt(1), rs1.getString(2), rs1.getFloat(3), rs1.getFloat(4), rs1.getString(5), rs1.getDate(6), rs1.getDate(6));
				productos.add(producto);
								
				ps2 = connection.prepareStatement("SELECT * FROM restaurante WHERE idrestaurante="+producto.getId());
				rs2 = ps2.executeQuery();
				Restaurante restaurante = new Restaurante(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5),
						rs2.getString(6), rs2.getString(7), rs2.getString(8), rs2.getFloat(9), rs2.getFloat(10), rs2.getString(11), rs2.getString(12));
				producto.setRestaurante(restaurante);
				
				ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
				ps3 = connection.prepareStatement("SELECT * FROM ingrediente, ingprod WHERE ingprod.idproducto="+ producto.getId() +"AND ingrediente.idingrediente=ingprod.idingrediente");
				rs3 = ps3.executeQuery();
				while(rs3.next()) {
					Ingrediente ingrediente = new Ingrediente(rs3.getInt(1), rs3.getString(2), rs3.getBoolean(3), rs3.getBoolean(4), rs3.getBoolean(5), rs3.getBoolean(6));
					ingredientes.add(ingrediente);
				}
				producto.setIngredientes(ingredientes);
				
				ps4 = connection.prepareStatement("SELECT * FROM opinion WHERE idproducto="+producto.getId());
				rs4 = ps4.executeQuery();
				ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
				while(rs4.next()) {
					Opinion opinion = new Opinion(rs4.getInt(1), rs4.getString(2), rs4.getFloat(3));
					opiniones.add(opinion);
					
				}
				producto.setOpiniones(opiniones);
				productos.add(producto);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rs1 != null) {
					rs1.close();
				}
				// Closing PreparedStatement Object
				if(ps1 != null) {
					ps1.close();
				}
				if(rs2 != null) {
					rs2.close();
				}
				// Closing PreparedStatement Object
				if(ps3 != null) {
					ps3.close();
				}
				if(rs3 != null) {
					rs3.close();
				}
				// Closing PreparedStatement Object
				if(ps4 != null) {
					ps4.close();
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
		Producto producto = null;
		ResultSet rs1 = null;
		PreparedStatement ps1 = null;
		ResultSet rs2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs3 = null;
		PreparedStatement ps3 = null;
		ResultSet rs4 = null;
		PreparedStatement ps4 = null;
		try {
			ps1 = connection.prepareStatement("SELECT * FROM producto WHERE productoid="+id);
			rs1 = ps1.executeQuery();
			producto = new Producto(rs1.getInt(1), rs1.getString(2), rs1.getFloat(3), rs1.getFloat(4), rs1.getString(5), rs1.getDate(6), rs1.getDate(6));
										
			ps2 = connection.prepareStatement("SELECT * FROM restaurante WHERE idrestaurante="+producto.getId());
			rs2 = ps2.executeQuery();
			Restaurante restaurante = new Restaurante(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5),
					rs2.getString(6), rs2.getString(7), rs2.getString(8), rs2.getFloat(9), rs2.getFloat(10), rs2.getString(11), rs2.getString(12));
			producto.setRestaurante(restaurante);
			
			ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
			ps3 = connection.prepareStatement("SELECT * FROM ingrediente, ingprod WHERE ingprod.idproducto="+ producto.getId() +"AND ingrediente.idingrediente=ingprod.idingrediente");
			rs3 = ps3.executeQuery();
			while(rs3.next()) {
				Ingrediente ingrediente = new Ingrediente(rs3.getInt(1), rs3.getString(2), rs3.getBoolean(3), rs3.getBoolean(4), rs3.getBoolean(5), rs3.getBoolean(6));
				ingredientes.add(ingrediente);
			}
			producto.setIngredientes(ingredientes);
			
			ps4 = connection.prepareStatement("SELECT * FROM opinion WHERE idproducto="+producto.getId());
			rs4 = ps4.executeQuery();
			ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
			while(rs4.next()) {
				Opinion opinion = new Opinion(rs4.getInt(1), rs4.getString(2), rs4.getFloat(3));
				opiniones.add(opinion);
				
			}
			producto.setOpiniones(opiniones);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rs1 != null) {
					rs1.close();
				}
				// Closing PreparedStatement Object
				if(ps1 != null) {
					ps1.close();
				}
				if(rs2 != null) {
					rs2.close();
				}
				// Closing PreparedStatement Object
				if(ps3 != null) {
					ps3.close();
				}
				if(rs3 != null) {
					rs3.close();
				}
				// Closing PreparedStatement Object
				if(ps4 != null) {
					ps4.close();
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
