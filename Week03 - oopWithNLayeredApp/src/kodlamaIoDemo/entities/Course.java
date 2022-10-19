package kodlamaIoDemo.entities;

public class Course {
	
	private String courseName;
	private double price;
	
	public Course(String courseName, double price) {
		this.courseName = courseName;
		this.price = price;
	}

	public String getName() {
		return courseName;
	}

	public void setName(String courseName) {
		this.courseName = courseName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
