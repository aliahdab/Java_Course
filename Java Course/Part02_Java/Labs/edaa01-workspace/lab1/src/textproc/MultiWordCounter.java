package textproc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {

		

	private Map<String, Integer> landscaps;

	
//	constructor
	public MultiWordCounter(String[] lands) {

		landscaps = new TreeMap<String, Integer>();
		for (int i = 0; i < lands.length; i++) {
			landscaps.put(lands[i], 0);

		}
	}

	@Override
	public void process(String w) {
		// TODO Auto-generated method stub
		if (landscaps.containsKey(w)) {
			landscaps.put(w, landscaps.get(w) + 1);
		}

//		for (String key : this.landscaps.keySet()) {
//			if (key.equals(w)) {
//				int x = landscaps.get(key) + 1;
//				landscaps.put(key, x);
//			}
	}

	@Override
	public void report() {
		// TODO Auto-generated method stub
		for (String key : landscaps.keySet()) {
			int value = landscaps.get(key);
			System.out.println(key + " : " + value);

		
		}
	}
}
