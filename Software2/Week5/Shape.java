package University-Code.Software2.Week5;
public class Shape {
	
	String color;
	boolean filled;
	
	public Shape(){
		color = "red";
		filled = true;
	}

	public Shape(String color, boolean filled){
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor(){
		return color;
	}
	
	public boolean isFilled(){
		return filled;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	public String toString(){
		String output = String.format("A Shape with color of %s and ", color);
		output += filled?"filled.":"not filled.";
		return output;
	}

}
