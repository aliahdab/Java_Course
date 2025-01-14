package mountain;

public class Side {
	private Point p1;
	private Point p2;

	public Side(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public int hashCode() {
		return p1.hashCode() + p2.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		if (obj == this)
			return true;
		
		if (obj instanceof Side) {
			Side side1 = (Side) obj;
			Side side2 = (Side) obj;
			if ((side1.p1 == this.p1 && side2.p2 == this.p2) || (side1.p2 == this.p1 && side2.p1 == this.p2)) {
				return true;
			}
		}
		return false;

	}
	
}
