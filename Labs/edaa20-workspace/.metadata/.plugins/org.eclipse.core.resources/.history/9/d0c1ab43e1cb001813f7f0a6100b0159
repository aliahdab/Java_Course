import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */

						/// instance variables
	private int x; 				//x coordinate
	private int y; 				//y coordinate
	private SimpleWindow w;   	//
	private int dir;
	
	public Turtle(SimpleWindow w, int x, int y) {

		// Constructor
		this.w = w;
		this.xcoord = x;
		this.ycoord = y;
		this.dir = 90;
	}

	/** Sänker pennan. */
	public void penDown() {

	}

	/** Lyfter pennan. */
	public void penUp() {

	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {

	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) { // setter
		this.dir = getDirection() + beta;

	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {
		w.moveTo(newX, newY);
	
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() { // Setter
		this.dir = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return xcoord;
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return ycoord;
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return dir;
	}
}
