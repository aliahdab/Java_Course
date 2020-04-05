import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class AnimatedSquare{
	public static void main(String[] args) {
		SimpleWindow w;
		w = new SimpleWindow(500, 500, "Ali's window");
		Square sq;
		sq = new Square(50, 50, 100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int n=10;
			double disX = Math.sqrt(Math.pow((w.getMouseX() - sq.getX()),2))/n;
			double disY = Math.sqrt(Math.pow((w.getMouseY() - sq.getY()),2))/n;
	//		System.out.println(w.getMouseX());
	//	System.out.println(w.getMouseY());
			for (int i = 0; i <n; i+=1) {
				sq.move((int)disX,(int)disY);
				sq.draw(w);
			}		
		}

			
		
	
}
}