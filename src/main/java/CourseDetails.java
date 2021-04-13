import java.util.LinkedList;
import java.util.List;


public class CourseDetails {
	private String name;
	private String chapters;
	private String description;
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChapters() {
		return chapters;
	}
	public void setChapters(String chapters) {
		this.chapters = chapters;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	CourseDetails(String a, String b, String c, int d){
		this.name = a;
		this.chapters = b;
		this.description = c;
		this.price = d;
	}
	
}
