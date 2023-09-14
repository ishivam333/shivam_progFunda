package com.gl.Q2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.gl.bean.EmployeeDetail;
import com.gl.bean.ProjectDetails;
class Thread1 {
    private Map<ProjectDetails, ArrayList<EmployeeDetail>> map;

    public Thread1(Map<ProjectDetails, ArrayList<EmployeeDetail>> map) {
        this.map = map;
    }

    public synchronized void serializeMap() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("map.txt"))) {
            outputStream.writeObject(map);
            System.out.println("Serialize called by Producer");
            notify();
            wait();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deserializeMap() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("map.txt"))) {
            System.out.println("DeSerialize Called by Consumer");
            Map<ProjectDetails, ArrayList<EmployeeDetail>> deserializedMap = (Map<ProjectDetails, ArrayList<EmployeeDetail>>) inputStream.readObject();
            displayMap(deserializedMap);
            notify();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void displayMap(Map<ProjectDetails, ArrayList<EmployeeDetail>> map) {
    	
      for(Map.Entry<ProjectDetails, ArrayList<EmployeeDetail>> m : map.entrySet()) {
    	  ProjectDetails pobj = m.getKey();
    	  ArrayList<EmployeeDetail> e = m.getValue();
    	  System.out.println(pobj);
    	  for(EmployeeDetail emp:e) {
    		  
    		  System.out.println(emp);
    	  }
      }
    	
    }
}

class Producer extends Thread {
    private Thread1 obj;

    public Producer(Thread1 obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.serializeMap();
    }
}

class Consumer extends Thread {
    private Thread1 obj;

    public Consumer(Thread1 obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.deserializeMap();
    }
}
public class InterThread {
	

	 


	    public static void main(String[] args) {

	        HashMap<ProjectDetails, ArrayList<EmployeeDetail>> hMap1 = new HashMap<>();
	        HashMap<ProjectDetails, ArrayList<EmployeeDetail>> hMap2 = new HashMap<>();
	        HashMap<ProjectDetails, ArrayList<EmployeeDetail>> hMap3 = new HashMap<>();
	                

	        ArrayList <EmployeeDetail> eList1 = new ArrayList<EmployeeDetail>();
	        ArrayList <EmployeeDetail> eList2 = new ArrayList<EmployeeDetail>();
	        ArrayList <EmployeeDetail> eList3 = new ArrayList<EmployeeDetail>();
	        ArrayList <EmployeeDetail> eList4 = new ArrayList<EmployeeDetail>();
	        ArrayList <EmployeeDetail> eList5 = new ArrayList<EmployeeDetail>();
	        ArrayList <EmployeeDetail> eList6 = new ArrayList<EmployeeDetail>();
	        EmployeeDetail e1 = new EmployeeDetail("E001","Harsha","9383993933","RTNagar",1000);
	        EmployeeDetail e2 = new EmployeeDetail("E002","Harish","9354693933","Jayanagar",2000);
	        EmployeeDetail e3 = new EmployeeDetail("E003","Meenal","9383976833","Malleswaram",1500);
	        EmployeeDetail e4 = new EmployeeDetail("E004","Sundar","9334593933","Vijayanagar",3000);
	        EmployeeDetail e5 = new EmployeeDetail("E005","Suman","9383678933","Indiranagar",2000);
	        EmployeeDetail e6 = new EmployeeDetail("E006","Suma","9385493933","KRPuram",1750);
	        EmployeeDetail e7 = new EmployeeDetail("E007","Chitra","9383978933","Koramangala",4000);
	        EmployeeDetail e8 = new EmployeeDetail("E008","Suraj","9383992133","Malleswaram",3000);
	        EmployeeDetail e9 = new EmployeeDetail("E009","Manu","9345193933","RTNagar",2000);
	        EmployeeDetail e10 = new EmployeeDetail("E010","Kiran","9383975673","Koramangala",4000);
	        EmployeeDetail e11 = new EmployeeDetail("E011","Mrinal","9383992789","Malleswaram",3000);
	        EmployeeDetail e12 = new EmployeeDetail("E012","Mahesh","9345193763","RTNagar",2000);
	        eList1.add(e1);
	        eList1.add(e2);
	        eList2.add(e3);
	        eList2.add(e4);
	        eList3.add(e5);
	        eList3.add(e6);
	        eList4.add(e7);
	        eList4.add(e8);
	        eList5.add(e9);
	        eList5.add(e10);
	        eList6.add(e11);
	        eList6.add(e12);
	        ProjectDetails project1 = new ProjectDetails ("P1","Music Synthesizer",23);
	        ProjectDetails project2 = new ProjectDetails("P2","Vehicle Movement Tracker",13);
	        ProjectDetails project3 = new ProjectDetails ("P3","Liquid Viscosity Finder",15);
	        ProjectDetails  project4 = new ProjectDetails ("P4","InsuranceTool",23);
	        ProjectDetails  project5 = new ProjectDetails("P5","BankingTool",13);
	        ProjectDetails project6 = new ProjectDetails("P6","PayrollTool",15);
	        hMap1.put(project1, eList1);
	        hMap1.put(project2, eList2);
	        hMap2.put(project3, eList3);
	        hMap2.put(project4, eList4);
	        hMap3.put(project5, eList5);
	        hMap3.put(project6, eList6);


	        Thread1 obj1 = new Thread1(hMap1);
	        Thread1 obj2 = new Thread1(hMap2);
	        Thread1 obj3 = new Thread1(hMap3);

	        Producer p1 = new Producer(obj1);
	        Consumer c1 = new Consumer(obj1);

	        Producer p2 = new Producer(obj2);
	        Consumer c2 = new Consumer(obj2);

	        Producer p3 = new Producer(obj3);
	        Consumer c3 = new Consumer(obj3);

	        p1.start();
	        c1.start();
	        p2.start();
	        c2.start();
	        p3.start();
	        c3.start();
	        
	    }
	}
	


