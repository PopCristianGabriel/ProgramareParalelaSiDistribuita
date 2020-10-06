package com.company.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Storage  {
    private HashMap<Product,Integer> inventory;
    private int balance;
    private ReentrantLock mutex = new ReentrantLock();
    private ArrayList<Pair<Bill,String>> billsSold;

    public Storage(){
        this.inventory = new HashMap<>();
        this.balance = 0;
        this.billsSold = new ArrayList<>();
    }

    public void setInitialStorage(ArrayList<Pair<Product,Integer>> initialProducts){
        for(Pair<Product,Integer> products : initialProducts){
            this.inventory.put(products.getObject1(),products.getObject2());
        }
    }

    public void buyAnItem(Product product){
        this.mutex.lock();
        int numberOfProducts = this.inventory.get(product);
        if(numberOfProducts > 0){
            this.inventory.put(product,numberOfProducts - 1);
            this.balance += product.getPrice();
        }
        this.mutex.unlock();
    }

    public int getBalance(){
        return this.balance;
    }

    public void addBill(Bill bill, String productName) {
        this.billsSold.add(new Pair<Bill,String>(bill,productName));
    }
    public ArrayList<Pair<Bill,String>> getBillsSold(){
        return this.billsSold;
    }
}
