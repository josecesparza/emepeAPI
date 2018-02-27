package com.epcompany.emepeAPI.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.epcompany.emepeAPI.model.Cliente;

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
}
