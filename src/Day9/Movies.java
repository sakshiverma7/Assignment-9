package Day9;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;



public class Movies implements Serializable, Comparable<Movies>{
	private int movieId;
	private String movieName,movieType,language;
	private Date releaseDate;
	private List<String> casting;
	private double rating , totalBusinessDone;
	

public void setMovieId(int movieId) {
	this.movieId = movieId;
}

public void setMovieName(String movieName) {
	this.movieName = movieName;
}

public void setTotalBusinessDone(double totalBusinessDone) {
	this.totalBusinessDone = totalBusinessDone;
}

public void setRating(double rating) {
	this.rating = rating;
}

public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
}


public void setLanguage(String language) {
	this.language = language;
}

public void setMovieType(String movieType) {
	this.movieType = movieType;
}
public List<String> getCasting() {
	return casting;
}
public void setCasting(List<String> casting) {
	this.casting = casting;
}

@Override
public int compareTo(Movies o) {
	return (int) (this.getTotalBusinessDone() - o.getTotalBusinessDone());
}

public int getMovieId() {
	return movieId;
}
public String getMovieName() {
	return movieName;
}
public double getTotalBusinessDone() {
	return totalBusinessDone;
}
public double getRating() {
	return rating;
}
public Date getReleaseDate() {
	return releaseDate;
}
public String getLanguage() {
	return language;
}
public String getMovieType() {
	return movieType;
}
@Override
public String toString() {
	return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", totalBusinessDone=" + totalBusinessDone
			+ ", rating=" + rating + ", releaseDate=" + releaseDate + ", language=" + language + ", movieType="
			+ movieType + ", casting=" + casting + "]";
}
}