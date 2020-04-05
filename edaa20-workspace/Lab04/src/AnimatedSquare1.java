import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class AnimatedSquare1 {
	public static void main(String[] args) {
		SimpleWindow w;
		w = new SimpleWindow(500, 500, "Ali's window");
		Square sq;
		sq = new Square(50, 50, 400);
		//sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int i = 100;
			double disX = Math.sqrt(Math.pow((w.getMouseX() - sq.getX()), 2)) / i;
			double disY = Math.sqrt(Math.pow((w.getMouseY() - sq.getY()), 2)) / i;
			for (i = 0; i < 10; i += 1) {
				sq.move((int) disX, (int) disY);
				// sq.draw(w);
				while (sq.getSide() > 0) {
					sq.draw(w);
					sq.erase(w);
					SimpleWindow.delay(10);

					sq.setSide(sq.getSide() - 10);
				}
			}

		}
	}
}