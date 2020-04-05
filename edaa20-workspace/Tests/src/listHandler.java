import java.util.ArrayList;

public class listHandler {

	public static boolean add(ArrayList<String> wordList, String word) {
		for (int i = 0; i < wordList.size(); i++) {
			if (wordList.get(i).equals(word)) {
				return false;
			}
		}
		wordList.add(word);
		return true;
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("ett");
		list.add("två");
		list.add("tre");
		listHandler.add(list,"tre");


	}
}