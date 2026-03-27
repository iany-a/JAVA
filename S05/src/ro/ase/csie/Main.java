package ro.ase.csie;

import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] array1 = new int[]{20, 40, 30, 50, 10, 29, 35, 60};
        Book book1 = new Book("Book1", "Author1", 300, array1);

//        int[] array2 = new int[]{100, 200, 300, 400, 500, 600};
//        book1.setPagesPerChapter(array2);

        Book book2 = new Book("Book2", "Author2", 200, array1);

        List<Book> books1 = new ArrayList<>();
        books1.add(book1);
        books1.add(book2);

        List<Book> books2 = new ArrayList<>();
        books2.add(book1);
        books2.add(book2);

        //book1.setPagesPerChapter(null);

        //COLLECTIONS always do shallow copy, in the case above both books1 and books2 lists contain
        //exactly the same two objects. If one object gets modified, it gets updated in both of the lists.
        Set<Book> set = new TreeSet<>(); //sets have no duplicates
        Book b1 = new Book("Ion", "Liviu Rebreanu", 300, new int[]{100,200,50});
        Book b2 = new Book("IonButNotIon", "Ziviu Rebreanu", 300, new int[]{100,200,50});

        set.add(b1);
        set.add(b2);

        for(Book b: set){
            System.out.println(b);
        }

        Map<Book, String> map = new HashMap<>();
        //hash turns an object into a numerical value, to be put in a table
        map.put(b1, "Robert");
        map.put(b2, "Laurentiu");
        for(Book b: map.keySet()){
            System.out.println(b);
            System.out.println(map.get(b));
        }

        //for trees we need Comparable, for hashes we need equals and hashcode
        Book b3 = (Book) b2.clone();


        //by defaul the map checks key uniqueness by looking at object adresses
        map.put(b3, "John");
        map.put(b3, "Johny");
        for(Book b: map.keySet()){
            System.out.println(b);
            System.out.println(map.get(b));
        }

    }
}
