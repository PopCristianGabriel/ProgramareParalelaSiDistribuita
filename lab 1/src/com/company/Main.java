package com.company;

import com.company.Model.Bill;
import com.company.Model.Pair;
import com.company.Model.Product;
import com.company.Model.Storage;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	Storage storage =  new Storage();
	Product product1 = new Product("product1",20);
	Product product2 = new Product("product2",30);
    Product product3 = new Product("product3",10);

	ArrayList<Pair<Product,Integer>> initialProducts = new ArrayList<Pair<Product,Integer>>();
	initialProducts.add(new Pair<Product,Integer>(product1,2000));
	initialProducts.add(new Pair<Product,Integer>(product2,2000));
	initialProducts.add(new Pair<Product,Integer>(product3,2000));
	storage.setInitialStorage(initialProducts);

	ArrayList<Pair<Product,Integer>> bill1Products = new ArrayList<Pair<Product,Integer>>();
	bill1Products.add(new Pair<Product,Integer>(product1,150));
	bill1Products.add(new Pair<Product,Integer>(product2,230));
	bill1Products.add(new Pair<Product,Integer>(product3,190));

	ArrayList<Pair<Product,Integer>> bill2Products = new ArrayList<Pair<Product,Integer>>();
	bill2Products.add(new Pair<Product,Integer>(product1,500));
	bill2Products.add(new Pair<Product,Integer>(product2,320));
	bill2Products.add(new Pair<Product,Integer>(product3,600));

	ArrayList<Pair<Product,Integer>> bill3Products = new ArrayList<Pair<Product,Integer>>();
	bill3Products.add(new Pair<Product,Integer>(product1,123));
	bill3Products.add(new Pair<Product,Integer>(product2,234));
	bill3Products.add(new Pair<Product,Integer>(product3,300));

	Bill bill1 = new Bill(storage,bill1Products);
	Bill bill2 = new Bill(storage,bill2Products);
	Bill bill3 = new Bill(storage,bill3Products);

	bill1.start();
	bill2.start();
	bill3.start();

	bill1.join();
	bill2.join();
	bill3.join();
	

	System.out.println(storage.getBalance());

	for(Pair<Bill,String> bill : storage.getBillsSold()){
		System.out.println("Bill:" + bill.getObject1().toString() + " has finished buyng " + bill.getObject2());
	}


    }
}
