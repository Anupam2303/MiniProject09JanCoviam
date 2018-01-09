package com.company;

class readCSV implements Runnable {
    MyCollection collection;

    readCSV(MyCollectionImpl collection) {
        this.collection = collection;
    }

    public void run() {
        CSVFileHandler fw = new CSVFileHandler();

        Employee emp;
        int counter = 0;
        while((emp = fw.read()) != null) {


            collection.add(emp);
            System.out.println("[CSV] Employee Added. Thread name: "+ Thread.currentThread().getName());
            counter ++;
        }
        System.out.println("[CSV] Total Record: " + counter);

    }
}
