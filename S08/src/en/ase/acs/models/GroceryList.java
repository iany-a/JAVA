package en.ase.acs.models;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {
    private String name;
    private List<Integer> pPrices;
    private List<String> pNames;

    //getters for calling in main
    public String name() {
        return name;
    }
    public List<Integer> pPrices() {
        return pPrices;
    }
    public List<String> pNames() {
        return pNames;
    }


    //constructor
    public GroceryList(String name, List<Integer> pPrices, List<String> pNames) {
        this.name = name;
        this.pPrices = new ArrayList<>(pPrices);
        this.pNames = new ArrayList<>(pNames);
    }

    //function to give me all the items (just the names) that have a name with a length bigger than 3
    //function that iterates through all the prices; if dividable by 3, double it, otherwise subtract 1
    //return the sum of all the item prices
    //do not change the prices themselves

    public int modifyPrice() {
        return this.pPrices.stream().map(x -> { //this is a "glorified" for each loop
            if (x % 3 == 0) x *= 2;
            else x -= 1;
            return x;
        }).reduce((x, y) -> x + y).get();
        //reduce takes an array of elements and adds them up to reduce the member count to 1.
        //return this whole chain of functions and end with .get() to receive a value for the return statement
    }

    public List<String> getProductNames() {
        return this.pNames.stream().filter(x -> {
            if (x.length() > 3) return true;
            return false;
        }).toList();
    }



}


    //classic implementation of these requirements (out of scope for this seminar)
//    List<String> getProductNames(List<String> list){
//        List<String> newList = new ArrayList<String>();
//        for(int i=0; i<list.toArray().length; i++){
//            if (list.get(i).length() > 3) newList.add(list.get(i));
//        }
//        return newList;
//    }
//
//    int getSum(List<Integer> list){
//        int sum = 0;
//        for (int i=0; i<list.toArray().length; i++){
//            int a = list.get(i);
//            if (a%3 == 0) {
//                a*=2;
//                sum += a;
//            }
//            else{
//                a -=1;
//                sum +=a;
//            }
//        }
//
//        return sum;
//    }


