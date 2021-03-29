package Day9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MovieDataToDB {
	

	Connection cn=ConnectionUtil.getConnection();
	public  void insertMovies(Movies m)
	{
		PreparedStatement stmt = null;
		try {
			stmt = cn.prepareStatement("insert into movies values(?,?,?,?,?,?,?,?)");
			stmt.setInt(1,m.getMovieId());
			stmt.setString(2, m.getMovieName() );
			stmt.setDouble(3, m.getTotalBusinessDone());
			stmt.setDouble(4, m.getRating() );
			stmt.setDate(5,m.getReleaseDate());
			stmt.setString(6, m.getLanguage());
			stmt.setString(7, m.getMovieType());
			String S="";
			for(String s:m.getCasting())
			{
			S+=s+" ";
			}
			S=S.toLowerCase();
			stmt.setString(8, S);
			stmt.executeUpdate();
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	

}
