
public class Tile {
	private char letter;
	private int value;

	public Tile(char letter, int value) {
		this.letter = letter;
		this.value = value;
	}

	public void printTile(Tile tile) {
		System.out.println("The instance variable letter is " + tile.letter);
		System.out.println("The instance variable value is " + tile.value);
	}

	public void testTile() {
		Tile tile = new Tile('z', 10);
		printTile(tile);
	}

	public String toString() {
		return "A tile with " + this.letter + " and " + this.value;
	}

	public boolean equals(Tile that) {
		return this.letter == that.letter && this.value == that.value;
	}

	public char getLetter() {
		return this.letter;
	}

	public int getValue() {
		return this.value;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public void setValue(int value) {
		this.value = value;
	}
}