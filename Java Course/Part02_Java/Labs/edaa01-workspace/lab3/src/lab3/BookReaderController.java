package lab3;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import textproc.GeneralWordCounter;


public class BookReaderController extends Application {

	Button button3 = new Button("Find");
	RadioButton button1 = new RadioButton("Alphabetic");
	RadioButton button2 = new RadioButton("Frequency");

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();
		HBox hbox = new HBox();
		
		TextField textField = new TextField();
		textField.setMaxWidth(Double.MAX_VALUE);
		textField.setFont(new Font("Arial", 10));
		
		hbox = new HBox(button1, button2, textField, button3);
		hbox.setSpacing(1);
		button2.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(textField, Priority.ALWAYS);
		
        ToggleGroup group = new ToggleGroup();
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);
     
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>();
		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}
		scan.close();
		GeneralWordCounter counter = new GeneralWordCounter(stopwords);
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			counter.process(word);
		}

		s.close();

		ObservableList<Entry<String, Integer>> words = FXCollections.observableArrayList(counter.getWords());
		ListView<Entry<String, Integer>> listview = new ListView<Entry<String, Integer>>(words);
		root.setCenter(listview);
		root.setBottom(hbox);

		Comparator<Entry<String, Integer>> c1 = (o1, o2) -> {
			if (o1.getKey().compareTo(o2.getKey()) > 0) {
				return 1;
			}
			if (o1.getKey().compareTo(o2.getKey()) < 0) {
				return -1;
			}
			return 0;
		};

		Comparator<Entry<String, Integer>> c2 = (o1, o2) -> {
			if (o1.getValue() > (o2.getValue())) {
				return 1;
			}
			if (o1.getValue() > (o2.getValue())) {
				return -1;
			}
			return 0;
		};

		button1.setOnAction((e) -> Collections.sort(words, c1));
		EventHandler<ActionEvent> d2 = (e) -> Collections.sort(words, c2);
		button2.setOnAction(d2);

		EventHandler<ActionEvent> d3 = (e) -> {
			for (Entry<String, Integer> word : words) {
				if (word.getKey().equalsIgnoreCase(textField.getText().trim())) {
				listview.getSelectionModel().select(word);
					listview.scrollTo(word);
				} 
			}
		};

		button3.setOnAction(d3);
		button3.setDefaultButton(true);
	};

	public static void main(String[] args) {
		Application.launch(args);
	}

}
