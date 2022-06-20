package University-Code.Software2.Week5;
public class Rectangle extends Shape {
	
	private double width;
	private double length;
	
	public Rectangle(){
		width = 1.0;
		length = 1.0;
	}
	
	public Rectangle(double width, double length){
		setWidth(width);
		setLength(length);
	}
	
	public Rectangle(double width, double length, String color, boolean filled){
		super(color, filled);
		setWidth(width);
		setLength(length);
	}
	
	public double getArea(){
		return length * width;
	}
	
	public double getLength(){
		return length;
	}
	
	public double getPerimeter(){
		return 2 * (length + width);
	}
	
	public double getWidth(){
		return width;
	}
	
	public void setLength(double length){
		if(length < 0){
			throw new IllegalArgumentException("Radius must be positive");
		}
		this.length = length;
	}
	
	public void setWidth(double width){
		if(width < 0){
			throw new IllegalArgumentException("Radius must be positive");
		}
		this.width = width;
	}
	
	public String toString(){
		return String.format("A Rectangle with width=%.2f and length=%.2f,, which is a subclass of %s", 
				width, length, super.toString());
	}



}
