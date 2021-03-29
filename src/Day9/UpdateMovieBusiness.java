package Day9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateMovieBusiness {
	
	Connection cn=ConnectionUtil.getConnection();
	public List<Movies> updateBusiness()
	{
		List<Movies> m=new ArrayList<Movies>();
		
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the name of the movie you want to update");
			String movieName=sc.nextLine();
			System.out.println("Enter the updated business");
			double updatedB=sc.nextDouble();
			String query="update movies set BusinessDone="+updatedB+" where movieName like '%"+movieName+"%';";
			Statement st=cn.createStatement();
			st.executeUpdate(query);
			Statement st1=cn.createStatement();
			String Query="select * from movies";
			Statement st11=cn.createStatement();
			ResultSet rs=st11.executeQuery(Query);
			while(rs.next())
			{
				int movieId=rs.getInt(1);
				String movieN=rs.getString(2);
				double TotalBusinessDone =rs.getDouble(3);
				 double rat=rs.getDouble(4);
				 Date dt=rs.getDate(5);
				 String language=rs.getString(6);
				 String movieType=rs.getString(7);
				 String actors=rs.getString(8);
				 Movies m1=new Movies();
				 m1.setMovieId(movieId);
				 m1.setMovieName(movieName);
				 m1.setTotalBusinessDone(updatedB);
				 m1.setRating(rat);
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
	
	
	public static void main(String[] args)
	{
		UpdateMovieBusiness update=new UpdateMovieBusiness();
		 List<Movies> list=update.updateBusiness();
		 System.out.println(list);
	}

}
