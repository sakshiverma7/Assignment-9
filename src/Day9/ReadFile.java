package Day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


public class ReadFile {
	public static List<Movies> populateMovies(File file)
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
			        m.setMovieId(Integer.parseInt(parts[0]));//1
			        m.setMovieName(parts[1]);
			        actors.add(parts[2]);
			        actors.add(parts[3]);	
			        m.setCasting(actors);
			        m.setLanguage(parts[4]);
			        m.setMovieType(parts[5]);
			        m.setRating(Double.parseDouble(parts[6]));//5
			        String string =parts[7];
					java.sql.Date date = Date.valueOf(string);
					m.setReleaseDate(Date.valueOf(string));
			        m.setTotalBusinessDone(Double.parseDouble(parts[8]));
			        
			    } else {
			        System.out.println(line);
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
	
	
	public static void main(String[] args)
	{
		List<Movies> m=new ArrayList<Movies>();
		
		String fPath = "C:\\Users\\User\\eclipse-workspace\\Assignment-9\\src\\Day9\\Movies.txt";
		File fread=new File(fPath);
		m=populateMovies(fread);
		for(Movies ms:m)
		{
			MovieDataToDB md=new MovieDataToDB();
			md.insertMovies(ms);
		}
		
		
	
		
	}

}
