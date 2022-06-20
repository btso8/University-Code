package University-Code.Software2.Week5;
public class Line {
	private Point start, end;
	private String color;
	
	public Line(Point start, Point end){
		this.setStart(start);
		this.setEnd(end);
		this.setColor("black");
	}
	

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		if(end == null){
			throw new IllegalArgumentException();
		}
		this.end = end;
	}


	public Point getStart() {
		return start;
	}


	public void setStart(Point start) {
		if(start == null){
			throw new IllegalArgumentException();
		}
		this.start = start;
	}
	
	public double getLength(){
		return Math.sqrt(Math.pow(start.x-end.x, 2)+Math.pow(start.y-end.y, 2));
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString(){
		return "["+start+", "+end+"]";
	}

}
