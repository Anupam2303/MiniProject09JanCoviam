package com.company;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XMLFileHandler implements MyFileHandler {
    public static int readCounter=0;

    @Override
    public  Employee read() {
        Employee emp= new Employee();
        int length=0;
        try {

            File fXmlFile = new File("/Users/apple/Downloads/employee.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("employee");
            //for (int temp = 0; temp < nList.getLength(); temp++) {
            length= nList.getLength();
            Node nNode = nList.item(XMLFileHandler.readCounter);
            XMLFileHandler.readCounter++;
//            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;


                String firstName= eElement.getElementsByTagName("firstName")
                        .item(0).getTextContent();
                String lastName= eElement.getElementsByTagName("lastName")
                        .item(0).getTextContent();

                String dateOfBirth= eElement.getElementsByTagName("dateOfBirth")
                        .item(0).getTextContent();

                String experience= eElement.getElementsByTagName("experience")
                        .item(0).getTextContent();

                emp.setFirstName(firstName);
                emp.setLastName(lastName);
                emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth));
                emp.setExperience(Double.parseDouble(experience));


            }
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(XMLFileHandler.readCounter<length)
        return emp;
        else
            return null;
    }
    @Override
    public void write(Employee data) {

    }

}