import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
	private Turtle turtle;

	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;

	}

	public void walk(Maze maze) {
		turtle.jumpTo(maze.getXEntry(), maze.getYEntry());
		turtle.penDown();

		while (!maze.atExit(turtle.getX(), turtle.getY())) {
			if (maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY())) {
				if (maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY())) {
					turtle.left(-90);
//					if (maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY())) {
//						turtle.left(-90);
//					}
					continue;
				}
			} else {
				turtle.left(90);
			}
			turtle.forward(1);
			SimpleWindow.delay(5);
		}
	}

}