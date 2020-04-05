import java.util.Random;

public class Die {
	private Random rand;  // slumptalsgenerator
	private int dots; 	  // antal prickar som visas
	private int sides;

	/** Skapar en 6-sidig tärning. */
	public Die() {
		sides = 6;
		rand = new Random();
		roll();
		// eller bara this(6); för att anropa den andra konstruktorn med argumentet 6
	}
	
	/** Skapar en tärning med nbrSides sidor. */
	public Die(int nbrSides) {
		sides = nbrSides;
		rand = new Random();
		roll();
	}

	/** Kastar tärningen. */
	public void roll() {
		dots = rand.nextInt(sides) + 1;
	}

	/** Tar reda på vad tärningen visar. */
	public int getDots() {
		return dots;
	}
}