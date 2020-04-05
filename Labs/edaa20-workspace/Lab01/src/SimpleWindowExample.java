		
import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class SimpleWindowExample {

	public static void main(String[] args) {
	
		SimpleWindow w = new SimpleWindow(500, 500, "Drawing Window");
		w.moveTo(100, 100);
		w.setLineColor(Color.CYAN);
		w.setLineWidth(5);
		w.lineTo(150, 100);
		w.moveTo(100, 100);
		w.lineTo(100, 150);
		w.lineTo(150, 150);
		w.lineTo(150, 100);
		w.moveTo(300, 300);
		w.setLineColor(Color.red);
		w.lineTo(300,400);
		w.moveTo(400, 400);
		w.setLineColor(Color.GREEN);
		w.lineTo(450,400);
		w.moveTo(50, 50);
		w.setLineColor(Color.black);
	    w.writeText("Hi, This is my first Java program " );
		
		
	
	}

}
