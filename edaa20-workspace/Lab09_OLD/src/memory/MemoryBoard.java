package memory;

import java.util.Random;

public class MemoryBoard {

	private MemoryCardImage[][] mainboard;
	private int size;
	private MemoryCardImage[] frontimage;
	private String backimage;
	private Random rand;
	private boolean[][] testcard;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {

		this.mainboard = new MemoryCardImage[size][size];
		this.size = size;
		this.frontimage = new MemoryCardImage[frontFileNames.length];
		this.backimage = backFileName;
		this.testcard = new boolean[size][size];
		for (int i = 0; i < frontFileNames.length; i++)
			frontimage[i] = new MemoryCardImage(frontFileNames[i], backFileName);
		createCards(backFileName, frontFileNames);
	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {
		int row, col, index;

		for (int i = 0; i < size * size / 2; i++) {
			row = rand.nextInt(size);
			col = rand.nextInt(size);
			index = 0;
			while (index < 2) {
				if (mainboard[row][col] == null) {
					mainboard[row][col] = frontimage[i];
					index++;

				} else {
					row = rand.nextInt(size);
					col = rand.nextInt(size);
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
		return mainboard[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		testcard[r][c] = !testcard[r][c];
	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return testcard[r][c];
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {
		return false;
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
