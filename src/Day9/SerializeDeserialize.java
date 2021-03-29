package Day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SerializeDeserialize {
	public List<Movies> populateMovies(File file)
	{
		List<Movies> list=new ArrayList<Movies>();
		
	    String line;
	    BufferedReader reader = null;
	  
		try {
			if(file.isFile())
			{
				FileReader f=new FileReader(file);
				reader = new BufferedReader(f);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    	
			while ((line = reader.readLine()) != null)
			{
				Movies m=new Movies();
			    String[] parts = line.split(",");
			    if (parts.length >= 9)
			    {
			    	List<String> actors=new ArrayList<String>();
			        m.setMovieId(Integer.parseInt(parts[0]));
			        m.setMovieName(parts[1]);
			        actors.add(parts[2]);
			        actors.add(parts[3]);
			        m.setCasting(actors);
			        m.setLanguage(parts[4]);
			        m.setMovieType(parts[5]);
			        m.setRating(Double.parseDouble(parts[6]));
			        String string =parts[7];
					java.sql.Date date = Date.valueOf(string);
					m.setReleaseDate(Date.valueOf(string));
			        m.setTotalBusinessDone(Double.parseDouble(parts[8]));
			        
			    } else {
			       // System.out.println("ignoring line: " + line);
			    }
			    list.add(m);
			}
			
			
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try
	    {
	    	reader.close();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	
	    return list;
	}
	
	public void serializeMovies(List<Movies> movies, String fileName)
	{
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(movies);
			out.close();
			fileOut.close();
			System.out.println("Done");
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
	
	public	static ArrayList<Movies> deserializeMovies(String fileName)
	{
		ArrayList<Movies> movie=new ArrayList<Movies>();
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			try {
				movie=(ArrayList<Movies>)in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movie;
	}
}