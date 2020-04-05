import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class RandomTurtle {
	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(800, 800, "Turtle's World");
		Turtle u = new Turtle(w, 400, 400);
		Random rand = new Random();
		u.penDown();
		for (int i = 0; i < 1000; i++) {
			u.forward(rand.nextInt(10) + 1);
			u.left(rand.nextInt(361) - 180);
		}
		
		
	}
}
