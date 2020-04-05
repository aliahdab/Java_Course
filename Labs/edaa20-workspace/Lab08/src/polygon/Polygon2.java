package polygon;

import java.util.ArrayList;

import se.lth.cs.pt.window.SimpleWindow;

public class Polygon2 {
	private ArrayList<Point> vertices;

	public Polygon2() {
		vertices = new ArrayList<Point>();
	}

	public void addVertex(int x, int y) {
		vertices.add(new Point(x, y));

	}

	public void draw(SimpleWindow w) {
		if (vertices.size() == 0) {
			return;
		}
		Point last = vertices.get(vertices.size() - 1);
		w.moveTo(last.getX(), last.getY());
		for (Point p : vertices) {
			w.lineTo(p.getX(), p.getY());
		}

	}
}