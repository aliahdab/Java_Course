package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class GeneralWordCounter implements TextProcessor {

	private Set<String> stopwords;
	private Map<String, Integer> counts;

	public GeneralWordCounter(Set<String> set) {
		stopwords = set;
		this.counts = new HashMap<String, Integer>();

	}

	@Override
	public void process(String w) {
		// TODO Auto-generated method stub
		if (this.stopwords.contains(w)) {
			return;
		}
		if (!counts.containsKey(w)) {
			counts.put(w, 1);

		} else {
			counts.put(w, counts.get(w) + 1);

		}
	}

	public Set<Map.Entry<String, Integer>> getWords() {
		return counts.entrySet();

	};

	public void report() {
		// TODO Auto-generated method stub
		Set<Map.Entry<String, Integer>> wordSet = counts.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

		wordList.sort(new WordCountComparator());
		for (int i = 0; i < 15; i++) {

			System.out.println(wordList.get(i));
		}

//		
//		for (String key : counts.keySet()) {
//			int value = counts.get(key);
//			if (value >= 200) {
//				System.out.println(key + " : || " + value +" ||");
//			}
//		}

	}
}