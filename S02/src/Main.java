import en.ase.csie.classes.*;

public class Main {


    public static void main(String[] args) {


        Product p1 = new Product("milk", "dairy", new int[]{10,20,30}, 5);
        System.out.println(p1.getName());
        for (int i=0; i<3; i++) {
            System.out.println(p1.getPriceHistory()[i]);
            //System.out.println(p1.priceHistory[i]); //only works with private
        }

        //Product p2 = p1; shallow copy, don't use!

        Product p2 = p1.clone();
        //int[] priceHistory = p1.getPriceHistory();
        p1.priceHistory[0] = 1000;
        //priceHistory[0] = 1000;
        System.out.println("The program is empty");
        p1.setName("Bread");
        p1.setQuantity(25);
        p1.print();
        p2.print();

        for(int i: p1.priceHistory){
            System.out.println(i);
        }



    }
}
