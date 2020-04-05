import java.util.ArrayList;

public class TurtleRace {
	private static final ArrayList<RaceTurtle> turtle = new ArrayList<RaceTurtle>();
	private static final ArrayList<RaceTurtle> win = new ArrayList<RaceTurtle>();

	public static boolean raceNotOver() {
		for (int i = 0; i < turtle.size(); i++) {
			if (turtle.get(i).getX() < RaceWindow.X_END_POS) {
				return true;
			}
		}
		
		return false;
	}

	public static void race(int i) {
		if (turtle.get(i).getX() < RaceWindow.X_END_POS)
			turtle.get(i).raceStep();
		else {
			win.add(turtle.get(i));
			turtle.remove(turtle.get(i));
		}
	}

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		for (int i = 0; i < 8; i++)
			turtle.add(new RaceTurtle(w, i + 1));
		//			
		while (raceNotOver()) {
			for (int i = 0; i < turtle.size(); i++) {
				race(i);
				RaceWindow.delay(1);
			}
		}

		win.add(turtle.get(0));
		for (int i = 0; i < 3; i++)
			System.out.println("In place :" + (i + 1) + " " + win.get(i));
	}


}
