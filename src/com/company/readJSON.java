package com.company;

class readJSON implements Runnable {
    MyCollection collection;

    readJSON(MyCollection collection) {
        this.collection = collection;
    }

    public void run() {
        JSONFileHandler fw = new JSONFileHandler();

        Employee emp;
        int counter=0;
        while((emp = fw.read()) != null) {
            collection.add(emp);
            System.out.println("[JSON] Employee Added. Thread name: "+ Thread.currentThread().getName());
            counter ++;
        }

        System.out.println("[JSON] Total Record: " + counter);
    }
}
