package com.company;

class readXML implements Runnable {
    MyCollection collection;

    readXML(MyCollection collection) {
        this.collection = collection;
    }

    public void run() {
        XMLFileHandler fw = new XMLFileHandler();

        Employee emp;
        while((emp = fw.read()) != null) {
            collection.add(emp);
            System.out.println("[XML] Employee Added. Thread name: "+ Thread.currentThread().getName());
        }
    }
}
