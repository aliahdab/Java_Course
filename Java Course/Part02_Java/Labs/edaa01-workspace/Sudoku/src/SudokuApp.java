
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SudokuApp extends Application {
	private TilePane board = new TilePane();
	private Button solveButton = new Button("Solve ");
	private Button btn2 = new Button("Clear");
	private MySecondTextField[][] gridTextField = new MySecondTextField[9][9];

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));

		solveButton.setOnAction((e) -> {
			Sudoku sudoku = new Sudoku();
			getTextFieldGrid(sudoku);
			if (!sudoku.solve()) {
				Alert errorAlert1 = new Alert(AlertType.ERROR);
				errorAlert1.setContentText("Sudoku Unsolvable");
				errorAlert1.showAndWait();
			} else {
				setTextFieldGrid(sudoku);
			}
		});

//		Clear Button Action
		btn2.setOnAction((e) -> {

			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					gridTextField[row][col].setText("");
				}
			}
		});

		stage.setTitle("Sudoku");
		stage.show();
	}
	
	public void getTextFieldGrid(Sudoku sudoku) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (gridTextField[row][col].getText().equals("")) { // does null work ?
					sudoku.setFieldValue(row, col, 0);
				} else {
					sudoku.setFieldValue(row, col, Integer.parseInt(gridTextField[row][col].getText(0, 1)));;
				}
			}
		}
	}

	public void setTextFieldGrid(Sudoku sudoku) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				gridTextField[row][col].setText(Integer.toString(sudoku.getFieldValue(row, col)));
			}
		}
	}

	private Parent createContent() {
		Pane root = new Pane();

		root.setPrefSize(700, 600);
		solveButton.setPrefSize(100, 60);
		solveButton.setTranslateX(180);
		solveButton.setTranslateY(500);
		solveButton.setFont(new Font("Arial", 16));
		solveButton.setTextFill(Color.BLUE);

		btn2.setPrefSize(100, 60);
		btn2.setTranslateX(410);
		btn2.setTranslateY(500);
		btn2.setFont(new Font("Arial", 16));
		btn2.setTextFill(Color.CRIMSON);

		board = generateBoard(9, 9);

		root.getChildren().addAll(board, solveButton, btn2);
		return root;
	}

	private TilePane generateBoard(int colNumbers, int rowNumbers) {
		board = new TilePane(Orientation.HORIZONTAL);
		board.setPrefColumns(colNumbers);
		board.setPrefRows(rowNumbers);
		board.setPadding(new Insets(3, 3, 3, 3));
		for (int col = 0; col < colNumbers; col++) {
			for (int row = 0; row < rowNumbers; row++) {
				MySecondTextField textfield = new MySecondTextField();
				gridTextField[col][row] = textfield;
				board.getChildren().add(gridTextField[col][row]);
				if ((row < 3 || row > 5) && (col < 3 || col > 5) || (row > 2 && row < 6) && (col > 2 && col < 6)) {
					textfield.setStyle("-fx-text-inner-color: black;" + "-fx-border-color:black;"
							+ "-fx-background-color: wheat;");
				} else {
					textfield.setStyle("-fx-text-inner-color: slategrey;" + "-fx-border-color:black;"
							+ "-fx-background-color: white;");
				}
			}
		}
		board.autosize();
		return board;
	}

	public class MySecondTextField extends TextField {

		private MySecondTextField() {

			this.setText("");
			this.setFont(new Font("Arial", 27));
			this.setMaxSize(77, 60);

			addTextLimiter(this, 1);
			this.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					if (!"123456789".contains(keyEvent.getCharacter())) {
						keyEvent.consume();
					}
				};
			});
		}

		private void addTextLimiter(final TextField tf, final int maxLength) {
			tf.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(final ObservableValue<? extends String> ov, final String oldValue,
						final String newValue) {
					if (tf.getText().length() > maxLength) {
						String s = tf.getText().substring(0, maxLength);
						tf.setText(s);
					}
				}
			});
		}
	}
}
