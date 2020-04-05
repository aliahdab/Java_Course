/** Kasta en tärning flera gånger och räkna hur många kast som krävs för att få en sexa. */
public class RollUntilSix {

	public static void main(String[] args) {
		Die d = new Die();
		d.roll();
		int nbrRolls = 1;
		while (d.getDots() != 6) {
			d.roll();
			nbrRolls++;
		}
		System.out.println("Det krävdes " + nbrRolls + " kast för att få en 6:a.");

	}

}