package com.company.Model;

import java.util.ArrayList;

public class Bill extends Thread {
    private Thread t;
    private Storage storage;
    private ArrayList<Pair<Product,Integer>> productsToBuy;

    public Bill(Storage storage, ArrayList<Pair<Product,Integer>> productsToBuy){
        this.storage = storage;
        this.productsToBuy = productsToBuy;
    }

    public void buyEverything(){
        for(Pair product : this.productsToBuy){
            while((Integer)product.getObject2() > 0) {
                this.storage.buyAnItem((Product) product.getObject1());
                product.setObject2((Integer) product.getObject2() - 1);
            }
            this.storage.addBill(this,((Product)product.getObject1()).getName());
        }
    }

    @Override
    public void run() {
        this.buyEverything();
    }

}
