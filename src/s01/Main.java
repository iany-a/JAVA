package s01;
public class Main {
	
	static void add(int x, int y) {
		x = x+y;
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Hello world!");
		int x = 5;
		int y = 2;
		System.out.println(x+y);
		
		Student student = new Student(20, "Odobastian", "CSIE");
		//Student student;
		//Student student = null;
		
		System.out.println(student);
		
		student.print();
		
		add (x,y);
		System.out.println(x);
		
		Student student2 = Student.cloneC(student);
		Student student3 = student.clone();
		
		student2.print();
		student3.print();
		
		Student student4 = new Student();
		Student student5 = student4.clone();
		student5.print();
		
	}
}
