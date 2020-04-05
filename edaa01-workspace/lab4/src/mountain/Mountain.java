package mountain;

import java.util.HashMap;
import java.util.Map;
import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {

	private Point p1;
	private Point p2;
	private Point p3;
	private double length;
	private final double dev;
	private Map<Side, Point> map;

	public Mountain(int length, double dev) {
		super();
		this.length = length;
		this.dev = dev;
		map = new HashMap<Side, Point>();
	}

	@Override
	public String getTitle() {

		return "Kochs Monutain";
	}

	@Override
	public void draw(TurtleGraphics turtle) {

		turtle.moveTo(turtle.getWidth() / 2.0 - length / 2.0, turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0);
		turtle.penUp();
		p1 = new Point((int) turtle.getX(), (int) turtle.getY());
		turtle.setDirection(0);
		turtle.forward(length - 122);
		p2 = new Point((int) turtle.getX(), (int) turtle.getY());
		turtle.setDirection(120);
		turtle.forward(length + 70);
		p3 = new Point((int) turtle.getX(), (int) turtle.getY());
		turtle.setDirection(240);
		turtle.forward(length + 134);
		fractalTriangle(turtle, order, length, p1, p2, p3, dev);
	}

	private void fractalTriangle(TurtleGraphics turtle, int order, double length, Point p1, Point p2, Point p3,double dev) {

		Point p4;
		Point p5;
		Point p6;
		if (order == 0) {
			turtle.moveTo(p1.getX(), p1.getY());
			turtle.penDown();
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
			turtle.penUp();
		} else {
			Side side1 = new Side(p1, p2);
			Side side2 = new Side(p3, p2);
			Side side3 = new Side(p3, p1);

		p4=	 getMidPoint(side1, p1, p2,dev);
		p5 = getMidPoint(side2, p2, p3,dev);
		p6 = getMidPoint(side3, p3, p1,dev);

			fractalTriangle(turtle, order - 1, length, p4, p2, p5, dev / 2);
			fractalTriangle(turtle, order - 1, length, p4, p6, p1, dev / 2);
			fractalTriangle(turtle, order - 1, length, p4, p5, p6, dev / 2);
			fractalTriangle(turtle, order - 1, length, p5, p3, p6, dev / 2);
		}
	}

	private Point getMidPoint(Side side, Point point1, Point point2, double dev) {
		double d = RandomUtilities.randFunc(dev / 2);
		if (map.containsKey(side)) {
			Point p = map.get(side);
			map.remove(side);
			return p;
		} else {
			Point p = new Point(((point1.getX() + point2.getX()) / 2),
					(int) (((point1.getY() + point2.getY()) / 2) + d));
			map.put(side, p);
			return p;
		}

	}

}

