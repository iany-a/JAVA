package Main;

import en.ase.acs.interfaces.Printable;
import en.ase.acs.models.GroceryList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Printable err = new Printable(){ //anonymous class

            @Override
            public String log(String message) {
                return "[ERROR]" + message;
            }
        };

        System.out.println(err.log("Variable not valid."));

        Printable info = (message) -> "[INFO]" + message; //lambda implementation
        System.out.println(info.log("Line can be reformatted."));

        Printable debug = msg -> "[DEBUG]" + msg;
        System.out.println(debug.log("Program started."));

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        List<String> list2 = new ArrayList<String>();
        list2.add("Milk");
        list2.add("OatMeal");
        list2.add("Bananas");
        list2.add("Eggs");
        list2.add("AP");

        GroceryList g1 = new GroceryList("List A", list1, list2);
        System.out.println(g1.getProductNames());
        System.out.println(g1.modifyPrice());
        System.out.println(g1.pNames());

    }
}
