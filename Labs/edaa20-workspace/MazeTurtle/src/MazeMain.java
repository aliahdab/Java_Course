import java.util.Scanner;
import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeMain {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(360, 360, "Maze's window");
		//w.setLineWidth(1);
		Turtle t = new Turtle(w, 0, 0);
		MazeWalker mazewalker = new MazeWalker(t);
		Scanner scan = new Scanner(System.in); // How do you can close the scanner?
		System.out.println("Enter a number between (1-5) to choose the Maze the Turtle  will walk through");
		Maze m = new Maze(scan.nextInt());
		m.draw(w);
		mazewalker.walk(m);
		scan.close();

	}
}
