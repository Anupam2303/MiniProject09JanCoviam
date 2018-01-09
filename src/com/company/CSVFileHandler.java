package com.company;
import com.company.Employee;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.ObjectUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CSVFileHandler implements MyFileHandler {
    static CSVReader reader;
    static CSVWriter writer;
    public static final String PATH = "/Users/apple/Downloads/employee.csv";




    public CSVFileHandler(){
        try {
            writer = new CSVWriter(new FileWriter(PATH, true));
            reader =  new CSVReader(new FileReader(PATH));
        }catch (Exception e){

        }

    }

    public void write(Employee employee){
        try{


            //Create record
            String rec = "\n"+employee.firstName+","+employee.lastName+","+employee.dateOfBirth+","+employee.experience;
            String [] record = rec.split(",");
            //Write the record to file
            writer.writeNext(record);

            //close the writer
            writer.close();

        }catch (Exception e){

        }




    }

    public Employee read(){

        Employee e = new Employee();
        int flag =0;
        try{

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            String line[];
            if((line = reader.readNext()) != null)
            {
                e.setFirstName(line[0]);
                e.setLastName(line[1]);
                Date dt = df.parse(line[2]);
                flag=1;
                e.setDateOfBirth(dt);
                e.setExperience(Double.parseDouble(line[3]));


            }
        }catch (Exception ex){

        }
        if(flag==1)
        return  e;
        else
            return null;

    }

}