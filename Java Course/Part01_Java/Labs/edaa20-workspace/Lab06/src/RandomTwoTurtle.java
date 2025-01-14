import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class RandomTwoTurtle {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(800, 800, "Turtle's World");
		Turtle u = new Turtle(w, 550, 350);
		Turtle t = new Turtle(w, 350, 350);
		Random rand = new Random();
		u.penDown();
		t.penDown();

		while (Math.sqrt((Math.pow(u.getX() - t.getX(), 2) + Math.pow(u.getY() - t.getY(), 2))) >= 50) {
			u.forward(rand.nextInt(10) + 1);
			u.left(rand.nextInt(361) - 180);
			t.forward(rand.nextInt(10) + 1);
			t.left(rand.nextInt(361) - 180);
			SimpleWindow.delay(10);
		}
	}
}
