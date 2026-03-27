package ro.ase.csie.scanner;

public class Scanner {
    public static void main(String[] args) {
        System.out.println("Enter your name here: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello " + name);
    }
}
