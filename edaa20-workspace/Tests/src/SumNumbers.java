
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumNumbers {

	public static void main( String args[]) {
		Scanner scan = null;
		try {
			scan = new Scanner (new File("/home/ali/eclipse-workspace/edaa20-workspace/Tests/bin/numbers.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("the file cannot open");	
			System.exit(1);
		
		}
		int sum = 0;
		while (scan.hasNextInt()) {
			sum=sum+scan.nextInt();
		}
		System.out.println("Summa: " + sum);
		scan.close();
		}

}
