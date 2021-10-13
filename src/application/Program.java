package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args){
		Locale.setDefault(Locale.US);

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement(""
				+ "DELETE FROM department "
				+ "WHERE Id = ?"
			);
			ps.setInt(1, 2);
			
			int rowsAffected = ps.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
			
		}catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}finally{
			DB.closeStatement(ps);
			DB.closeConnection();
		}
		
		
	}

}
