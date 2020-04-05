import se.lth.cs.pt.window.SimpleWindow;

public class TriangleExample {

	public static void main(String[] args) {
		Triangle t = new Triangle(10, 150, 50, 10, 90, 120);
		SimpleWindow w = new SimpleWindow(200, 200, "Triangel");
		t.draw(w);
		t.move(20, 20);
		t.draw(w);
	}
}
