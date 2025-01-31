import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);
		w.setLineColor(Color.blue);
		w.setLineWidth(10);
		w.lineTo(150, 150);
		w.setLineColor(Color.red);
		w.writeText("Hello");
		w.setLineWidth(5);
		while (true) {
			// vänta tills användaren klickar på en musknapp
			// rita en linje till den punkt där användaren klickade
			w.waitForEvent();
			int x = w.getMouseX();
			int y = w.getMouseY();
			w.lineTo(x, y);
			System.out.println(0.1 * 10);
			System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1
			+ 0.1 + 0.1 + 0.1 + 0.1 + 0.1);

		}
		
	}
}
