package com.company;


public class MyCollectionImpl implements MyCollection {

    //Employee[] array = new Employee[300];

    Employee[] array;
    int readCounter;
    int writeCounter;

    public MyCollectionImpl() {
        array=new Employee[300];
        readCounter=0;
        writeCounter=0;
    }

    public synchronized void add(Employee emp) {
        array[writeCounter++]=emp;
    }

    public synchronized Employee get() {
        return array[readCounter++] ;
    }

    public int getSize(){
        return this.writeCounter;
    }

}