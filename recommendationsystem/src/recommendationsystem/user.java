	package recommendationsystem;
	
	import java.awt.List;
import java.util.ArrayList;
import java.util.Map;
	
	public class user {
	
	private int id;
	private int movieid;
	private int rating;
	private ArrayList<String> geners;
	private Map<Integer,Integer> map_of_rate;
	private List moviesisaw;
	
	
	
	public user(int id, int movieid, int rating, ArrayList<String> geners, Map<Integer,Integer> map_of_rate, List moviesisaw) {
		super();
		this.id = id;
		this.movieid = movieid;
		this.rating = rating;
		this.geners = geners;
		this.map_of_rate = map_of_rate;
		this.moviesisaw = moviesisaw;
	}
	
	
	public Map<Integer,Integer> getMap_of_rate() {
		return map_of_rate;
	}


	public void setMap_of_rate(Map<Integer,Integer> map_of_rate) {
		this.map_of_rate = map_of_rate;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	
	
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public ArrayList<String> getGeners() {
		return geners;
	}
	public void setGeners(ArrayList<String> geners) {
		this.geners = geners;
	}
	public List getMoviesisaw() {
		return moviesisaw;
	}
	public void setMoviesisaw(List moviesisaw) {
		this.moviesisaw = moviesisaw;
	}


	@Override
	public String toString() {
		return "user [id=" + id + ", movieid=" + movieid + ", rating=" + rating + ", geners=" + geners
				+ ", map_of_rate=" + map_of_rate + ", moviesisaw=" + moviesisaw + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
