import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSudoku {

	private int[][] emptygrid;
	private int[][] grid;
	private Sudoku sudoku;
	private Sudoku emptysudoku;
	private int[] numbers;
	private Boolean[] checknumber;

	@BeforeEach
	void setUp() throws Exception {
		numbers = new int[9];
		for (int i = 0; i < 9; i++) {
			numbers[i] = i + 1;
		}
		checknumber = new Boolean[9];
		for (int i = 0; i < 9; i++) {
			checknumber[i] = false;
		}

		emptygrid = new int[9][9];

		// solvable grid
		grid = new int[][] {
			{ 9, 0, 0, 1, 0, 0, 0, 0, 5 },
			{ 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 8, 0, 0, 0, 0 },
			{ 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 },
			{ 2, 0, 0, 3, 0, 0, 0, 0, 6 },
			{ 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 },
			};

		emptysudoku = new Sudoku();
		sudoku = new Sudoku();
	}

	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	void testSolveAnEmptyGrid() {

		boolean x = false;
		int value;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				value = emptysudoku.getFieldValue(i, j);
				if (value != 0) {
					x = true;
				}
			}
		}
		assertTrue("Sudoku is not empty ", x != true);

		assertTrue("Wrong to sovle an empty Sudoku ", emptysudoku.solve() == true);
		x = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				value = emptysudoku.getFieldValue(i, j);
				if (value == 0) {
					x = true;
				}
			}
		}
		assertTrue("Sudoku after solving still empty ", x == false);

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				for (int i = 0; i < 9; i++) {
					if (emptysudoku.getFieldValue(row, col) == numbers[i]) {
						checknumber[col] = true;
					}
				}
			}
			Boolean b = false;
			for (int i = 0; i < 9; i++) {
				if (checknumber[i] = false) {
					b = true;
				}
				assertTrue("Checking numbers from 1 to 9 by row ", b == false);
			}
		}
	}

	@Test
	void testSolveFilledGrid() {
		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				sudoku.setFieldValue(row, col, grid[row][col]);
			}
		}
		
		assertTrue("Wrong while sovling a Sudoku ",sudoku.solve() == true);
		sudoku.display();
		System.out.println(sudoku.solve());
		
		Boolean x = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku.getFieldValue(i, j) == 0) {
					x = true;
				}
			}
		
		}
		sudoku.display();
//		assertTrue("Sudoku after solving still empty ", x == false);

//		int[][] gridafter = new int[9][9];
//		gridafter = sudoku.getBoard();
//		for (int row = 0; row < 9; row++) {
//			for (int col = 0; col < 9; col++) {
//				for (int i = 0; i < 9; i++) {
//					if (gridafter[row][col] == numbers[i]) {
//						checknumber[col] = true;
//					}
//				}
//			}
//			Boolean b = false;
//			for (int i = 0; i < 9; i++) {
//				if (checknumber[i] = false) {
//					b = true;
//				}
//				assertTrue("Error Checking all numbers 1 to 9 in all rows and all colums ", b == false);
//			}
//		}
//	}
//
//	@Test
//	void testIsInRow() {
//		assertFalse("not give the expected result", emptysudoku.isInRow(0, 3));
//		assertTrue("not give the expected result", emptysudoku.isInRow(1, 0));
//		assertTrue("not give the expected result which is 9", sudoku.isInRow(8, 9));
//		assertFalse("not give the expected result which is 5", sudoku.isInRow(6, 5));
//		emptysudoku.solve();
//		sudoku.solve();
//		assertTrue("not give the expected result after solveing", emptysudoku.isInRow(0, 3));
//		assertFalse("not give the expected result after solveing", emptysudoku.isInRow(1, 0));
//		assertTrue("not give the expected result after solveing", sudoku.isInRow(8, 9));
//		assertTrue("not give the expected result after solveing", sudoku.isInRow(6, 5));
//	}
//
//	@Test
//	void testIsInCol() {
//		assertFalse("not give the expected result", emptysudoku.isInCol(2, 3));
//		assertTrue("not give the expected result", emptysudoku.isInCol(1, 0));
//		assertTrue("not give the expected result for 1", sudoku.isInCol(8, 1));
//		assertFalse("not give the expected result for 3", sudoku.isInCol(6, 3));
//		emptysudoku.solve();
//		sudoku.solve();
//		assertTrue("not give the expected result after solving", emptysudoku.isInCol(2, 3));
//		assertFalse("not give the expected result after solving", emptysudoku.isInCol(1, 0));
//		assertTrue("not give the expected result for 1 after solving", sudoku.isInCol(8, 1));
//		assertFalse("not give the expected result for 3", sudoku.isInCol(6, 0));
//	}
//
//	@Test
//	void testIsInBox() {
//		assertFalse("does not give the expected result", emptysudoku.isInBox(2, 3, 3));
//		assertTrue(" does not give the expected result", emptysudoku.isInBox(1, 5, 0));
//		assertTrue("does not give the expected result  for 6", sudoku.isInBox(8, 7, 6));
//		assertFalse("does not give the expected result for 8", sudoku.isInBox(6, 5, 8));
//		emptysudoku.solve();
//		sudoku.solve();
//		assertTrue("does not give the expected result", emptysudoku.isInBox(2, 3, 3));
//		assertFalse(" does not give the expected result", emptysudoku.isInBox(1, 5, 0));
//		assertTrue("does not give the expected result  for 6", sudoku.isInBox(8, 7, 6));
//		assertTrue("does not give the expected result for 8", sudoku.isInBox(6, 5, 8));
//	}
//
//	@Test
//	void testIsAllowed() {
//		assertFalse("allwoed to add zero number", emptysudoku.isAllowed(0, 0, 0));
//		assertTrue(" does not give the expected result", emptysudoku.isAllowed(4, 6, 7));
//		assertFalse(" allwoed to add zero number", sudoku.isAllowed(8, 7, 0));
//		assertTrue(" does not give the expected result for 8", sudoku.isAllowed(6, 5, 8));
//		assertFalse(" does not give the expected result for 5", sudoku.isAllowed(0, 8, 5));
//		emptysudoku.solve();
//		sudoku.solve();
//		assertTrue(" allwoed to add zero number", emptysudoku.isAllowed(0, 0, 0));
//		assertFalse("does not give the expected result", emptysudoku.isAllowed(4, 6, 7));
//		assertTrue("allwoed to add zero number", sudoku.isAllowed(8, 7, 0));
//		assertFalse(" does not give the expected result for 8", sudoku.isAllowed(6, 5, 8));
//		assertFalse("does not give the expected result for 5", sudoku.isAllowed(0, 8, 5));
	}
}
