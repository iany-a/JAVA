import java.util.Arrays;

public class GradeBook {
    private String subject;



    private int[]grades;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int[] getGrades() {
        int []newGrades=new int[this.grades.length];
        for(int i=0;i<this.grades.length;i++){
            newGrades[i]=this.grades[i];
        }
        return newGrades;
    }

    public void setGrades(int[] grades) {
        this.grades=new int[grades.length];
        for(int i=0;i<this.grades.length;i++)
            this.grades[i]=grades[i];
    }
    public GradeBook(String subject, int[] grades) {
        this.subject = subject;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return subject + ": " + Arrays.toString(grades);
    }
}
//jcf-java collection framework
//we need iterable for???->collection-list,set,queue,you have add and remove
//then you add implementations like arrayed list,linked list
//arrayed list vector