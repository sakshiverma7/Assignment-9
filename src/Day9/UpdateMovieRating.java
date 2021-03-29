package Day9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateMovieRating {
	
	
	Connection cn=ConnectionUtil.getConnection();
	public List<Movies> updateRating()
	{
		List<Movies> m=new ArrayList<Movies>();
		try {
			
			Statement st=cn.createStatement();
			System.out.println("Enter the name of the movie for which you want to update the ratings");
			Scanner sc=new Scanner(System.in);
			String name=sc.nextLine();
			System.out.println("Enter the new rating");
			double rating=sc.nextDouble();
			String qry="update movies set rating="+rating+" where movieName like '%"+name+"%'";
			st.executeUpdate(qry);
			String selectQuery="select * from moviesTable;";
			Statement st1=cn.createStatement();
			ResultSet rs1=st1.executeQuery(selectQuery);
			while(rs1.next())
			{
				int movieId=rs1.getInt(1);
				String movieName=rs1.getString(2);
				double TotalBusinessDone =rs1.getDouble(3);
				 double rat=rs1.getDouble(4);
				 Date dt=rs1.getDate(5);
				 String language=rs1.getString(6);
				 String movieType=rs1.getString(7);
				 String actors=rs1.getString(8);
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
		
		
	//System.out.println(qry);
		return m;
				
		
	}
	

}