import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Create the objects
        GradeBook gb1 = new GradeBook("Java", new int[]{2, 3, 4});
        GradeBook gb2 = new GradeBook("Data Structures", new int[]{5, 6, 7});

        GradeBook[] initialArray = {gb1, gb2};
        Student s1 = new Student("Marius", "CSIE", initialArray);

        // 2. Add items to the ArrayList specifically
        s1.addGradeBook(gb1);
        s1.addGradeBook(gb2);

        // 3. Print the student (which now includes the list)
        System.out.println(s1);
    }
}
//generics-do in main,linkedlist a <student>-cannot change
//linkedlist<List> ImyInterface
//interface as a type-have multiple data types at any point