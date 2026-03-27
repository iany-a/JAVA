package ro.ase.csie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Book implements Comparable<Book>, Cloneable {
    private String title;
    private String authorName;
    private int noPages;
    private int[] pagesPerChapter;
    //list of integers (with <generics>
    public List<Integer> pagesPerChapter2 = new ArrayList<>();
    //sum < total no of pages


    public List<Integer> getPagesPerChapter2() {
        return pagesPerChapter2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPagesPerChapter2(List<Integer> pagesPerChapter2) {
        //this.pagesPerChapter2 = pagesPerChapter2;
        this.pagesPerChapter2 = new ArrayList<>();
        for (Integer integer : pagesPerChapter2) {
            this.pagesPerChapter2.add(integer);
        }

    }

    public Book(){
        //default constructor
    }

    public Book(String title, String authorName, int noPages, int[] pagesPerChapter) {
        this.title = title;
        this.authorName = authorName;
        this.noPages = noPages;
        this.pagesPerChapter = pagesPerChapter;
    }

    public int[] getPagesPerChapter() {
        int[] dummy = new int[this.pagesPerChapter.length];
        for(int i=0; i<this.pagesPerChapter.length; i++){
            this.pagesPerChapter[i] = pagesPerChapter[i];
        }
        return dummy;
    }

    public void setPagesPerChapter(int[] pagesPerChapter) {
        int sum = 0;
        for (int i=0; i<pagesPerChapter.length; i++) {
            sum += pagesPerChapter[i];
        }

        if (this.noPages < sum) throw new UnsupportedOperationException("Sum too big.");
//        if (this.noPages < sum) try {
//            throw new Exception();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        this.pagesPerChapter = new int[pagesPerChapter.length];
        for (int i=0; i<pagesPerChapter.length; i++){
            this.pagesPerChapter[i] = pagesPerChapter[i];
        }
    }

    //StringBuilder = faster than default toString() method
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ro.ase.csie.Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", authorName='").append(authorName).append('\'');
        sb.append(", noPages=").append(noPages);
        sb.append(", pagesPerChapter=").append(Arrays.toString(pagesPerChapter));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Book b) {
        if(this.noPages > b.noPages) return 1;
        if(this.noPages < b.noPages) return -1;
        return 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book copy = (Book)super.clone();
        copy.pagesPerChapter = new int[this.pagesPerChapter.length];
        System.arraycopy(this.pagesPerChapter, 0, copy.pagesPerChapter, 0, this.pagesPerChapter.length);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return noPages == book.noPages && Objects.equals(title, book.title) && Objects.equals(authorName, book.authorName) && Objects.deepEquals(pagesPerChapter, book.pagesPerChapter) && Objects.equals(pagesPerChapter2, book.pagesPerChapter2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorName, noPages, Arrays.hashCode(pagesPerChapter), pagesPerChapter2);
    } //.hash gives all attributes to be hashed

    //    @Override
//    public boolean equals(Object o) {
////        if (this.authorName.equals(((ro.ase.csie.Book)o).authorName)){
////
////        }
//        ro.ase.csie.Book other = (ro.ase.csie.Book)o;
//        if (this.authorName.equals(other.authorName)){
//            return true;
//        }
//
//        if (this.title.equals(other.title)){
//            return true;
//        }
//
//        return true;
//
////        if (o == null || getClass() != o.getClass()) return false;
////        ro.ase.csie.Book book = (ro.ase.csie.Book) o;
////        return noPages == book.noPages && Objects.equals(title, book.title) && Objects.equals(authorName, book.authorName) && Objects.deepEquals(pagesPerChapter, book.pagesPerChapter) && Objects.equals(pagesPerChapter2, book.pagesPerChapter2);
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//        //return Objects.hash(title, authorName, noPages, Arrays.hashCode(pagesPerChapter), pagesPerChapter2);
//    }
//

}
