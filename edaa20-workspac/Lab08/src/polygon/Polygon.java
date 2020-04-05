package polygon;

import se.lth.cs.pt.window.SimpleWindow;

public class Polygon {
	private Point[] vertcies;
	private int n = 0;
	
	public Polygon() {
		vertcies = new Point[10];
	}

	public void addVertex(int x, int y) {
		vertcies[n] = new Point(x, y);
		n++;
	}
	public void draw(SimpleWindow w) {
		if (n == 0) return;
		
		w.moveTo(vertcies[n-1].getX(), vertcies[n-1].getY());
		for (int i = 0; i < n; i++) {
			w.lineTo(vertcies[i].getX(), vertcies[i].getY());
		}
		//	w.lineTo(vertcies[0].getX(), vertcies[0].getY());
	}

}
