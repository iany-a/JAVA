package s01;

public class Student {
	int age = 0;
	String name = "";
	String faculty = "";
	int[] grades; //int* grades in cpp
	//String[] arr;
	//double[] arr2;
	
	
	public Student() {
		this.age = 18;
		this.name = "Balaurentiu";
		this.faculty = "CSIE";
		this.grades = new int[5];
		grades[0] = 7;
		grades[1] = 9;
		grades[2] = 9;
		grades[3] = 10;
		grades[4] = 5;
		
		
	}

	public Student(int age, String name, String faculty) {
		super();
		this.age = age;
		this.name = name;
		this.faculty = faculty;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public void print() {
		System.out.println("NAME: " + this.name);
		System.out.println("AGE: " + this.age);
		System.out.println("FACULTY: " + this.faculty);
	}
	
	//clone method equivalent to copy constructor
	public static Student cloneC(Student s) {
		Student created = new Student();
		created.name = s.name;
		created.age = s.age;
		created.faculty = s.faculty;
		return created;
	}
	
	//JAVA way
	public Student clone() {
		Student created = new Student();
		created.name = this.name;
		created.age = this.age;
		created.faculty = this.faculty;
		return created;
	}
	
	
	
	
}
