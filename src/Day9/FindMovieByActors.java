package Day9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class FindMovieByActors {
	
	Connection cn=ConnectionUtil.getConnection();
	public List<Movies> findByActor()
	{
		List<Movies> m=new ArrayList<Movies>();
		try {
			
			Statement st=cn.createStatement();
			System.out.println("Enter the name of the actor you want to search");
			Scanner sc=new Scanner(System.in);
			String actorName=sc.nextLine();
			actorName=actorName.toLowerCase();
			String qry="select * from movies where actors like '%"+actorName+"%'";
			ResultSet rs=st.executeQuery(qry);
			
			while(rs.next())
			{
				int movieId=rs.getInt(1);
				String movieName=rs.getString(2);
				double TotalBusinessDone =rs.getDouble(3);
				 double rating=rs.getDouble(4);
				 Date dt=rs.getDate(5);
				 String language=rs.getString(6);
				 String movieType=rs.getString(7);
				 String actors=rs.getString(8);
				 Movies m1=new Movies();
				 m1.setMovieId(movieId);
				 m1.setMovieName(movieName);
				 m1.setTotalBusinessDone(TotalBusinessDone);
				 m1.setRating(rating);
				 m1.setReleaseDate(dt);
				 m1.setLanguage(language);
				 m1.setMovieType(movieType);
				 List<String> actorList=new ArrayList<String>();
				 actorList.add(actors);
				 m1.setCasting(actorList);
				 m.add(m1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
				
		
	}
}
