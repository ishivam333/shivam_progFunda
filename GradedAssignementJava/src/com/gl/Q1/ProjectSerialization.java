package com.gl.Q1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.gl.bean.EmployeeDetail;
import com.gl.bean.ProjectDetails;

public class ProjectSerialization {
	public ArrayList<EmployeeDetail> list1=new ArrayList<>();
public ArrayList<EmployeeDetail> list2=new ArrayList<>();



public void serialization(HashMap <ProjectDetails,ArrayList <EmployeeDetail>> h) throws IOException {
	FileOutputStream fos=new FileOutputStream("D:\\serial"); 
	ObjectOutputStream s=new ObjectOutputStream(fos); 
	try(fos;s){
	s.writeObject(h);	
		
	}

}

  public void deSerialization() throws FileNotFoundException,IOException, ClassNotFoundException  {
  FileInputStream f=new FileInputStream("D:\\serial");
  ObjectInputStream s=new ObjectInputStream(f);
 try(f;s){
	HashMap <ProjectDetails,ArrayList <EmployeeDetail>> k = (HashMap<ProjectDetails, ArrayList<EmployeeDetail>>) s.readObject();
	
	 for(ProjectDetails key:k.keySet()) { 
	  System.out.println(key);
	  System.out.println("employee are");
    for(EmployeeDetail v:k.get(key)) {
    	System.out.println(v);
    }
	 }
	 }
}
	public static void main(String[] args)  {
		ProjectSerialization d =new ProjectSerialization();
		HashMap <ProjectDetails,ArrayList <EmployeeDetail>> map = new HashMap<>();
		ProjectDetails project1 = new ProjectDetails("P1","Music Synthesizer",23);
		ProjectDetails project2 = new ProjectDetails("P2","Vehicle Movement Tracker",13);
		
		EmployeeDetail emp1=new EmployeeDetail("E001","Harsha","9383993933","RTNagar",1000);
		EmployeeDetail emp2=new EmployeeDetail("E002","Harish","9354693933","Jayanagar",2000);
		EmployeeDetail emp3=new EmployeeDetail("E003","Meenal","9383976833","Malleswaram",1500);
	    d.list1.add(emp1);
		d.list1.add(emp2);
		d.list1.add(emp3);
		EmployeeDetail emp4=new EmployeeDetail("E004","Sundar","9334593933","Vijayanagar",3000);
		EmployeeDetail emp5=new EmployeeDetail("E005","Suman","9383678933","Indiranagar",2000);
		EmployeeDetail emp6=new EmployeeDetail("E006","Suma","9385493933","KRPuram",1750);
		d.list2.add(emp4);
		d.list2.add(emp5);
		d.list2.add(emp6);
		map.put(project1,d.list1);
		map.put(project2,d.list2);
	    try {
			d.serialization(map);
			System.out.println("Done bro");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    try {
			d.deSerialization();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
