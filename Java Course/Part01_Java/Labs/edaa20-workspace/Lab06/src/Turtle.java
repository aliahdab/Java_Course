import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */

	// instance variablies

	private SimpleWindow w;
	private double xcoord; // the position on x-axis
	private double ycoord; // the position on y-axis
	private boolean penIsDown; // the pen is down or up
	private int dir; // the turtle's head angle

	// the constructor
	public Turtle(SimpleWindow w, int x, int y) {
		xcoord = x;
		ycoord = y;
		this.penIsDown = false;
		this.dir = 90;
		this.w = w;

	}

	/** Sänker pennan. */
	public void penDown() {
		penIsDown = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		penIsDown = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {

		w.moveTo((int) xcoord, (int) ycoord);
		xcoord = xcoord + n * Math.cos(Math.toRadians(dir));
		ycoord = ycoord - n * Math.sin(Math.toRadians(dir));
		if (penIsDown) {
			w.lineTo((int) Math.round(xcoord), (int) Math.round(ycoord)); /// You have to do round here

		} else {
			w.moveTo((int) xcoord, (int) ycoord);

		}

	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) { 
		dir = dir + beta;
	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {

		xcoord = newX;
		ycoord = newY;
		w.moveTo(newX, newY);

	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() { 
		dir = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) xcoord;
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) ycoord;
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return dir;
	}
}
