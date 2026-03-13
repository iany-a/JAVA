
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private String faculty;
    private GradeBook[] gradeBook;
    private List<GradeBook> listGradeBook;

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

    public GradeBook[] getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(GradeBook[] gradeBook) {
        this.gradeBook = gradeBook;
    }
    public Student(String name, String faculty, GradeBook[] gradeBook) {
        this.name = name;
        this.faculty = faculty;
        this.gradeBook=gradeBook;
        this.listGradeBook=new ArrayList<>();
    }
    //group some variable-do another class
    void addGradeBook(GradeBook gradeBook){
        listGradeBook.add(gradeBook);//add stuff in lists

    }


//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", faculty='" + faculty + '\'' +
//                ", gradeBook=" + Arrays.toString(gradeBook) +
//                '}';
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", arrayGrades=" + Arrays.toString(gradeBook) + // The array
                ", listGrades=" + listGradeBook +              // The ArrayList
                '}';
    }

}