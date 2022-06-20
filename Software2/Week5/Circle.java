package University-Code.Software2.Week5;
public class Circle extends Shape {
	
	private double radius;
	
	public Circle(){
		radius = 1.0;
	}
	
	public Circle(double radius){
		setRadius(radius);
	}


	public Circle(double radius, String color, boolean filled){
		super(color, filled);
		setRadius(radius);
	}
	
	
	public double getRadius(){
		return radius;
	}
	
	public double getArea(){
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getPerimeter(){
		return Math.PI * 2 * radius;
	}
	
	public void setRadius(double radius){
		if(radius < 0){
			throw new IllegalArgumentException("Radius must be positive");
		}
		this.radius = radius;
	}
	
	public String toString(){
		return String.format("A Circle with radius=%.2f, which is a subclass of %s", 
				radius, super.toString());
	}

}
