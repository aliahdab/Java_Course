import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class DrawThreeSquares {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(250, 250, 100);
		int x = 20;
		Square sq1 = new Square(sq.getX() + x, sq.getY() + x, 100);
		sq.draw(w);
		sq1.draw(w);
		Square sq2 = null;
		sq2.draw(w);
	}
}
