package codinguniwork.software2.week5;

public class Square extends Rectangle {
	
	public Square(){
		super();
	}
	
	public Square(double side){
		super(side, side);
	}

	public Square(double side, String color, boolean filled){
		super(side, side, color, filled);
	}
	
	public double getSide(){
		return getWidth();
	}

	public void setLength(double length){
		if(length<0){
			throw new IllegalArgumentException();
		}
		
		// WARNING: need a call to super class method to avoid infinite recursion
		super.setWidth(length);
		super.setLength(length);
	}
	
	public void setSide(double side){
		if(side<0){
			throw new IllegalArgumentException();
		}
		setWidth(side);
		setLength(side);
	}
	
	public void setWidth(double width){
		if(width<0){
			throw new IllegalArgumentException();
		}
		// WARNING: need a call to super class method to avoid infinite recursion
		super.setWidth(width);
		super.setLength(width);
	}
	
	public String toString(){
		return String.format("A Square with side=%.2f, which is a subclass of %s", 
				getWidth(), super.toString());
	}


}
