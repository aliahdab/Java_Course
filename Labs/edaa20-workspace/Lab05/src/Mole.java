import se.lth.cs.pt.window.SimpleWindow;

public class Mole {
	private static final int WINDOW_HEIGHT = 50; // note we write this in Cabital letters
	private static final int WINDOW_WIDTH = 30;
	private static final int SKY_HEIGHT = 15;
	private static final int GRASS_HEIGHT = 4;
	private static final int GROUND_TOP = SKY_HEIGHT + GRASS_HEIGHT;

	private Graphics g = new Graphics(WINDOW_WIDTH, WINDOW_HEIGHT, 10);

	public static void main(String[] args) {

		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}

	public void drawWorld() {
		g.rectangle(0, 0, WINDOW_WIDTH, SKY_HEIGHT, Colors.BLUE); // The Sky
		g.rectangle(0, SKY_HEIGHT, WINDOW_WIDTH, GRASS_HEIGHT, Colors.GREEEN); // The grass
		g.rectangle(0, GROUND_TOP, WINDOW_WIDTH, WINDOW_HEIGHT, Colors.SOIL);

	}

	public void dig() {
		int x = g.getWidth() / 2; // for begin in the center
		int y = g.getHeight() / 2;
		while (true) {
			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();
			if (key == 'w' && y > GROUND_TOP && y < WINDOW_HEIGHT) {
				g.block(x, y, Colors.TUNNEL);
				y = y - 1;

			} else if (key == 'a' && x > 0 && x < WINDOW_WIDTH) {
				g.block(x, y, Colors.TUNNEL);
				x = x - 1;
			} else if (key == 's' && y >= GROUND_TOP && y < WINDOW_HEIGHT - 1) {
				g.block(x, y, Colors.TUNNEL);
				y = y + 1;
			} else if (key == 'd' && x >= 0 && x < WINDOW_WIDTH - 1) {
				g.block(x, y, Colors.TUNNEL);

				x = x + 1;
			}
		}
	}
}