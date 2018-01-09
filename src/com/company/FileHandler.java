package com.company;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileHandler extends Thread {

    static MyCollectionImpl collection;

    static {
        collection = new MyCollectionImpl();

    }

    public static void main(String args[]) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable worker1 = new readCSV(collection);
        Runnable worker2 = new readJSON(collection);
        Runnable worker3 = new readXML(collection);

        executor.submit(worker2);
        executor.submit(worker1);
        executor.submit(worker3);

        executor.shutdown();




    }

}
