import java.awt.Point;

import se.lth.cs.pt.window.SimpleWindow;

public class Triangle {

	private Point[] vertices;

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		vertices = new Point[3];
		vertices[0] = new Point(x1, y1);
		vertices[1] = new Point(x2, y2);
		vertices[2] = new Point(x3, y3);
	}

	public void move(int dx, int dy) {
		for (int i = 0; i < vertices.length; i++) {
			vertices[i].translate(dx, dy);
		}
	}

	public void draw(SimpleWindow w) {
		w.moveTo((int) Math.round(vertices[0].getX()), (int) Math.round(vertices[0].getY()));
		for (int i = 1; i < vertices.length; i++) {
			w.lineTo((int) Math.round(vertices[i].getX()), (int) Math.round(vertices[i].getY()));
		}
		w.lineTo((int) Math.round(vertices[0].getX()), (int) Math.round(vertices[0].getY()));
	}

	public boolean hasVertex(int x, int y) {
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].getX() == x && vertices[i].getY() == y)
				;
			{
				return true;
			}

		}

		return false;
	}
	public boolean hasVertex(Point p) {
		for (int i=0; i< vertices.length;i++) {
			if (vertices[i].getX()== p.getX() && vertices[i].getY()== p.getY())
		
			return true;
		}
		return false;
		
	}
}
