
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class PersonExample {
	/** Prints all the people in the list that fulfill the condition. */

	public static void print(List<Person> persons, PersonCondition condition) {
		for (Person p : persons) {
			if (condition.test(p)) {
				System.out.println(p.toString());
			}
		}
	}
//
//	private static class AgeCondition implements PersonCondition {
//		public boolean test(Person p) {
//			return p.getAge() >= 18;
//		}
//	}

//	private static class AgeCondition implements PersonCondition {
//		public boolean test(Person p) {
//			return p.getAge() >= 18;
//		}
//	}

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Nilsson, Sten", 13));
		persons.add(new Person("Jonsson, Camilla", 23));
		persons.add(new Person("Hermansson, Lena", 38));
		persons.add(new Person("Fransson, Anneli", 15));
		persons.add(new Person("Lundstrom, David", 21));
		persons.add(new Person("Bjork, Stefan", 20));
		persons.add(new Person("Andersson, Gun", 55));
		persons.add(new Person("Lundgren, Carina", 12));
		persons.add(new Person("Svensson, Ulf", 47));

		// (#)

		// Collections.sort(persons, new Alphapaticorder());

		Comparator<Person> c1 = (o1, o2) -> {
			if (o1.getName().compareTo(o2.getName()) > 0) {
				return 1;
			}
			if (o1.getName().compareTo(o2.getName()) < 0) {
				return -1;
			}
			return 0;
		};

	Collections.sort(persons, c1);

		Comparator<Person> c2 = (o1, o2) -> {
			if (o1.getAge() > o2.getAge()) {
				return 1;
			}
			if (o2.getAge() > o1.getAge()) {
				return -1;
			}
			return 0;
		};

		
		Collections.sort(persons, c2);
		
		;
		PersonCondition cond1 = (w) -> {
			return w.getAge() >= 18;
		};

		System.out.println();
		System.out.println("...... The Collection where persons are adult .........");
		print(persons, cond1);

		PersonCondition cond2 = (p) -> {
			return p.toString().startsWith("Lund");
		};

		System.out.println();
		System.out.println("...... The Collection where person's name starts with Lund .........");
		print(persons, cond2);
		System.out.println();

		/* .................................... */

		Predicate<Person> cond3 = (p) -> p.getName().charAt(0) == 'B';

		System.out.println();
		System.out.println("...... The Collection after Removed names where first char is 'B' .........");
		System.out.println();

		persons.removeIf(cond3);
		for (Person p : persons) {
			System.out.println(p);
		}

//		PersonCondition cond = new AgeCondition(); // (*)
//		print(persons, cond); // (*)

	}

}
