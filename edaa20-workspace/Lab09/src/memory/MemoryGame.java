package memory;
import se.lth.cs.pt.window.SimpleWindow;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		String backFileName = "back.jpg";
		MemoryBoard memB = new MemoryBoard(4, backFileName, frontFileNames);
		MemoryWindow memW = new MemoryWindow(memB);
		memW.drawBoard();
		int row1, row2, col1, col2;
		while (!memB.hasWon()) {
			memW.waitForMouseClick();
			row1 = memW.getMouseRow();
			col1 = memW.getMouseCol();
			while (memB.frontUp(row1, col1)) {
				memW.waitForMouseClick();
				row1 = memW.getMouseRow();
				col1 = memW.getMouseCol();
			}
			memB.turnCard(row1, col1);
			memW.drawCard(row1, col1);
			memW.waitForMouseClick();
			row2 = memW.getMouseRow();
			col2 = memW.getMouseCol();
			while (memB.frontUp(row2, col2) || (row1 == row2 && col1 == col2)) {
				memW.waitForMouseClick();
				row2 = memW.getMouseRow();
				col2 = memW.getMouseCol();
			}
			memB.turnCard(row2, col2);
			memW.drawCard(row2, col2);
			if (!memB.same(row1, col1, row2, col2)) {
				memB.turnCard(row1, col1);
				memB.turnCard(row2, col2);
				memW.delay(1000);
				memW.drawCard(row1, col1);
				memW.drawCard(row2, col2);
			}
		}
		if (memB.hasWon()) {
			String x = " You Won";
			System.out.println(x);
		//	w.writeText(x);
		}
	}
}
