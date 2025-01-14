package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };
	
	public static void main(String[] args) throws FileNotFoundException {

		long t0 = System.nanoTime();
		 // Code that we want to time
		
		Scanner scan = new Scanner (new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>();
		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}
		scan.close();
		
		List<TextProcessor> list = new ArrayList<TextProcessor>();
		
	
		list.add(new SingleWordCounter("nils"));
//	    list.add(new SingleWordCounter("norge"));
//    	list.add(new MultiWordCounter(REGIONS));
//		list.add(new GeneralWordCounter(stopwords));
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

    

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			
			for (TextProcessor a : list) {
				a.process(word);
			}
		}
		s.close();
		for (TextProcessor a : list) {
			a.report();
		}
		
		long t1 = System.nanoTime();
		System.out.println("Time: " + (t1 - t0) / 1000000.0 + " ms");
		
	}
}