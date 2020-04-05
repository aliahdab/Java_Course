import java.util.Scanner;

public class ArraysOfObjects {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);

		Student[] students= new Student[4]; 
		System.out.println("Enter the student Grade then name for the student ");
		for (int i=0; i<students.length;i++) {
			students[i]= new Student(scan.nextLine(),scan.nextInt());
		}
		System.out.printf("#\tStudent\tGrade\n");
		System.out.printf("-\t------\t-----\n");
		
		for(int i=0;i<students.length;i++) {
			
			System.out.printf("%d\t%s\t%d\n",i,students[i].getName(),students[i].getGrade());
			
		}
	}
}
