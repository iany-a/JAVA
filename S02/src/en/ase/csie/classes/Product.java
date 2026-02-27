package en.ase.csie.classes;

import java.sql.SQLOutput;

public class Product {
    String name = "";
    String productType = "";
    public int[] priceHistory; //square brackets at data type
    int quantity = 5;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int[] getPriceHistory() {
        int[] newPriceHistory = new int[this.priceHistory.length];
//        for (int i=0; i<newPriceHistory.length; i++){
//            newPriceHistory[i] = this.priceHistory[i];
//        }

        //faster FOR loop
        System.arraycopy(this.priceHistory, 0, newPriceHistory,0, this.priceHistory.length);

        return newPriceHistory;
    }

    public void setPriceHistory(int[] priceHistory) {
        this.priceHistory = new int[priceHistory.length];
        for(int i =0; i<priceHistory.length; i++) {
            this.priceHistory[i] = priceHistory[i];
        }
    }

    public Product(String name, String productType, int[] priceHistory, int quantity) {
        this.name = name;
        this.productType = productType;
        this.priceHistory = priceHistory;
        this.quantity = quantity;
    }

    public void print(){
        System.out.println(this.name);
        System.out.println(this.productType);
        System.out.println(this.quantity);
        for (int i=0; i<this.priceHistory.length; i++){
            System.out.println(this.priceHistory[i]);
        }

    }

    @Override //annotation
    public Product clone() { //less code to write, using setters and getters
        return new Product(this.name, this.productType, this.getPriceHistory(), this.quantity);

    }

    public Product clone2(){ //2nd way of cloning, to omit using setters and getters
        Product clone = new Product("N/A", "N/A", null, 0);
        clone.name = this.name;
        clone.productType = this.productType;
        clone.priceHistory = new int[this.priceHistory.length];
        for(int i =0; i<this.priceHistory.length; i++) {
            clone.priceHistory[i] = this.priceHistory[i];
        }
        clone.quantity = this.quantity;
        return clone;
    }
}
