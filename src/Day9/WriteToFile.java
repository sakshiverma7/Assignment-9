package Day9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

public class WriteToFile {
	
	public void write(Movies movie) {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\Assignment-9\\src\\Day9\\Movies.txt");

		FileWriter fr;
		try {
			fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);
			int id=movie.getMovieId();
			String mv=movie.getMovieName();
			double business=movie.getTotalBusinessDone();
			double rating=movie.getRating();
			Date dt=movie.getReleaseDate();
			String lang=movie.getLanguage();
			String type=movie.getMovieType();
			List<String> actorNames=movie.getCasting();
			String entry="";
			
			
			String Id=String.valueOf(id);
			String bus=String.valueOf(business);
			String rtg=String.valueOf(rating);
			String dates=dt.toString();
			String actname="";
			for(int i=0;i<actorNames.size();i++)
			{
			 actname=actname+""+actorNames.get(i)+",";
			}
			String data=id+","+mv+","+actname+""+lang+","+type+","+rtg+","+dates+","+bus;
			pr.println(data);
			pr.close();
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
			
}