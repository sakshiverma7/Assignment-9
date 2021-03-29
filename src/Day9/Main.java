package Day9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("Select operation to be performed");
		int opt=0;
		System.out.println("1. Add new movie in the list");
		System.out.println("4. Find the Movies realeased in entered year");
		System.out.println("5. Find the list of movies by actor");
		System.out.println("6. Update Movie Rating");
		System.out.println("7. Update Business Done by Movie");
		System.out.println("8. Find the set of movies as per the review comments  done business more than entered amount descending order of amount");
		
		Scanner sc=new Scanner(System.in);
		opt=sc.nextInt();
		switch(opt)
		{
		case 1:
		{
			AddNewMovie am=new AddNewMovie();
			am.addMovie();
			break;
		}
		case 2:
		{
			String fPath = "S:\\Sakshi\\NewTextFile.txt";
			File fread=new File(fPath);
			SerializeDeserialize sd=new SerializeDeserialize();
			List<Movies> movieList=sd.populateMovies(fread);
			sd.serializeMovies(movieList, "FileSerialized.txt");
			break;
		}
		case 3:
		{
			String fPath = "S:\\\\Sakshi\\\\NewTextFile.txt";
			File fread=new File(fPath);
			SerializeDeserialize sd=new SerializeDeserialize();
			System.out.println("3. Deserialize movies  from given files");
			ArrayList<Movies> movie=sd.deserializeMovies("FileSerialized.txt");
			System.out.println(movie);
			break;
		}
		case 4:
		{
			FindMovieByYear fm=new FindMovieByYear();
			List<Movies> m=fm.searchMovie();
			System.out.println(m);
			break;
		}
		case 5:
		{
		
			FindMovieByActors actors=new FindMovieByActors();
			List<Movies> lm=actors.findByActor();
			System.out.println(lm);
			break;
		}
		case 6:
		{
			UpdateMovieRating actors=new UpdateMovieRating();
			List<Movies> lm=actors.updateRating();
			System.out.println(lm);
			break;
		}
		case 7:
		{
			UpdateMovieBusiness updateB=new UpdateMovieBusiness();
			 List<Movies> m1=updateB.updateBusiness();
			 System.out.println(m1);
			break;
		}
		case 8:
		{
			BusinessDoneDesc bd=new BusinessDoneDesc();
			TreeSet<Movies> m=bd.businessDone(5000);
			System.out.println(m);
			break;
		}
		}
		
	}

}