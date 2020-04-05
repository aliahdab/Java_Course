import java.util.Random;

public class RaceTurtle extends Turtle {
	private Random random;
	private int nbr;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		random = new Random();
		penDown();
		left(-90);
	}

	public void raceStep() {
		forward(random.nextInt(6) + 1);
	}

	public String toString() {
		return "Number " + nbr;

	}
}
