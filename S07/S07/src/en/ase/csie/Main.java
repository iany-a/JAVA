package en.ase.csie;

import en.ase.csie.abstracts.Operation;
import en.ase.csie.models.Division;
import en.ase.csie.models.Multiplication;
import en.ase.csie.models.Substraction;
import en.ase.csie.models.Sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Sum sum = new Sum();
        Substraction sub = new Substraction();

        Operation op = new Sum(); //up-cast

        System.out.println(sum.operation(3,9));
        System.out.println(sub.operation(3,9));

        System.out.println(op.operation(3,9));
        op = new Division(); //re-writing the function at runtime - it's perfectly normal

        System.out.println(op.operation(5,1));

        op = new Multiplication();
        System.out.println(op.operation(8,2));

        op = new Operation(){
            @Override
            public int operation(int a, int b) {
                return (int) Math.pow(a,b); //same return type always when overriding methods!
            }
        };

        System.out.println(op.operation(2,3));

        //lambda functions
        op = (a,b) -> (int) Math.pow(a,b);
        //(parameters) -> the returned function  - without specifying the type, only casting if types don't match
        //anonymous function (parameters) { operation }
        //the lamba function looks for matching functions by their name and arguments, and executes it
        op = (a,b) -> (int) Math.pow(a,b);
        System.out.println(op.operation(2,4));

        //other type of lamba function implementation:
        //(parameters) -> {
        //                  body of function
        //                }

        op = (a,b) ->{
            int avg = 0;
            avg += a + b;
            //avg += (a + b);
            return avg/2;
        };
        System.out.println(op.operation(2,10));

        //lambda functions can only be used in classes that have only ONE function implementation
        //even with multiple parameter combinations to distinguish two functions in a class, a lambda function
        //will not be able to be called from this class.

        List<Integer> arrList = new ArrayList<>();
        arrList.add(5);
        arrList.add(51);
        arrList.add(50);
        arrList.add(25);
        arrList.add(25);
        arrList.add(25);
        arrList.add(25);
        arrList.add(25);

//        for(int i=0; i<arrList.size(); i++){
//            for(int j=i+1; j<arrList.size(); j++){
//                if (Objects.equals(arrList.get(i), arrList.get(j))){
//                    arrList.remove(i);
//                }
//            }
//        }

        System.out.println(arrList);

        System.out.println(arrList.stream().distinct().toList());
        //arrList.stream() transform your list into mangled data that can be used for different computations
        //.distinct() takes that mangled data and shows only unique values
        //.toList() takes the processed mangled data and packages it into a new list


    }
}
