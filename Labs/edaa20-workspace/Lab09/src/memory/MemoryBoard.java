package memory;

import java.util.Random;

public class MemoryBoard {

	private int size;
	private MemoryCardImage[][] board;
	private boolean[][] checkcard;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {

		this.size = size;
		this.board = new MemoryCardImage[size][size];
		this.checkcard = new boolean[size][size];
		createCards(backFileName, frontFileNames);

	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {
		MemoryCardImage[] cardimages = new MemoryCardImage[frontFileNames.length];
		for (int i = 0; i < frontFileNames.length; i++)
			cardimages[i] = new MemoryCardImage(frontFileNames[i], backFileName);
		int ro, co, count;
		Random rand = new Random();
		for (int i = 0; i < size * size / 2; i++) {
			ro = rand.nextInt(size);
			co = rand.nextInt(size);
			count = 0;
			while (count < 2) {
				if (board[ro][co] == null) {
					board[ro][co] = cardimages[i];
					count++;
				} else {
					ro = rand.nextInt(size);
					co = rand.nextInt(size);
				}
			}
		}

	}

	/** Tar reda på brädets storlek. */
	public int getSize() {

		return size;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {

		return board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {

		checkcard[r][c] = !checkcard[r][c];

	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {

		return checkcard[r][c];
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {

		return board[r1][c1] == board[r2][c2];
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {

		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (!frontUp(i, j))
					return false;
		return true;
	}
}
