
public class Sudoku {

	private int[][] board;
	private final static int SIZE = 9;
	private final int EMPTY = 0;

	public Sudoku() {
		this.board = new int[9][9];
	}

	/**
	 * 
	 * we check if a possible number is already in a row.
	 *
	 * @param row    is an integer to row where we need to check the number
	 * @param number is an integer to number we need to check
	 * @return true if possible false otherwise.
	 * @author aliahdab
	 */

	private boolean isInRow(int row, int number) {
		for (int i = 0; i < SIZE; i++) {
			if (board[row][i] == number)
				return true;
		}
		return false;
	}

	/**
	 * 
	 * we check if a possible number is already in a row.
	 *
	 * @param col    is an integer to column where to check the number
	 * @param number is an integer to number we need to check
	 * @return true if possible false otherwise.
	 * @author aliahdab
	 */
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < SIZE; i++) {
			if (board[i][col] == number)
				return true;
		}
		return false;
	}

	/**
	 * 
	 * we check if a possible number is already in a box (region of 3*3 rows and
	 * columns).
	 *
	 * @param row    is an integer for row in a box where to check the number
	 * @param col    is an integer for column in a box where to check the number
	 * @param number is an integer for the number we need to check
	 * @return true if possible false otherwise.
	 * @author aliahdab
	 */

	private boolean isInBox(int row, int col, int number) {
		// to know in which box the number is
		int r = row - row % 3;
		int c = col - col % 3;

		// check the number in a specific
		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (board[i][j] == number)
					return true;

		return false;
	}

	/**
	 * 
	 * we check if the number is already exist in that row or that col or that box.
	 *
	 * @param row    is an integer for row where to check the number
	 * @param col    is an integer for column where to check the number
	 * @param number is an integer for the number we need to check
	 * @return true if possible false otherwise.
	 * @author aliahdab
	 */
	private boolean isAllowed(int row, int col, int number) {
		return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
	}

	/**
	 * we solve the grid and return true if it is solvable and false if not.
	 * 
	 * @return true if possible to solve false otherwise.
	 * @author aliahdab
	 * 
	 * 
	 * 
	 * 
	 */

	public boolean solve() {
		if (notContainDuplicate()) {
			return false;
		} else {
			if (solvesudoku(0, 0)) {
				return true;
			}
			return false;
		}
	}

	private boolean solvesudoku(int x, int y) {

		for (int row = x; row < SIZE; row++) {
			for (int col = y; col < SIZE; col++) {
				if (board[row][col] == EMPTY) {
					for (int number = 1; number <= SIZE; number++) {
						if (isAllowed(row, col, number)) {
							board[row][col] = number;

							if (solvesudoku(x + 1, y)) {
								solvesudoku(x, y + 1);
							} else {
								return true;

							}
						}
					}

					return false;
				}
			}
		}

		return true;
	}

//		if (board[x][y] == 0){
//			for (int number = 1; number <= SIZE; number++) {
//				if (isAllowed(x, y, number)) {
//					board[x][y] = number;
//					if (x < 8) {
//						if (solvesudoku(x+1, y)) {
//							return true;
//						} else {
//							board[x][y] = 0;
//						}					
//					} else if (y < 8) {
//						if (solvesudoku(0, y + 1)) {
//							return true;
//						} else {
//							board[x][y] = 0;
//						}
//					} else {
//						return true;
//					}
//				}
//			}
//			
//			return false;
//		} else {
//			if (x < 8) {
//				return solvesudoku(x+1 , y);
//			} else if (y < 8) {
//				return solvesudoku(x, y+1 );
//			} else {
//				return true;
//			}
//		}
//	}

	/**
	 * we check the grid if it has doblecated in colmns and return true if so and
	 * false if not. *
	 * 
	 * @return true if grid has doblecated in colmns and false if not.
	 * @author aliahdab
	 * @param the grid which we want to check
	 * 
	 */

	private boolean isDoblecatedInCol() {

		for (int col = 0; col < SIZE; col++) {
			for (int row = 0; row < SIZE; row++) {
				for (int x = 0; x < SIZE; x++) {
					if (row != x && board[row][col] == board[x][col] && board[row][col] != 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * we check the grid if it has doblecated in rows and return true if so and
	 * false if not.
	 * 
	 * @return true if grid has doblecated in rows and false if not.
	 * @author aliahdab
	 * @param the grid which we want to check
	 */
	private boolean isDoblecatedInRow() {

		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				for (int x = 0; x < SIZE; x++) {
					if (col != x && board[row][col] == board[row][x] && board[row][col] != 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * we check the grid if it has doblecated in boxs and return true if so and
	 * false if not.
	 * 
	 * @return trueF if grid has doblecated in boxs and false if not.
	 * @author aliahdab
	 * @param the grid which we want to check
	 */
	private boolean isDoblecatedInBox() {

		for (int col = 0; col < SIZE; col++) {
			for (int row = 0; row < SIZE; row++) {
				int number = board[row][col];
				int r = row - row % 3;
				int c = col - col % 3;

				for (int i = r; i < r + 3; i++)
					for (int j = c; j < c + 3; j++)
						if (i != row && j != col && board[i][j] == number && number != 0)
							return true;
			}
		}
		return false;
	}

	public boolean notContainDuplicate() {
		if (!isDoblecatedInRow() && !isDoblecatedInCol() && !isDoblecatedInBox()) {
			return false;
		}
		return true;
	}

	public void display() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(" " + board[i][j]);
			}

			System.out.println();
		}

		System.out.println();
	}

	public void setFieldValue(int row, int col, int val) {
		board[row][col] = val;
	}

	public int getFieldValue(int row, int col) {
		return board[row][col];
	}
}
