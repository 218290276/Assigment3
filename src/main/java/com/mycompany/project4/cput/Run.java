/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project4.cput;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Arisky
 */
public class Run {
    //Read Supplier Values
    public static void readSupplier(){
        
       try{
      try (FileInputStream file = new FileInputStream("stakeholder.ser"); ObjectInputStream su = new ObjectInputStream(file)) {
          
          Object mfacture = null;
          
          while (( mfacture  = su.readObject()) != null) {
              if (( mfacture instanceof Supplier)) {
                
                  System.out.println(((Supplier)  mfacture).toString());
              }
          }
          su.close();
          file.close();
      }
  } catch (IOException i) {
       System.out.println("Success");
      } catch (ClassNotFoundException c) {
         System.out.println("Object not found");
      } 
    }
  //Read Customer values    
    public static void readCustomer(){
        
        
       try{
      try (FileInputStream file = new FileInputStream("stakeholder.ser")) {
          ObjectInputStream in = new ObjectInputStream(file);
          
          Object person = null;
          
          while (( person  = in.readObject()) != null) {
              if (( person instanceof Customer)) {
                
                  System.out.println(((Customer)  person).toString());
              }
          }
          in.close();
          file.close();
      } 
  } catch (IOException i) {
       System.out.println("Success");
      } catch (ClassNotFoundException c) {
         System.out.println("Object not found");
      } 
    }
    
    

//ArrayList Customer
    public static void CustomerArrayList() throws FileNotFoundException, IOException, ClassNotFoundException {

        ArrayList<Customer> customerList = new ArrayList<>();

        FileInputStream file = new FileInputStream("stakeholder.ser");
        ObjectInputStream in = new ObjectInputStream(file);
        Customer customer1 = (Customer) in.readObject();
        Customer customer2 = (Customer) in.readObject();
        Customer customer3 = (Customer) in.readObject();
        Customer customer4 = (Customer) in.readObject();
        Customer customer5 = (Customer) in.readObject();
        Customer customer6 = (Customer) in.readObject();

        customerList.add(customer1);
        customerList.add(customer2);
         customerList.add(customer3);
         customerList.add(customer4);
         customerList.add(customer5);
         customerList.add(customer6);
        

        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i));
        }

    }
//Arraylist Supplier
    public static void SupplierArrayList() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Supplier> supplierList = new ArrayList<>();

        FileInputStream file = new FileInputStream("stakeholder.ser");
        ObjectInputStream su = new ObjectInputStream(file);
        Supplier supplier1 = (Supplier) su.readObject();
        Supplier supplier2 = (Supplier) su.readObject();
        Supplier supplier3 = (Supplier) su.readObject();
        Supplier supplier4 = (Supplier) su.readObject();
        Supplier supplier5 = (Supplier) su.readObject();

        supplierList.add(supplier1);
        supplierList.add(supplier2);
        supplierList.add(supplier3);
        supplierList.add(supplier4);
        supplierList.add(supplier5);

        for (int i = 0; i < supplierList.size(); i++) {
            System.out.println(supplierList.get(i));
        }
    }
    //Calculate Custoemr age
    public static void CalculateCustomerAge(){
        
        
    }
   
         ObjectOutputStream output;
        public void openFile(){
        try{
            output = new ObjectOutputStream( new FileOutputStream( "stakeholder.ser" ) ); 
            System.out.println("*** ser file created and opened for writing ***");               
        }
        catch (IOException ioe){
            System.out.println("error opening ser file: " + ioe.getMessage());
            System.exit(1);
        }
    }
    public void closeFile(){
        try{
        output.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("error closing ser file: " + ioe.getMessage());
            System.exit(1);
        }        
    }
     public  void writeToFileCustomer(){
        try{
           FileOutputStream fos = new FileOutputStream("CustomerOutFile.txt");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
          
           oos.close();
           System.out.println("File Saved");
        
       }//end try
        catch(IOException fnfe )
        {
            System.out.println(fnfe);
            System.exit(1);
        }
        finally{
            closeFile();
            System.out.println("*** file has been closed ***");               
        }
    }
     

    public static void main(String[] args) throws Exception {
       SupplierArrayList();
       readSupplier();
       readCustomer();
       CustomerArrayList();
   
       
       
    } 

}
