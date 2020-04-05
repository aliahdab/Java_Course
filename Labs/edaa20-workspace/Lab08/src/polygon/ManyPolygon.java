package polygon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import se.lth.cs.pt.window.SimpleWindow;

public class ManyPolygon {

	public static void main(String[] args) {
		Scanner scan = null;
		scan = new Scanner(System.in);
		System.out.println("Enter the file name");
		File file = new File(scan.nextLine());
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file ");
			System.exit(1);
		}
		SimpleWindow w = new SimpleWindow(600, 600, "A polygon");


		while (scan.hasNextLine()) {
			String s = scan.nextLine();
			Polygon pol = new Polygon();
			Scanner sc = new Scanner(s);
			while (sc.hasNext()) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				pol.addVertex(x, y);
			}
			sc.close();
			pol.draw(w);
		}


	}
}
